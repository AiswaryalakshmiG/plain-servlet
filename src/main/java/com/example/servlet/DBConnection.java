package com.example.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DBConnection {

    public static Connection getConnection() throws Exception {
        Properties props = new Properties();
        InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");

        if (input == null) {
            throw new RuntimeException("db.properties not found in classpath");
        }

        props.load(input);

        String driver = props.getProperty("jdbc.driver");
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        Class.forName(driver);
        return DriverManager.getConnection(url, username, password);
    }
}
