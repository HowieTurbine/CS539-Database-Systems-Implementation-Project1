package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Redshift_DBUtil implements DBUtil {
    private static final String USERNAME = "awsuser";
    private static final String PASSWORD = "";
    private static final String M_CONN_STRING =
            "jdbc:redshift://redshift-cluster-1.coldsehstnov.us-east-1.redshift.amazonaws.com:5439/dev";


    public Connection getConnection() {
        try {
            Class.forName("com.amazon.redshift.jdbc.Driver");
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
