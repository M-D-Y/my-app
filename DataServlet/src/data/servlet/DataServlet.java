package data.servlet;

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

import data.database.DAO;

@WebServlet({ "/", "/DataServlet" })
// @WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	private ServletConfig config;
	// Это наша JSP страница
	String page = "ShowData.jsp";

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	// http://www.javaprobooks.ru/java-программирование/jsp-передача-данных-сервлет.html
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		List<String> data = DAO.getAllRecords();
		request.setAttribute("data", data);
		// Переходим на JSP страницу
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

}