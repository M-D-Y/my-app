<%@page language="java" import="java.util.*, data.beans.MessageBean"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id="userSession" class="data.beans.UserSessionBean"
	scope="session">
	<jsp:setProperty name="userSession" property="*" />
</jsp:useBean>
<jsp:setProperty name="userSession" property="targetAction"	value="editMessage" />

<html>
<head>
<title>Данные из БД</title>
</head>
<style>
table {
	width: 100%;
	border: 2px;
}
</style>

<%
	Date startTime = new Date();
%>
<body>
{userSession.targetAction} = ${userSession.targetAction}
<img src="/DataServlet/WEB-INF/images/edit.jpg" />
<br>
	<form action="<%= request.getSession().getServletContext().getContextPath() %>" method="GET">
		<table border="1">
			<tr style="background-color: gray; color: white">
				<td width="119"><b>ID</b></td>
				<td width="168"><b>Message</b></td>
				<td></td>
			</tr>
			<%
				Iterator<MessageBean> itr;
			%>
			<%
				List<MessageBean> data = (List<MessageBean>) request.getAttribute("data");
				for (itr = data.iterator(); itr.hasNext();) {
					MessageBean bean = (MessageBean) itr.next();
			%>
			<tr>
	
				<td width="119"><%=bean.getId()%></td>
				<td width="168"><%=bean.getMessage()%></td>
				<td><input type="image" src="images/edit.jpg" value="<%=bean.getId()%>"></td>
			</tr>
			
			<%
				}
			%>
		</table>
		<br>
		
		<%
			Date endTime = new Date();
		%>
		created:
		<%=endTime%>
		time:
		<%=endTime.getTime() - startTime.getTime()%>
		<br>
		<input type="submit" value="Submit" />
	</form>
	
</body>
</html>