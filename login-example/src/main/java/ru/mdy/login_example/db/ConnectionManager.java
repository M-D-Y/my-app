package ru.mdy.login_example.db;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class ConnectionManager {

	static Connection con;
	static String url;

	public static Properties getDataBaseProperties(String propertyFilePath) {
		InputStream in = null;
		Properties properties = new Properties();
		try {
			String fileName = Connection.class.getResource("/jdbc.properties").getPath();
			System.out.println(fileName);
			
			in = Connection.class.getResourceAsStream(propertyFilePath);
			System.out.println(new File("/").getAbsolutePath());
			System.out.println(in.toString());
			properties.load(in);
		} catch (Exception excp) {
			excp.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return properties;
	}

	public static Connection getConnection() {
		Properties connProperties = getDataBaseProperties("/jdbc.properties");
		Connection conn = null;
		if (!connProperties.isEmpty()) {
			String driver = connProperties.getProperty("jdbc.driver");
			if (driver != null)
				System.setProperty("jdbc.drivers", driver);
			try {
				conn = DriverManager.getConnection(connProperties.getProperty("jdbc.url"),
						connProperties.getProperty("jdbc.username"), connProperties.getProperty("jdbc.password"));
			}

			catch (SQLException ex) {
				ex.printStackTrace();
			}
		} else {
			System.out.println("Error loading jdbc.properties.");
		}
		return conn;
	}
}
