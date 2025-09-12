package com.utils;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.PropertiesConfigurationLayout;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

public class Commons {

    public static Properties loadPropertiesFile(String completefilePath) throws FileNotFoundException, FileNotFoundException {
        Properties prop = new Properties();
        FileInputStream fileInput = null;
        fileInput = new FileInputStream(completefilePath);

        // load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return prop;
    }

    public static String getProperty(String filePath, String propertyName) {
        Properties prop = null;
        try {
            prop = loadPropertiesFile(filePath);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String property = prop.getProperty(propertyName);
        return property;
    }

    public static void setProperty(String filePath, String key, String value) throws IOException, ConfigurationException {
        try {
            File file = new File(filePath);
            // Create config + layout
            PropertiesConfiguration config = new PropertiesConfiguration();
            PropertiesConfigurationLayout layout = new PropertiesConfigurationLayout();
            // Load existing properties
            try (FileReader reader = new FileReader(file)) {
                layout.load(config, reader);
            }
            // Update property
            config.setProperty(key, value);
            // Save back to file
            try (FileWriter writer = new FileWriter(file)) {
                layout.save(config, writer);
            }

        } catch (Exception e) {
            System.out.println("Please make sure to provide valid file path, key to write and the value to assign");
            e.printStackTrace();
        }
    }

    public String compareActualValues(String actual, String expected, String field, String tableName) throws Exception {
        if (expected != null) {
            expected = expected.trim().replaceAll("\\s+", " ");
            if (actual != null) {
                actual = actual.trim().replaceAll("\\s+", " ");
            } else {
                actual = "";
            }
            if (expected.equals(actual)) {
                System.out.println("pass");
            } else {
                System.out.println("fail");
            }
        }
        return "";
    }

    public static List<String> getPropertyKeys(String filepath) throws IOException, ParseException {
        List<String> list = new ArrayList<>();
        Properties prop = loadPropertiesFile(filepath);
        Enumeration<?> e = prop.propertyNames();

        while (e.hasMoreElements()) {
            String prop_key = (String) e.nextElement();
            list.add(prop_key);
        }

        return list;
    }

    public String getEnv(String application) throws Exception {
        String env = "";
        env = getProperty("E:/Git/DevOps/Practice/properties/Global.properties", "Environment").trim();
        env = getProperty("E:/Git/DevOps/Practice/properties/" + application + ".properties", "Env").trim();
        return env;
    }

    public static String generateUETR() {
        String UETR = "HVUETR//" + UUID.randomUUID().toString();
        System.out.println(UETR);
        return UETR;
    }

    public static String generateExecutionTime() {
        Date dNow = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formatDT = sdf.format(dNow);
        System.out.println(formatDT);
        return formatDT;
    }

    public static String selectDate() {
        Date dNow = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formatDT = sdf.format(dNow);
        System.out.println(formatDT);
        return formatDT;
    }

    public static String generateFutureWeekDay() {
        Date dNow = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        int dayOfWeekNum = c.get(Calendar.DAY_OF_WEEK);
        DateFormat formatter = new SimpleDateFormat("EEEE");
        String dayOfWeekString = formatter.format(c.getTime());

        c.setTime(date);
        c.add(Calendar.YEAR, 0);
        c.add(Calendar.MONTH, 0);
        c.add(Calendar.DATE, 0);

        switch (dayOfWeekString) {
            case "Friday":
                c.add(Calendar.DATE, 3);
                break;
            case "Saturday":
                c.add(Calendar.DATE, 2);
                break;
            default:
                c.add(Calendar.DATE, 1);
        }

        Date future_date = c.getTime();
        return sdf.format(future_date);
    }

    public static String generateEndTime() {
        Date dNow = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String formatDT = sdf.format(dNow);
        System.out.println(formatDT);
        return formatDT;
    }

    public enum comparisonType {
        equals, contains, equalsIgnoreDuplicate;
    }

    public boolean compareDataLists(List<String> actualList, List<String> expectedList, comparisonType type) {
        Set<String> actualUIValues = new HashSet<>();
        List<String> actualUIValuesList = new ArrayList<>();
        int count = 0;
        boolean flag = false;
        switch (type) {
            case equalsIgnoreDuplicate:
                if (actualList.size() == expectedList.size()) {
                    actualUIValues.addAll(actualList);
                    if (actualUIValues.size() == actualList.size()) {
                        flag = true;
                        if (flag == true) {
                            for (int i = 0; i < actualList.size(); i++) {
                                for (int j = 0; j < expectedList.size(); j++) {
                                    if (actualList.get(i).equals(expectedList.get(j))) {
                                        count++;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                if (count != actualList.size()) flag = false;
                break;

            case equals:
                if (actualList.size() == expectedList.size()) {
                    actualUIValues.addAll(actualList);
                    if (actualUIValues.size() == actualList.size()) {
                        flag = true;
                        if (flag == true) {
                            for (int i = 0; i < actualList.size(); i++) {
                                for (int j = 0; j < expectedList.size(); j++) {
                                    if (actualList.get(i).equals(expectedList.get(j))) {
                                        count++;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                if (count != expectedList.size()) flag = false;
                break;

            case contains:
                actualUIValues.addAll(actualList);
                List<String> list = new ArrayList<>();
                list.addAll(actualUIValues);
                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < expectedList.size(); j++) {
                        if (list.get(i).equals(expectedList.get(j))) {
                            count++;
                            break;
                        }
                    }
                }
                if (count != expectedList.size()) flag = false;
                break;
        }
        return flag;
    }

    public String getAccountNumber(String accountType) {
        String accountNumber = getProperty("./properties/accountDetails.properties", accountType);
        return accountNumber;
    }

    public String getDecodedValue(String encodedValue) throws Exception {
        String decodedString = "";
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedValue);
            decodedString = new String(decodedBytes);
        } catch (Exception e) {
            System.out.println("Please make sure to provide encoded value");
        }
        return decodedString;
    }

    public String getEncodedValue(String value) throws Exception {
        String encodedString = "";
        try {
            encodedString = Base64.getEncoder().encodeToString(value.getBytes());
        } catch (Exception e) {
            System.out.println("Please make sure to provide valid value for encoding.");
        }
        return encodedString;
    }

    public String getFilePathValue(String dataFileNameWithExtension) {
        String filePath = "";
        String scenarioName = getProperty("./global.properties", "currentScenarioName").trim();
        String featureName = getProperty("./global.properties", "currentPackageName").trim();
        String testType = getProperty("./global.properties", "TestingType").trim();
        filePath = "./TestData/" + featureName + "/" + testType + "/" + scenarioName + "/" + dataFileNameWithExtension;
        return filePath;
    }

    public static List<String> get_table_Columns_List(String filePath, String tableName) {
        List<String> list = new ArrayList<>();
        int i = 1;
        while (!getProperty(filePath, tableName + "_COL" + i).equals("END_OF_COLUMNS_FOR_" + tableName)) {
            list.add(getProperty(filePath, tableName + "_COL" + i).trim());
            i++;
        }
        return list;
    }

    public static String generateE2EID() {
        Date dNow = new Date();
        String E2EID = "";
        SimpleDateFormat ft = new SimpleDateFormat("yyMMddHmm");
        E2EID = "E2E" + ft.format(dNow);
        return E2EID;
    }

    public static String generateINSID() {
        Date dNow = new Date();
        String INSID = "";
        SimpleDateFormat ft = new SimpleDateFormat("yyMMddHmm");
        INSID = "INS" + ft.format(dNow);
        return INSID;
    }

    public static String generateReceiptID(String env, String transactionType) {
        Date dNow = new Date();
        String receiptId = "";
        SimpleDateFormat ft = new SimpleDateFormat("Hmmss");
        String datetime = ft.format(dNow);
        String receiptNumber = getProperty("./properties/" + env + "/Base.properties", "receiptID");

        if (transactionType.equalsIgnoreCase("onus")) {
            receiptId = receiptNumber + datetime + "OFAU01";
        } else if (transactionType.equalsIgnoreCase("offus")) {
            receiptId = receiptNumber + datetime + "ONAUT01";
        } else {
            System.out.println("Invalid transaction type");
        }

        return receiptId;
    }

    public static String generateSAPDateTime(String inputDateFormat) {
        DateTimeFormatter inputFormatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("EEE MMM dd yyyy HH:mm:ss").toFormatter(Locale.ENGLISH);

        LocalDateTime dateTime = LocalDateTime.parse(inputDateFormat, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = dateTime.format(outputFormatter);
        return formattedDate;
    }

    public static String getHeaderIdentifier(String sapAccount) {
        String value = sapAccount.substring(4);
        System.out.println(value);
        return value;
    }

    public static String getNewId() {
        String name = "Automation";
        System.out.println(name);
        return name;
    }

    public static String generateMsgIdentifierOn(String transactionType) {
        Date dNow = new Date();
        String MsgId = "";

        SimpleDateFormat ft = new SimpleDateFormat("yyMMddHmm");
        String datetime = ft.format(dNow);

        if (transactionType.equalsIgnoreCase("offus")) {
            MsgId = "OFAU01" + datetime;
        } else if (transactionType.equalsIgnoreCase("onus")) {
            MsgId = "ONAUT01" + datetime;
        } else {
            System.out.println("Invalid transaction type");
        }

        System.out.println(MsgId);
        return MsgId;
    }


}

