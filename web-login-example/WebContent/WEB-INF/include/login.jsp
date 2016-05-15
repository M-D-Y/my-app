<%@page language="java" contentType="text/html; charset=windows-1251"
	pageEncoding="windows-1251"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="user" class="ru.mdy.login_example.beans.UserBean"
	scope="session" />
<jsp:setProperty name="user" property="action" value="login" />

<!--
<c:set target="${user}" property="action" value="login" />
  -->

<c:if test="${user.logged}">

</c:if>
<font color="red">You are not logged!<br> Please login...
</font>
<br>
<br>

<form action="LoginServlet">
	Please enter your username <input type="text" name="username"
		value="login-example" /> <br> Please enter your password <input
		type="text" name="password" value="login-example" /> <input
		type="submit" value="submit">

</form>
