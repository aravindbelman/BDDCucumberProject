package library;

import com.utils.Commons;
import com.utils.DB_Base;
import com.utils.JsonUtils;
import io.cucumber.datatable.DataTable;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class SdValidations extends DB_Base {

    public static String Queue;
    public String xmlFile;
    static String isdbupdated = "";
    Commons com = new Commons();
    public String system = "sds";
    JsonUtils js = new JsonUtils();

    public String scenarioName = com.getProperty("Properties/Global.properties", "currentScenarioName");
    public String env = com.getProperty("Properties/Global.properties", "SDS_DB_Env");
    public String sds_source = com.getProperty("Properties/Global.properties", "SDS_Source_Name");
    public String service_name = com.getProperty("Properties/Global.properties", "SDS_Service_Name");
    public String request_type = com.getProperty("Properties/Global.properties", "SDS_Request_Type");
    public String sds_source_IMT = com.getProperty("Properties/Global.properties", "SDS_Source_Name_IMT");
    public String service_name_IMT = com.getProperty("Properties/Global.properties", "SDS_Service_Name_IMT");
    public String request_type_IMT = com.getProperty("Properties/Global.properties", "SDS_Request_Type_IMT");
    public String source = com.getProperty("Properties/Global.properties", "SDS_DB_Env");
    public String testingType = com.getProperty("Properties/Global.properties", "TestingType");
    String featureName = com.getProperty("Properties/Global.properties", "currentPackageName").trim();
    String filepath = "./TestData/" + featureName + "/TestData.properties";
    String application_type = com.getProperty("Properties/Global.properties", "Application_Type");
    String amt = "";

    public String application_type() {
        if (com.getProperty(filepath, "Application_Type").equals("IMT")) {
            return "IMT";
        }
        return "";
    }

    public String getServiceName() {
        if (application_type().equalsIgnoreCase("IMT") && com.getProperty(filepath, "SDS_Transaction_Type").equalsIgnoreCase("RTGS")) {
            return com.getProperty(filepath, "SDS_Service_Name_IMT_RTGS");
        } else if (application_type().equalsIgnoreCase("IMT") && com.getProperty(filepath, "SDS_Transaction_Type").equalsIgnoreCase("IMT")) {
            return com.getProperty(filepath, "SDS_Service_Name_IMT");
        } else {
            return com.getProperty(filepath, "SDS_Service_Name");
        }
    }

    public String getRequestType() {
        if (application_type().equalsIgnoreCase("IMT") && com.getProperty(filepath, "SDS_Transaction_Type").equalsIgnoreCase("RTGS")) {
            return com.getProperty(filepath, "SDS_Request_Type_IMT_RTGS");
        } else if (application_type().equalsIgnoreCase("IMT") && com.getProperty(filepath, "SDS_Transaction_Type").equalsIgnoreCase("IMT")) {
            return com.getProperty(filepath, "SDS_Request_Type_IMT");
        } else {
            return com.getProperty(filepath, "SDS_Request_Type");
        }
    }

    public String getEnvironment() {
        if (com.getProperty(filepath, "Environment").equals("")) {
            return com.getProperty(filepath, "SDS_DB_Env");
        } else {
            return com.getProperty(filepath, "Environment");
        }
    }

    public String getAmountKey() {
        if (application_type().equalsIgnoreCase("IMT")) {
            return "sourceAmount";
        } else {
            return "amount";
        }
    }

    public String getCreditAmountKey() {
        if (application_type().equalsIgnoreCase("IMT")) {
            return "creditAmount";
        } else {
            return "amt";
        }
    }

    public void swInteractHeaderValidation(String receipt_number) throws Exception {
        // ExecuteQuery eq = new ExecuteQuery();
        String actSql = null;
        String result_status = "";
        String env = getEnvironment();
        String query = com.getProperty("Properties/" + env + "/DB.properties", "SDS_swInteractHeaderTbl").trim();
        actSql = query.replaceAll("<<receipt_id>>", receipt_number);

        ResultSet actData = getDataTable(actSql, env, system, 1);
        if (actData != null) {
            if (isdbupdated.equalsIgnoreCase("no")) {
                System.out.println("Data not updated in Actual table within prescribed time limit");
                result_status = "db_not_updated";
            } else {
                System.out.println("Data is updated in Actual table within prescribed time limit");
                while (actData.next()) {
                    if (com.comparetwoValues(actData.getString("SOURCE"), sds_source, "SOURCE", "InteractHeader").equals("f")) {
                        result_status = "P";
                    } else if (com.comparetwoValues(actData.getString("SERVICE_NAME"), getServiceName(), "SERVICE_NAME", "InteractHeader").equals("f")) {
                        result_status = "P";
                    } else if (com.comparetwoValues(actData.getString("REQUEST_TYPE"), getRequestType(), "REQUEST_TYPE", "InteractHeader").equals("f")) {
                        result_status = "P";
                    } else {
                        result_status = "F";
                    }
                }
            }
        }

        if (result_status.equalsIgnoreCase("db_not_updated")) {
            System.out.println("fail");
        } else {
            System.out.println("pass");
        }
    }

    public String fetchXmlFromSwInteractMessageTbl(String receipt_number, String filePathNewXml) throws Exception {
        String actual_xml_text = null;
        String datapresent = null;
        ResultSet actData = null;
        FileWriter writer = null;
        String actual_xml_sql = null;
        String result_status = "F";
        String env = getEnvironment();
        Connection con = establishConnection(env, system);

        try {
            String query = com.getProperty("Properties/" + env + "/DB.properties", "SDS_SwInteractMessageTbl").trim();
            actual_xml_sql = query.replaceAll("<<receipt_id>>", receipt_number);
            actData = getDataTable(actual_xml_sql, env, system, 1);

            if (actData != null) {
                if (isdbupdated.equalsIgnoreCase("no")) {
                    System.out.println("Data not updated in Actual table within prescribed time limit");
                    datapresent = "no";
                } else {
                    datapresent = "yes";
                    System.out.println("XML Validation started");
                    while (actData.next()) {
                        actual_xml_text = actData.getString("ICT_MESSAGE_TEXT");
                    }

                    // Write actual XML to the file
                    File fileToBeModifiedNewMT = new File(filePathNewXml);
                    writer = new FileWriter(fileToBeModifiedNewMT);
                    writer.write(actual_xml_text);
                    writer.close();
                    con.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return datapresent;
    }

    public void validateEntriesFromSwInteractMsgStatusTbl(String receipt_number, String file_path, DataTable Statuses) throws Exception {
        String actual_text = null;
        int filterEntryCount = 0;
        int recvdEntryCount = 0;
        int ackEntryCount = 0;
        String result_status = "p";
        String actual_sql = null;
        env = getEnvironment();
        int i;
        List<List<String>> status_values = Statuses.asLists(String.class);

        try {
            String query = com.getProperty("Properties/" + env + "/DB.properties", "SDS_SwInteractMsgStatusTbl").trim();
            actual_sql = query.replaceAll("\\+receipt_id\\+", receipt_number);

            ResultSet actData = getDataTable(actual_sql, env, system, 1);
            System.out.println("Entries validation started");

            for (List<String> expected_status : status_values) {
                while (actData.next()) {
                    actual_text = actData.getString("MSG_STATUS");
                    System.out.println(actual_text);

                    for (i = 0; i < expected_status.size(); i++) {
                        if (actual_text.equalsIgnoreCase(expected_status.get(i))) {
                            if (expected_status.get(i).equalsIgnoreCase("filter")) {
                                filterEntryCount++;
                            }
                            if (expected_status.get(i).equalsIgnoreCase("recvd")) {
                                recvdEntryCount++;
                            }
                            if (expected_status.get(i).equalsIgnoreCase("ack")) {
                                ackEntryCount++;
                            }
                        }
                    }
                }
            }

            if (filterEntryCount != 1) {
                System.out.println("The FILTER entry is not present in Swift Interact Message Status Table");
                result_status = "f";
            }

            if (recvdEntryCount != 1) {
                System.out.println("The RECV entry is not present in Swift Interact Message Status Table");
                result_status = "f";
            }

            if (ackEntryCount != 1) {
                System.out.println("The ACK entry is not present in Swift Interact Message Status Table");
                result_status = "f";
            }
        } catch (SQLException e) {
            System.out.println("The expected entries is not present for " + receipt_number);
            e.printStackTrace();
        }

        if (result_status == "p") {
            System.out.println("swift_interact_msg_status data are as expected");
        } else {
            System.out.println("swift_interact_msg_status data are not as expected");
        }
    }

    public String swGphMessageValidation(String receipt_number, String filePathNewXml) throws Exception {
        String actual_xml_text = null;
        String datapresent = null;
        ResultSet actData = null;
        FileWriter writer = null;
        String actual_xml_sql = null;
        String result_status = "f";
        env = getEnvironment();
        Connection con = establishConnection(env, system);

        try {
            String query = com.getProperty("Properties/" + env + "/DB.properties", "SDS_swGphMessageTbl").trim();
            actual_xml_sql = query.replaceAll("\\+receipt_id\\+", receipt_number);

            actData = getDataTable(actual_xml_sql, env, system, 1);

            if (actData != null) {
                isdbupdated = "yes";
                if (isdbupdated.equalsIgnoreCase("no")) {
                    System.out.println("Data not updated in Actual table within prescribed time limit");
                    datapresent = "no";
                } else {
                    datapresent = "yes";
                    System.out.println("XML Validation started");
                    while (actData.next()) {
                        actual_xml_text = actData.getString("GPH_MESSAGE_TEXT");
                    }
                }
            }

            File fileToBeModifiednewMT = new File(filePathNewXml);
            writer = new FileWriter(fileToBeModifiednewMT);
            writer.write(actual_xml_text);
            writer.close();

            con.close();
        } catch (SQLException e) {
            System.out.println("The data is not present for " + receipt_number);
            e.printStackTrace();
        }

        return datapresent;
    }

    public void swGphMessageHeaderValidation(String receipt_number, String file_path, String testdata_filepath) throws Exception {
        String actual_xml_text = null;
        String datapresent = null;
        ResultSet actData = null;
        FileWriter writer = null;
        String actual_xml_sql = null;
        String result_status = "p";

        env = getEnvironment();
        Connection con = establishConnection(env, system);

        try {
            String query = com.getProperty("Properties/" + env + "/DB.properties", "SDS_swGphMessageHeaderTbl").trim();
            actual_xml_sql = query.replaceAll("\\+receipt_id\\+", receipt_number);

            actData = getDataTable(actual_xml_sql, env, system, 1);
            ResultSetMetaData metadata = actData.getMetaData();
            int columnCount = metadata.getColumnCount();

            if (actData != null) {
                isdbupdated = "yes";
                if (isdbupdated.equalsIgnoreCase("no")) {
                    System.out.println("Data not updated in Actual table within prescribed time limit");
                    datapresent = "no";
                } else {
                    datapresent = "yes";
                    System.out.println("Data is updated in the Database");
                    List<String> expected_values = com.getPropertyKeys(file_path);

                    while (actData.next()) {
                        if (com.comparetwoValues(actData.getString("P_DBT_AMT"), com.getProperty(testdata_filepath, getAmountKey()).trim(), "P_DBT_AMT", "swift_GPHMessage_header").equals("f")) {
                            result_status = "f";
                        }

                        if (com.comparetwoValues(actData.getString("P_CDT_AMT"), com.getProperty(testdata_filepath, getCreditAmountKey()).trim(), "P_CDT_AMT", "swift_GPHMessage_header").equals("f")) {
                            result_status = "f";
                        }

                        if (!application_type().equalsIgnoreCase("IMT")) {
                            if (com.comparetwoValues(actData.getString("P_BASE_AMT"), com.getProperty(testdata_filepath, getAmountKey()).trim(), "P_BASE_AMT", "swift_GPHMessage_header").equals("f")) {
                                result_status = "f";
                            }
                        }

                        if (com.comparetwoValues(actData.getString("P_STTLM_AMT"), com.getProperty(testdata_filepath, getAmountKey()).trim(), "P_STTLM_AMT", "swift_GPHMessage_header").equals("f")) {
                            result_status = "f";
                        }

                        for (int i = 0; i <= expected_values.size() - 1; i++) {
                            if (com.comparetwoValues(actData.getString(expected_values.get(i).replaceAll("Expected_", "").trim()), com.getProperty(file_path, expected_values.get(i)).trim(), actData.getString(expected_values.get(i).replaceAll("Expected_", "").trim()), "swift_GPHMessage_header").equals("f")) {
                                System.out.println(expected_values.get(i) + " is not matching");
                                result_status = "f";
                            }
                        }
                    }
                }
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("The data is not present for " + receipt_number);
            e.printStackTrace();
        }

        if (result_status == "p") {
            System.out.println("The data is as expected in Swift GPH Message Header Table");
            System.out.println("swift_GPH_Message_Header data are as expected");
        } else {
            System.out.println("swift_GPH_Message_Header data are not as expected");
        }
    }

    public void swGphMessageStatusValidation(String receipt_number, String file_path, DataTable Statuses) throws Exception {
        String actual_text = null;
        String result_status = "p";
        String actual_sql = null;
        int i = 0;
        int count = 0;

        String env = getEnvironment();
        String scenarioName = com.getProperty(file_path, "scenarioName").trim();
        List<String> expected_status = Statuses.values();
        List<String> actual_Status = new ArrayList<>();
        List<String> actual_Status_db = new ArrayList<>();
        Set<String> dbValues = new HashSet<>();

        try {
            String query = com.getProperty("Properties/" + env + "/DB.properties", "SDS_swGphMessageStatusTbl").trim();
            actual_sql = query.replaceAll("\\\\receipt_id\\\\", receipt_number);

            ResultSet actData = getDataTable(actual_sql, env, system, 1);
            System.out.println("Entries validation started");

            while (actData.next()) {
                actual_text = actData.getString("MSG_STATUS");
                System.out.println(actual_text);
                actual_Status.add(actual_text);
            }

            dbValues.addAll(actual_Status);
            actual_Status_db = actual_Status;

            if ((dbValues.size() < actual_Status.size())) {   // find duplicates
                System.out.println("All entries are not unique in swift_GPH_message_status table");
                result_status = "f";
            }

            if (!(scenarioName.equals("TimeoutId"))) {
                if (actual_Status.size() != expected_status.size()) { // check the size of expected and actual
                    result_status = "f";
                }
            }

            if (result_status.equals("p")) {
                for (i = 0; i < expected_status.size(); i++) {  // to check the contents of expected and actual
                    for (int j = 0; j < actual_Status.size(); j++) {
                        if ((expected_status.get(i).equals(actual_Status.get(j)))) {
                            count++;
                            if (!(scenarioName.equals("TimeoutId"))) {
                                actual_Status.remove(actual_Status.get(j));
                            }
                            if (actual_Status.isEmpty()) {
                                break;
                            }
                        }
                    }
                }
                if (count != expected_status.size()) {
                    result_status = "f";
                }
            }
        } catch (Exception e) {
            System.out.println("The expected entries is not present for " + receipt_number);
            e.printStackTrace();
        }

        if (result_status.equals("p")) {
            System.out.println("swift_GPH_message_status data are as expected");
        } else {
            System.out.println("swift_GPH_message_status data are not as expected");
        }
    }

    public Map<String, String> fetch_instrid_e2eid_utr(String receipt_number) throws Exception {
        Map<String, String> map = new HashMap<>();
        String actual_xml_text = null;
        String datasetpresent = null;
        ResultSet actData = null;
        FileWriter writer = null;
        String actual_xml_sql = null;
        String result_status = "p";
        String env = getEnvironment();

        Connection con = establishConnection(env, system);
        try {
            String query = com.getProperty("Properties/" + env + "/DB.properties", "SDS_mxTransactionTbl").trim();
            actual_xml_sql = query.replaceAll("\\\\receipt_id\\\\", receipt_number);

            actData = getDataTable(actual_xml_sql, env, system, 1);
            ResultSetMetaData metadata = actData.getMetaData();
            int columnCount = metadata.getColumnCount();

            if (actData != null) {
                isdbupdated = "yes";
                if (isdbupdated.equalsIgnoreCase("no")) {
                    System.out.println("Data not updated in Actual table within prescribed time limit");
                    datasetpresent = "no";
                } else {
                    datasetpresent = "yes";
                    System.out.println("Data is updated in the Database");

                    while (actData.next()) {
                        String instr_id = "Instruction_id";
                        String instr_id_value = actData.getString("INSTRUCTION_ID");
                        map.put(instr_id, instr_id_value);

                        String utr = "Utr";
                        String utr_value = actData.getString("UTR");
                        map.put(utr, utr_value);

                        String e2e_id = "e2e_id";
                        String e2e_id_value = actData.getString("E2E_ID");
                        map.put(e2e_id, e2e_id_value);

                        String purpose = "purpose";
                        String purpose_value = actData.getString("PURPOSE");
                        map.put(purpose, purpose_value);

                        String charge_bearer = "Charge_Bearer";
                        String charge_bearer_value = actData.getString("CHARGE_BEARER");
                        map.put(charge_bearer, charge_bearer_value);
                    }
                }
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("The data is not present for* " + receipt_number);
            e.printStackTrace();
        }
        return map;
    }

    public void swGphPaymentDetailsValidation(String receipt_number, String file_path, String basePropertyFile, String testdata_filepath) throws Exception {
        String datasetpresent = null;
        String actual_xml_sql = null;
        String result_status = "p";
        String env = getEnvironment();

        Connection con = establishConnection(env, system);
        HashMap<String, String> Actual_row_Data;
        HashMap<String, HashMap> ActualDataMap;

        try {
            String query = com.getProperty("Properties/" + env + "/DB.properties", "SDS_swGphPaymentDetailsTbl").trim();
            actual_xml_sql = query.replaceAll("\\\\receipt_id\\\\", receipt_number);

            // ActualDataMap = getAllDataFromTable(actual_xml_sql, env, system);
            ActualDataMap = getAllDataFromTable(actual_xml_sql, env, system);

            if (ActualDataMap != null) {
                isdbupdated = "yes";
                if (isdbupdated.equalsIgnoreCase("no")) {
                    System.out.println("Data not updated in Actual table within prescribed time limit");
                    datasetpresent = "no";
                } else {
                    datasetpresent = "yes";
                    System.out.println("Data is updated in the Database");

                    String key = "";
                    Iterator<Map.Entry<String, HashMap>> itr = ActualDataMap.entrySet().iterator();
                    while (itr.hasNext()) {
                        Map.Entry<String, HashMap> entry = itr.next();
                        if ((entry.getValue().get("STATUS")).equals("COMPLETED")) {
                            key = entry.getKey();
                            break;
                        }
                    }

                    System.out.println(key);
                    Actual_row_Data = ActualDataMap.get(key);
                    List<String> expected_values = com.getPropertyKeys(file_path);

                    if (testingType.equalsIgnoreCase("endtoend")) {
                        if (com.comparetwoValues(Actual_row_Data.get("UETR"), fetch_instrid_e2eid_utr(receipt_number).get("Utr"), "UETR", "GPH.PAYMENT.DTLS").equals("f")) {
                            result_status = "f";
                        }
                    }

                    if (com.comparetwoValues(Actual_row_Data.get("INSTRUCTION_IDENTIFICATION"), fetch_instrid_e2eid_utr(receipt_number).get("Instruction_id"), "INSTRUCTION_IDENTIFICATION", "GPH.PAYMENT.DTLS").equals("f")) {
                        result_status = "f";
                    }

                    if (!(application_type().equalsIgnoreCase("inward"))) {
                        if (com.comparetwoValues(Actual_row_Data.get("DEBIT_AMOUNT"), com.getProperty(testdata_filepath, getAmountKey()).trim(), "DEBIT_AMOUNT", "GPH.PAYMENT.DTLS").equals("f")) {
                            result_status = "f";
                        }
                    }

                    if (com.comparetwoValues(Actual_row_Data.get("CREDIT_AMOUNT"), com.getProperty(testdata_filepath, getAmountKey()).trim(), "CREDIT_AMOUNT", "GPH.PAYMENT.DTLS").equals("f")) {
                        result_status = "f";
                    }

                    for (int i = 0; i < expected_values.size(); i++) {
                        if (com.comparetwoValues(Actual_row_Data.get(expected_values.get(i).replaceAll("Expected_", "").trim()), com.getProperty(file_path, expected_values.get(i)).trim(), expected_values.get(i), "GPH.PAYMENT.DTLS").equals("f")) {
                            System.out.println(expected_values.get(i) + " not matching");
                            result_status = "f";
                        }
                    }
                }
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("The data is not present for GPH_PAYMENT_DTLS table for " + receipt_number);
            e.printStackTrace();
        }

        if (result_status.equals("p")) {
            System.out.println("The data is as expected in Swift GPH_PAYMENT_DTLS table");
            System.out.println("The data in GPH_PAYMENT_DTLS area as expected");
        } else {
            System.out.println("The data in GPH_PAYMENT_DTLS are not as expected");
        }
    }

    public void swGpMMessageHeaderValidation_IMT(String UETR, String file_path, String testdata_filepath) throws Exception {
        HashMap<String, HashMap> actData = null;
        String actual_xml_sql = "";
        String result_status = "p";
        String datapresent;
        String is_cov_scenario = "no";

        env = getEnvironment();

        // Set expected values from properties
        com.setProperty(filepath, com.getProperty(file_path, "Gph_Message_Header_LOCATOR"), com.getProperty(testdata_filepath, "Expected_E_END_TO_END_ID_COV"));
        com.setProperty(filepath, com.getProperty(file_path, "Gph_Message_Header_LOCATOR"), com.getProperty(testdata_filepath, "Expected_P010_TTSP_ID_COV"));
        com.setProperty(filepath, com.getProperty(file_path, "Gph_Message_Header_LOCATOR"), com.getProperty(testdata_filepath, "Expected_P_UNIQUE_E2E_REF_COV"));
        com.setProperty(filepath, com.getProperty(file_path, "Gph_Message_Header_LOCATOR"), com.getProperty(testdata_filepath, "Expected_P_UNIQUE_E2E_REF_COV"));
        com.setProperty(filepath, com.getProperty(file_path, "Gph_Message_Header_LOCATOR"), com.getProperty(testdata_filepath, "Expected_TOT_AMT_COV"));
        com.setProperty(filepath, com.getProperty(file_path, "Gph_Message_Header_LOCATOR"), com.getProperty(testdata_filepath, "Expected_TOT_AMT_COV"));
        com.setProperty(filepath, com.getProperty(file_path, "Gph_Message_Header_LOCATOR"), com.getProperty(testdata_filepath, "Expected_TOT_RATE_COV"));
        com.setProperty(filepath, com.getProperty(file_path, "Gph_Message_Header_LOCATOR"), com.getProperty(testdata_filepath, "Expected_TOT_RATE_COV"));
        com.setProperty(filepath, com.getProperty(file_path, "Gph_Message_Header_LOCATOR"), com.getProperty(testdata_filepath, "Expected_TOT_AMT_COV"));
        com.setProperty(filepath, com.getProperty(file_path, "Gph_Message_Header_LOCATOR"), com.getProperty(testdata_filepath, "Expected_P_DBTR_ACCT_LOC"));
        com.setProperty(filepath, com.getProperty(file_path, "Gph_Message_Header_LOCATOR"), com.getProperty(testdata_filepath, "Expected_TOT_RATE_COV"));
        com.setProperty(filepath, com.getProperty(file_path, "Gph_Message_Header_LOCATOR"), com.getProperty(testdata_filepath, "Expected_P_DBTR_ACCT_LOC"));
        com.setProperty(filepath, com.getProperty(file_path, "Gph_Message_Header_LOCATOR"), com.getProperty(testdata_filepath, "Expected_P_CRDT_ACCT_LOC"));
        com.setProperty(filepath, com.getProperty(file_path, "Gph_Message_Header_LOCATOR"), com.getProperty(testdata_filepath, "Expected_TOT_RATE_COV"));
        com.setProperty(filepath, com.getProperty(file_path, "Gph_Message_Header_LOCATOR"), com.getProperty(testdata_filepath, "Expected_P_CRDT_ACCT_LOC"));

        Connection con = establishConnection(env, system);

        try {
            String query = com.getProperty("Properties/" + env + "_db.properties", "SDS.swGpMMessageHeaderTbl_INT").trim();
            actual_xml_sql = query.replaceAll("\\+UETR\\+", UETR);

            actData = getAllDataFromTable(actual_xml_sql, env, system);

            if (actData != null) {
                isdbupdated = "yes";
                if (isdbupdated.equalsIgnoreCase("no")) {
                    System.out.println("Data not updated in Actual table within prescribed time limit");
                    datapresent = "no";
                } else {
                    datapresent = "yes";
                    System.out.println("Data is updated in the Database");

                    List<HashMap<String, String>> mapList = new ArrayList<>();
                    List<String> expected_valuesPacs008 = new ArrayList<>();
                    List<String> expected_valuesPacs009cov = new ArrayList<>();
                    List<String> expected_values = new ArrayList<>();

                    for (int i = 0; i < expected_values.size(); i++) {
                        if (expected_values.get(i).contains("_COV"))
                            expected_valuesPacs009cov.add(expected_values.get(i));
                        else expected_valuesPacs008.add(expected_values.get(i));
                    }
                    Iterator<Map.Entry<String, HashMap>> it = actData.entrySet().iterator();

                    while (it.hasNext()) {
                        Map.Entry<String, HashMap> entry = it.next();
                        mapList.add(new HashMap<>(actData.get(entry.getKey())));
                    }

                    if (mapList.size() > 1) {
                        is_cov_scenario = "yes";
                        System.out.println("This is a COVER scenario, hence checking for COVER values also");
                    }

                    for (int i = 0; i < mapList.size(); i++) {
                        HashMap<String, String> Actual_row_Data = mapList.get(i);

                        if (Actual_row_Data.get("MSG_TYPE").equalsIgnoreCase("pacs.009")) {
                            for (int j = 0; j < expected_valuesPacs009cov.size(); j++) {
                                String actualColKey = expected_valuesPacs009cov.get(j).replaceAll("Expected_", "").replaceAll("_COV", "").trim();
                                if (com.comparetwoValues(Actual_row_Data.get(actualColKey), com.getProperty(file_path, expected_valuesPacs009cov.get(j).trim()), com.getProperty(file_path, expected_valuesPacs009cov.get(j).trim()), "swift_GPHMessage_header").equals("f")) {
                                    System.out.println(expected_values.get(j) + " is not matching");
                                    result_status = "f";
                                }
                            }
                        } else {
                            for (int j = 0; j <= expected_valuesPacs008.size() - 1; j++) {
                                if (is_cov_scenario.equals("yes") && expected_valuesPacs008.get(j).replaceAll("Expected_", "").trim().equalsIgnoreCase("P_DBTR_ACCT_LOC")) {
                                    System.out.println("This is account key and account value validation");

                                    if (com.comparetwoValues(Actual_row_Data.get(expected_valuesPacs008.get(j).replaceAll("Expected_", "").trim().substring(0, 5)), com.getProperty(file_path, expected_valuesPacs008.get(j).trim()), com.getProperty(file_path, expected_valuesPacs008.get(j).trim()), "swift_GPHMessage_header").equals("f")) {
                                        System.out.println(expected_values.get(j) + " is not matching");
                                        result_status = "f";
                                    }
                                } else {
                                    if (com.comparetwoValues(Actual_row_Data.get(expected_valuesPacs008.get(j).replaceAll("Expected_", "").trim()), com.getProperty(file_path, expected_valuesPacs008.get(j).trim()), com.getProperty(file_path, expected_valuesPacs008.get(j).trim()), "swift_GPHMessage_header").equals("f")) {
                                        System.out.println(expected_values.get(j) + " is not matching");
                                        result_status = "f";
                                    }
                                }
                            }
                        }
                    }
                }
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("The data is not present for: " + UETR);
            e.printStackTrace();
        }

        if (result_status.equals("p")) {
            System.out.println("The data is as expected in Swift GPH Message Header Table");
            System.out.println("swift_GPH_Message_Header data are as expected");
        } else {
            System.out.println("swift_GPH_Message_Header data are not as expected");
        }
    }
}


