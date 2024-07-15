package com.marketplace.processing;

import java.io.*;
import java.sql.*;

public class OracleJdbc {

    public static Connection ConnectDB() throws SQLException, ClassNotFoundException  {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        // jdbc : db type :addr @name:port:another name
        String url = "jdbc:oracle:thin:@pandora:1521:TWR";
        String name = "user";
        String pwd = "";
        Connection conn = DriverManager.getConnection(url, name, pwd);
        return conn;
    }
}
