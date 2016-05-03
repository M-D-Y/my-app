package ru.mdy.login_example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.mdy.login_example.beans.UserBean;
import ru.mdy.login_example.db.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		try {

			UserBean user = new UserBean();
			user.setUserName(request.getParameter("un"));
			user.setPassword(request.getParameter("pw"));

			user = UserDAO.login(user);

			if (user.isValid()) {

				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				response.sendRedirect("user_logged.jsp"); // logged-in page
			}

			else
				response.sendRedirect("invalid_login.jsp"); // error page
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}
