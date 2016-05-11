<%@page language="java" contentType="text/html; charset=windows-1251"
	pageEncoding="windows-1251"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="user" class="ru.mdy.login_example.beans.UserBean" scope="session" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1251">
<title>Login Page</title>
</head>

<body>

<c:if test="${user.valid}">
 You are not logged. Please logging again!
</c:if>

	<form action="LoginServlet">


		Please enter your username <input type="text" name="un" value="login-example"/><br>

		Please enter your password <input type="text" name="pw"  value="login-example"/> <input
			type="submit" value="submit">

	</form>
</body>
</html>