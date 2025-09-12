package library;

import com.utils.Commons;
import com.utils.DB_Base;
import com.utils.JsonUtils;

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






}
