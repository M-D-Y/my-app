package ru.mdy.login_example.servlets;

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
		HttpSession session = request.getSession(true);

		UserBean user = (UserBean) session.getAttribute("currentSessionUser");
		if (user == null) {
			user = new UserBean();
			session.setAttribute("currentSessionUser", user);
			dispatch(request, response, "index.jsp");
		} else if (!user.isLogged()) {
			if ("login".equals(user.getAction())) {
				user.setUserName(request.getParameter("username"));
				user.setPassword(request.getParameter("password"));
				user = UserDAO.login(user);

			} else
				dispatch(request, response, "login.jsp");
		}
	}

	protected void dispatch(HttpServletRequest request, HttpServletResponse response, String page)
			throws javax.servlet.ServletException, java.io.IOException {
		request.getRequestDispatcher(page).forward(request, response);
	}

}
