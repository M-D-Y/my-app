import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DataServlet")
class DataServlet extends HttpServlet {

private ServletConfig config;

// Это наша JSP страница

String page = "DataPage.jsp";

public void init(ServletConfig config)

throws ServletException {

this.config = config;

}


//http://www.javaprobooks.ru/java-программирование/jsp-передача-данных-сервлет.html
public void doGet(HttpServletRequest request, HttpServletResponse response)

throws ServletException, IOException {

PrintWriter out = response.getWriter();

// Устанавливаем соединение с БД

String connectionURL = "jdbc:postgresql://localhost:5432/message";

Connection connection = null;

ResultSet rs;

response.setContentType("text/html");

List dataList = new ArrayList();

try {

// Загружаем драйвер БД

Class.forName("org.postgresql.Driver");

// Подключаемся к БД

connection = DriverManager.getConnection(connectionURL, "root",
"root");

// Выбираем данные из БД

String sql = "select * from message";

Statement s = connection.createStatement();

s.executeQuery(sql);

rs = s.getResultSet();

while (rs.next()) {

// Сохраняем всё в список

dataList.add(rs.getInt("id"));

dataList.add(rs.getString("message"));

}

rs.close();

s.close();

} catch (Exception e) {

System.out.println("Exception is ;" + e);

}

request.setAttribute("data", dataList);

// Переходим на JSP страницу

RequestDispatcher dispatcher = request.getRequestDispatcher(page);

if (dispatcher != null) {

dispatcher.forward(request, response);

}

}

}