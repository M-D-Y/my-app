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
		/*
		String servletPath = request.getServletPath();
		 ServletContext context = request.getServletContext();
		 //context.get
		String action = request.getParameter("Action");
		if (action!=null && action.equals("/account")) {
			// the account page
			dispatch(request, response, "/content/account.jsp");
		} else if (action!=null && action.equals("/edit")) {
			// the popup edit page
			dispatch(request, response, "/content/edit.jsp");
		}


		String uri = request.getRequestURI().toString();
		String root = uri.substring(0, uri.lastIndexOf('/'));

		
		  Enumeration<String> attributes = session.getAttributeNames();
		  
		  while (attributes.hasMoreElements()){ String attr =
		  attributes.nextElement();
		  System.out.println(session.getAttribute(attr)); }
		 
		Enumeration<String> parameters = request.getParameterNames();
		while (parameters.hasMoreElements()) {
			String parameter = parameters.nextElement();
			System.out.println(parameter);
			response.getWriter().write(parameter);

		}
		*/
		UserBean user = (UserBean) session.getAttribute("currentSessionUser");
		if (user == null) {
			user = new UserBean();
			session.setAttribute("currentSessionUser", user);
			dispatch(request, response, "login.jsp");			
		}
		if (user.isValid()==false) user = UserDAO.login(user);
		/*
		 * 		

		 * 
		 * 
		 * try { if (user.isValid()) {
		 * user.setUserName(request.getParameter("un"));
		 * user.setPassword(request.getParameter("pw"));
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * response.sendRedirect("user_logged.jsp"); // logged-in page }
		 * 
		 * else response.sendRedirect("invalid_login.jsp"); // error page }
		 * 
		 * catch (Throwable theException) { System.out.println(theException); }
		 * } else { request.getRequestDispatcher("login.jsp").forward(request,
		 * response); }
		 */
	}

	protected void dispatch(HttpServletRequest request, HttpServletResponse response, String page)
			throws javax.servlet.ServletException, java.io.IOException {
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
//		dispatcher.forward(request, response);
		request.getRequestDispatcher(page).forward(request, response);
	}

}
