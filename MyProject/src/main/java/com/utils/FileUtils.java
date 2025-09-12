package com.utils;

import org.xml.sax.InputSource;

import javax.xml.XMLConstants;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtils extends Commons {

    String Queue = null;

    public static void formatXml(String xml, String path) throws Exception {
        try {
            Files.deleteIfExists(Paths.get(path));
        } catch (NoSuchFileException e) {
            System.out.println("No such file/directory exists");
        }

        File file = new File(xml);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String data = "";
        String docHeader = "";

        while ((st = br.readLine()) != null) {
            st = st.replaceFirst("[\\s&&[^\\t]]+", ""); // Removing leading spaces except tabs
            data = data.concat(st);
        }

        // new_code
        StringBuilder xmlString = new StringBuilder(data);
        String appHeader = xmlString.substring(xmlString.indexOf("<AppHdr"),
                xmlString.indexOf("<Document xmlns"));

        try {
            docHeader = xmlString.substring(xmlString.indexOf("<Document xmlns"),
                    xmlString.indexOf("<!--"));
        } catch (Exception e) {
            docHeader = xmlString.substring(xmlString.indexOf("<Document xmlns"),
                    xmlString.lastIndexOf("</Envelope>"));
        }

        String[] strArray = {appHeader, docHeader};

        for (int i = 0; i < strArray.length; i++) {
            try {
                Transformer serializer = SAXTransformerFactory.newInstance().newTransformer();
                serializer.setOutputProperty(OutputKeys.INDENT, "yes");
                serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

                Source xmlSource = new SAXSource(new InputSource(new ByteArrayInputStream(strArray[i].getBytes())));
                StreamResult res = new StreamResult(new ByteArrayOutputStream());
                serializer.transform(xmlSource, res);

                String xmlStr = new String(((ByteArrayOutputStream) res.getOutputStream()).toByteArray());
                String arrOfStr = null;

                if (i == 0) {
                    arrOfStr = xmlStr.substring(xmlStr.indexOf("<AppHdr"), xmlStr.lastIndexOf("\n"));
                } else {
                    arrOfStr = xmlStr.substring(xmlStr.indexOf("<Document"), xmlStr.lastIndexOf("\n"));
                }

                byte[] arr = arrOfStr.getBytes();

                try {
                    Files.write(Paths.get(path), arr); // Write bytes to file
                    FileWriter fw = new FileWriter(path, true); // Append mode
                    fw.write("\n");
                    fw.close();
                } catch (IOException e) {
                    System.out.print("Invalid Path");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void formatXml_gph(String xml, String path) throws Exception {
        try {
            Files.deleteIfExists(Paths.get(path));
        } catch (NoSuchFileException e) {
            System.out.println("No such file/directory exists");
        }

        File file = new File(xml);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String data = "";
        String docHeader = null;

        while ((st = br.readLine()) != null) {
            st = st.replaceFirst("[\\s&&[^\\n]]+", "");
            data = data.concat(st);
        }

        StringBuilder xmlString = new StringBuilder(data);
        docHeader = xmlString.substring(xmlString.indexOf("<Document xmlns"));

        String[] strArray = { docHeader };
        for (int i = 0; i < strArray.length; i++) {
            try {
                Transformer serializer = SAXTransformerFactory.newInstance().newTransformer();
                serializer.setOutputProperty(OutputKeys.INDENT, "yes");
                serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

                Source xmlSource = new SAXSource(new InputSource(new ByteArrayInputStream(strArray[i].getBytes())));
                StreamResult res = new StreamResult(new ByteArrayOutputStream());
                serializer.transform(xmlSource, res);

                xml = new String(((ByteArrayOutputStream) res.getOutputStream()).toByteArray());

                String arrOfStr = null;
                if (i == 0) {
                    arrOfStr = xml.substring(xml.indexOf("<AppHdr>"), xml.lastIndexOf("\n"));
                } else {
                    arrOfStr = xml.substring(xml.indexOf("<Document"), xml.lastIndexOf("\n"));
                }

                byte[] arr = arrOfStr.getBytes();
                try {
                    FileWriter fw = new FileWriter(path, true);
                    fw.write(arrOfStr);
                    fw.close();
                } catch (IOException ex) {
                    System.out.print("Invalid Path");
                }
            } catch (Exception e) {
                // TODO log error
                e.printStackTrace();
                System.out.println(xml);
            }
        }
    }


    public static void modifyXmlFile(String filePath, String filePathnew, HashMap<String, String> datamap) {
        int count = 0;
        BufferedReader reader = null;
        FileWriter writer = null;
        StringBuilder content = new StringBuilder();

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                for (Map.Entry<String, String> entry : datamap.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();

                    if (line.contains(key)) {
                        line = line.replace(key, value);
                        count++;
                        System.out.println(key + " has been replaced by " + value);
                    }
                }
                content.append(line).append(System.lineSeparator());
            }

            // Rewriting the input text file with newContent
            writer = new FileWriter(filePathnew);
            writer.write(content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Closing the resources
                if (reader != null) reader.close();
                if (writer != null) {
                    writer.close();
                    String result = "Pass";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> getXmlTags(String filePath, String system) {
        List<String> list = new ArrayList<>();
        int i = 1;
        while (!(getProperty(filePath, system + "_tag" + i).equals("end of tags for " + system))) {
            // System.out.println(getProperty(filePath, system + "_tag" + i).trim());
            list.add(getProperty(filePath, system + "_tag" + i).trim());
            i++;
        }
        return list;
    }

    public static String prettyFormat(String input, int indent) {
        try {
            Source xmlInput = new StreamSource(new StringReader(input));
            StringWriter stringWriter = new StringWriter();
            StreamResult xmlOutput = new StreamResult(stringWriter);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", indent);
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");

            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(xmlInput, xmlOutput);

            return xmlOutput.getWriter().toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




}