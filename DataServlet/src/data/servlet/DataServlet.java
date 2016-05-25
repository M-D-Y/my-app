package data.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.beans.MessageBean;
import data.beans.UserSessionBean;
import data.database.DAO;

//@WebServlet({ "/DataServlet" })
 @WebServlet("/controller")
public class DataServlet extends HttpServlet {
	private ServletConfig config;
	// Это наша JSP страница
	String page = "ShowData.jsp";

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	// http://www.javaprobooks.ru/java-программирование/jsp-передача-данных-сервлет.html
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserSessionBean userSession = (UserSessionBean) request.getAttribute("userSession");
		String action = request.getParameter("p");
		
		while (request.getParameterNames().hasMoreElements()) {
			String name = request.getParameterNames().nextElement();
			System.out.println(name);
		}
		if (userSession == null) {
			userSession = new UserSessionBean();
			userSession.setTargetAction("servlet");
			request.setAttribute("userSession", userSession);
			// сразу редиректим на логин
		}

		// PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		List<MessageBean> data = DAO.getAllMessages();
		request.setAttribute("data", data);
		StringBuffer sb = request.getRequestURL();
		
		if (sb.toString().endsWith(".jpg") || sb.toString().endsWith(".html")) {
			String page = sb.toString();
			page = page.substring(page.lastIndexOf("/")+1);
			dispatch(request, response, page);
		} else
		// Переходим на JSP страницу
		dispatch(request, response, "ShowData");
	}

	public void dispatch(HttpServletRequest request, HttpServletResponse response, String page) {
		
		if (!page.endsWith(".jsp"))
			page = page + ".jsp";
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			if (dispatcher != null)
				dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}