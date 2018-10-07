package com.service;

import org.springframework.stereotype.Service;

import javax.naming.Name;
import java.sql.*;
import java.util.HashMap;
import java.util.*;


@Service
public class SQLInterpreter {
    private static DBUtil util;

    public SQLInterpreter() {
    }

    public SQLInterpreter(String type) {
        if (type.equals("MySQL")) {
            util = new MySQL_DBUtil();
        } else if (type.equals("Redshift")) {
            util = new Redshift_DBUtil();
        }
    }

    public Map<String, Object> getData(String query) {
        HashMap<String, Object> response = new HashMap<>();
        double start, end;
        start = System.currentTimeMillis();
        try {
            Connection conn = util.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            end = System.currentTimeMillis();
            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();
            response.put("status", "OK");
            List<List<String>> TotalResult = new ArrayList<>();
            List<String> NameCol = new ArrayList<>();
            for (int i = 1; i <= count; i++) {
                String name = rsmd.getColumnName(i);
                NameCol.add(name);
            }
            TotalResult.add(NameCol);
            while (rs.next()) {
                List<String> DataCol = new ArrayList<>();
                for (int i = 1; i <= count; i++) {
                    String name = rsmd.getColumnName(i);
                    String cur = rs.getString(name);
                    DataCol.add(cur);
                }
                TotalResult.add(DataCol);
            }
            response.put("result", TotalResult);
            response.put("time", (end - start) / 1000);

        } catch (SQLException e) {
            end = System.currentTimeMillis();
            String errorMessage = util.processException(e);
            response.put("status", "ERROR");
            response.put("result", errorMessage);
            response.put("time", (end - start) / 1000);
        }
        return response;
    }
}
