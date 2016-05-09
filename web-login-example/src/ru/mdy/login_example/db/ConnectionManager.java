package ru.mdy.login_example.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class ConnectionManager {

	static Connection con;
	static String url;
	/*
	 * Where to place and how to read configuration resource files in servlet based application?
	 * http://stackoverflow.com/questions/2161054/where-to-place-and-how-to-read-configuration-resource-files-in-servlet-based-app/2161583#2161583
	 */
		
	public static Properties getDataBaseProperties(String propertyFile) {
		InputStream in = null;
		Properties properties = new Properties();
		try {
			//in = Thread.class.getResourceAsStream(propertyFile);
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			in = classLoader.getResourceAsStream(propertyFile);
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

	public static Connection getConnection() throws Exception {
		final String propertiesFile = "jdbc.properties";
		Properties connectionProperties = getDataBaseProperties(propertiesFile);
		Connection connection = null;
		if (connectionProperties.isEmpty() && connectionProperties.size()==0){
			throw new Exception("Error loading jdbc properties file: " + propertiesFile);
		}
		String driver = connectionProperties.getProperty("jdbc.driver");
		if (driver != null)
			//System.setProperty("jdbc.drivers", driver);
		try {
			connection = DriverManager.getConnection(connectionProperties.getProperty("jdbc.url"),
					connectionProperties.getProperty("jdbc.username"),
					connectionProperties.getProperty("jdbc.password"));
			// connection =
			// DriverManager.getConnection("jdbc:postgresql://vs362.imb.ru:5432/postgres",
			// "postgres", "postgres");

		}

		catch (SQLException ex) {
			ex.printStackTrace();
		}

		return connection;
	}
}
