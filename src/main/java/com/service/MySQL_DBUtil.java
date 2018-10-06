package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL_DBUtil implements DBUtil {
    private static final String USERNAME = "Adithya";
    private static final String PASSWORD = "";
    private static final String M_CONN_STRING =
            "jdbc:mysql://cs539-instacart.ceosidlvumni.us-east-1.rds.amazonaws.com:3306/intacart";


    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public String processException(SQLException e) {
        System.err.println("Error message: " + e.getMessage());
        System.err.println("Error code: " + e.getErrorCode());
        System.err.println("SQL state: " + e.getSQLState());
        return ("Error message: " + e.getMessage() + " " + "Error code: " + e.getErrorCode() + " " + "SQL state: " + e.getSQLState());
    }

}
