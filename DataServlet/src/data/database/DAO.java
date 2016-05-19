package data.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null)
			return connection;
		// Устанавливаем соединение с БД
		// String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
		String connectionURL = "jdbc:postgresql://vs362.imb.ru:5432/postgres";
		// Загружаем драйвер БД
		try {
			Class.forName("org.postgresql.Driver");
			// Подключаемся к БД
			try {
				connection = DriverManager.getConnection(connectionURL, "postgres", "postgres");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return connection;
	}

	private static ResultSet executeQuery(String sql) {
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			// Выбираем данные из БД
			statement = getConnection().createStatement();
			statement.executeQuery(sql);
			resultSet = statement.getResultSet();
			// rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;

	}

	private static List<String> transformToArrayListAndClose(ResultSet resultSet) {
		List data = new ArrayList();
		try {
			while (resultSet.next()) {
				// Сохраняем всё в список
				data.add(resultSet.getString("id"));
				data.add(resultSet.getString("message"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return data;
	}

	public static List<String> getAllRecords() {
		ResultSet resultSet = executeQuery("select * from message");
		return transformToArrayListAndClose(resultSet);
	}

	public static List<String> getMessageRecordByID(String id) {
		ResultSet resultSet = executeQuery("select * from message where id = " + id);
		return transformToArrayListAndClose(resultSet);
	}
}
