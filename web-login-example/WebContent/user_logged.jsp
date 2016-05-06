<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"
	import="ru.mdy.login_example.beans.UserBean"%>
<!-- <jsp:useBean id="user" class="ru.mdy.login_example.beans.UserBean" scope="session" / >
-->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1251">
<title>User Logged Successfully</title>
</head>
		<%
			UserBean currentUser = (UserBean) (session.getAttribute("currentSessionUser"));
		%>
<body>

	<center>


		Welcome
		<%=currentUser.getFirstName() + " " + currentUser.getLastName()%>
	</center>

</body>

</html>