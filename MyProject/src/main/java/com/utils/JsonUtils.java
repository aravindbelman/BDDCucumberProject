package com.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class JsonUtils {

    public static List<String> list = new ArrayList<>();

    public static String readJson(String filepath) throws IOException, ParseException {
        byte[] JSONByte = null;
        JSONByte = Files.readAllBytes(Paths.get(filepath));
        String fileContent = new String(JSONByte);
        return fileContent;
    }

    public static String getJSONValue(String filepath, String jsonPath) throws IOException, ParseException {
        String completeFileContent = String.valueOf(readJson(filepath));
        DocumentContext doc = JsonPath.parse(completeFileContent);
        String jsonValue = doc.read(jsonPath);
        return jsonValue;
    }

    public static List<String> get_JSON_Tag_Values(String JSON_Response_filepath, String jsonpathlist_filepath) throws IOException, ParseException {

        Properties prop = Commons.loadPropertiesFile(jsonpathlist_filepath);
        Enumeration e = prop.propertyNames();

        while (e.hasMoreElements()) {
            String prop_key = (String) e.nextElement();
            String jsonPathValue = prop.getProperty(prop_key);
            JsonUtils.getJSONValue(JSON_Response_filepath, prop_key);
            list.add(JsonUtils.getJSONValue(JSON_Response_filepath, prop_key));
        }

        return list;
    }

    public void writeJson(String pathToWriteFile, String jsonValue) {
        try {
            FileWriter file = new FileWriter(pathToWriteFile);

            // We can write any JSONArray or JSONObject instance to the file
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            JsonNode jsonNode = objectMapper.readTree(jsonValue);
            String prettyJson = objectMapper.writeValueAsString(jsonNode);
            file.write(prettyJson);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateJson(String filepath, String jsonPathToBeUpdated, String updatedValue) throws IOException, ParseException {

        String originalJson = readJson(filepath);
        DocumentContext doc = JsonPath.parse(originalJson);
        doc.set(jsonPathToBeUpdated, updatedValue);
        System.out.println("Value updated for: " + jsonPathToBeUpdated);
        writeJson(filepath, doc.jsonString());
    }
}

