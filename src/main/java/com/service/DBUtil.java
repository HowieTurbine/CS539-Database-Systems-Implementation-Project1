package com.service;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBUtil {
    Connection getConnection();
    String processException(SQLException e);
}
