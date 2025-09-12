package library;

import com.utils.Commons;
import com.utils.DB_Base;
import com.utils.JsonUtils;
import io.cucumber.datatable.DataTable;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
        if (application_type().equalsIgnoreCase("IMT") &&
                com.getProperty(filepath, "SDS_Transaction_Type").equalsIgnoreCase("RTGS")) {
            return com.getProperty(filepath, "SDS_Service_Name_IMT_RTGS");
        } else if (application_type().equalsIgnoreCase("IMT") &&
                com.getProperty(filepath, "SDS_Transaction_Type").equalsIgnoreCase("IMT")) {
            return com.getProperty(filepath, "SDS_Service_Name_IMT");
        } else {
            return com.getProperty(filepath, "SDS_Service_Name");
        }
    }

    public String getRequestType() {
        if (application_type().equalsIgnoreCase("IMT") &&
                com.getProperty(filepath, "SDS_Transaction_Type").equalsIgnoreCase("RTGS")) {
            return com.getProperty(filepath, "SDS_Request_Type_IMT_RTGS");
        } else if (application_type().equalsIgnoreCase("IMT") &&
                com.getProperty(filepath, "SDS_Transaction_Type").equalsIgnoreCase("IMT")) {
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
        String env = getEnvironment();
        List<List<String>> status_values = Statuses.asLists(String.class);

        try {
            String query = com.getProperty("Properties/" + env + "/DB.properties", "SDS_SwInteractMsgStatusTbl").trim();
            actual_sql = query.replaceAll("<<receipt_id>>", receipt_number);

            ResultSet actData = getDataTable(actual_sql, env, system, 1);
            System.out.println("Entries validation started...");

            List<String> expected_status = status_values.get(0);
            while (actData.next()) {
                actual_text = actData.getString("MSG_STATUS");

                for (int i = 0; i < expected_status.size(); i++) {
                    if (actual_text.equalsIgnoreCase(expected_status.get(i))) {
                        if (expected_status.get(i).equalsIgnoreCase("FILTER")) {
                            filterEntryCount++;
                        }
                        if (expected_status.get(i).equalsIgnoreCase("RECVD")) {
                            recvdEntryCount++;
                        }
                        if (expected_status.get(i).equalsIgnoreCase("ACK")) {
                            ackEntryCount++;
                        }
                    }
                }
            }

            if (filterEntryCount != 1) {
                System.out.println("\"And Validate the message status entries from swift_interact_message_status table in SDS\",\n" +
                        "                        \"The MSG_STATUS data contains FILTER in the table\",\n" +
                        "                        \"The FILTER entry is not present in Swift Interact Message Status Table\",\n" +
                        "                        \"F\"");
                result_status = "f";
            }

            if (recvdEntryCount != 1) {
                System.out.println("\"And Validate the message status entries from swift_interact_message_status table in SDS\",\n" +
                        "                        \"The MSG_STATUS data contains RECVD in the table\",\n" +
                        "                        \"The RECVD entry is not present in Swift Interact Message Status Table\",\n" +
                        "                        \"F\"");
                result_status = "f";
            }

            if (ackEntryCount != 1) {
                System.out.println("\"And Validate the message status entries from swift_interact_message_status table in SDS\",\n" +
                        "                        \"The MSG_STATUS data contains ACK in the table\",\n" +
                        "                        \"The ACK entry is not present in Swift Interact Message Status Table\",\n" +
                        "                        \"F\"");
                result_status = "f";
            }
        } catch (SQLException e) {
            System.out.println("\"And Validate the message status entries from swift_interact_message_status table in SDS\"\n" +
                    "                    \"The MSG_STATUS data contains expected data in the table\"\n" +
                    "                    \"The expected entries is not present for \" + receipt_number");
            e.printStackTrace();
        }

        if (result_status.equalsIgnoreCase("p")) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }
    }

}


