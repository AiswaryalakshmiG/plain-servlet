package com.student.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
private static Connection connection = null;

public static Connection getConnection() {
	if (connection == null) {
		try (FileInputStream fis = new FileInputStream("src/db.properties")) {
			Properties props = new Properties();
			props.load(fis);

			String url = props.getProperty("db.url");
			String username = props.getProperty("db.username");
			String password = props.getProperty("db.password");

			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (IOException | SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	return connection;
}
}
