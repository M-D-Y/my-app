<%@page language="java" contentType="text/html; charset=windows-1251"
	pageEncoding="windows-1251"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 
<jsp:useBean id="user" class="ru.mdy.login_example.beans.UserBean"
	scope="session" />
	 -->
<c:set var="userLogged" value="${user.logged}" scope="page" />
<table border=1>
	<tr>

		<th>-- main.jsp --</th>
	</tr>
	<tr>
		<td><c:if test="${userLogged}">
			</c:if> 
			<c:choose>
				<c:when test="${userLogged}">
					<c:out value="${'User logged!'}" />
				</c:when>
				<c:otherwise>					
					<jsp:include page="login.jsp"></jsp:include>
				</c:otherwise>
			</c:choose></td>
	</tr>

</table>


