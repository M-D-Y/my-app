package ru.mdy.login_example.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.*;
import java.util.*;

public class ConnectionManager {

	static Connection con;
	static String url;

	public static Properties getDataBaseProperties(String propertyFile) {
		InputStream in = null;
		Properties properties = new Properties();
		try {
			in = Thread.class.getResourceAsStream(propertyFile);
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
		Properties connectionProperties = getDataBaseProperties("jdbc.properties");
		Connection connection = null;
		if (!connectionProperties.isEmpty()) {
			String driver = connectionProperties.getProperty("jdbc.driver");
			if (driver != null)
				System.setProperty("jdbc.drivers", driver);
			try {
				connection = DriverManager.getConnection(connectionProperties.getProperty("jdbc.url"),
						connectionProperties.getProperty("jdbc.username"), connectionProperties.getProperty("jdbc.password"));
//				connection = DriverManager.getConnection("jdbc:postgresql://vs362.imb.ru:5432/postgres", "postgres", "postgres");

			}

			catch (SQLException ex) {
				ex.printStackTrace();
			}
		} else {
			System.out.println("Error loading jdbc.properties.");
		}
		return connection;
	}
}
