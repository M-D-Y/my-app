package data.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import data.beans.BeanFactory;
import data.beans.MessageBean;

public class DAO {
	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null)
			return connection;
		// Устанавливаем соединение с БД
		//String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
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

	private static BeanFactory executeQuery(String sql, BeanFactory factory) {
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			// Выбираем данные из БД
			statement = getConnection().createStatement();
			statement.executeQuery(sql);
			resultSet = statement.getResultSet();
			factory.add(resultSet);
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return factory;

	}


	public static List<MessageBean> getAllMessages() {
		BeanFactory result = executeQuery("select * from message", new BeanFactory(MessageBean.class));
		return (List<MessageBean>) result.getList();
	}

	public static List<MessageBean> getMessageRecordByID(String id) {
		BeanFactory result = executeQuery("select * from message where id = " + id, new BeanFactory(MessageBean.class));
		return (List<MessageBean>) result.getList();
	}
}
