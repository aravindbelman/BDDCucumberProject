package com.utils;
import java.io.*;
import java.sql.*;
import java.util.HashMap;

public class DB_Base {
    public String isdbupdated = "";

    public Connection establishConnection(String env, String system)
            throws ClassNotFoundException, SQLException, FileNotFoundException {
        String DB_URL = "";
        String DB_userName = "";
        String DB_pwd = "";
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(DB_URL, DB_userName, DB_pwd);
        } catch (Exception e) {
            System.out.println("Please make sure to provide DB details * in DB.properties on respective environment");
        }
        return connection;
    }

    public ResultSet getDataTable(String expSQL, String env, String system, Integer tablerow) throws Exception {
            isdbupdated = "yes";
            Connection con = establishConnection(env, system);
            PreparedStatement p = null;
            ResultSet rSetp = null;
            String result_status = "p";

            HashMap<String, String> hm = new HashMap<>();
            int rows = 0;
            int count = 0;

            try {
                p = con.prepareStatement(expSQL);

                System.out.println("waiting for results...in Actual table");

                while (rows < tablerow && count < 200) {
                    rows = 0;
                    Thread.sleep(3000);
                    rSetp = p.executeQuery();
                    while (rSetp.next()) {
                        rows++;
                    }
                    count++;
                }

                if (rows < tablerow) {
                    isdbupdated = "no";
                } else {
                    isdbupdated = "yes";
                    rSetp = p.executeQuery();
                }
                System.out.println(rows);

            } catch (SQLException e) {
                System.out.println(e);
            }
            return rSetp;
        }

    public HashMap<String, HashMap> getAllDataFromTable(String expSql, String env, String system)
    {
        HashMap<String, HashMap> map2 = new HashMap<>();
        try {
            ResultSet rSetp = getDataTable(expSql, env, system, 1);
            ResultSetMetaData metadata = rSetp.getMetaData();
            int i = 1;

            while (rSetp.next()) {
                HashMap<String, String> map = new HashMap<>();
                for (int j = 1; j <= metadata.getColumnCount(); j++) {
                    try {
                        String colName = metadata.getColumnName(j);
                        String value = rSetp.getString(colName);
                        map.put(colName, value);
                    } catch (Exception ex) {
                        System.out.println("Could not instantiate column data");
                    }
                }
                map2.put("Row" + i, map);
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return map2;
    }


}
