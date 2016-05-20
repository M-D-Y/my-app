<%@page language="java" import="java.util.*, data.beans.MessageBean"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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

<% Date startTime = new Date(); %>
<body>
	<table border="1">
		<tr style="background-color: gray; color: white">
			<td width="119"><b>ID</b></td>
			<td width="168"><b>Message</b></td>
		</tr>
		<% Iterator<MessageBean> itr; %>
		<%
			List<MessageBean> data = (List<MessageBean>) request.getAttribute("data");
			for (itr = data.iterator(); itr.hasNext();) {
				MessageBean bean = (MessageBean) itr.next();
		%>
		<tr>

			<td width="119"><%=bean.getId()%></td>
			<td width="168"><%=bean.getMessage()%></td>

		</tr>
		<%
		}
		%>
	</table>
	<br>
	<% Date endTime = new Date(); %>
	created: <%= endTime %>
	time: <%= endTime.getTime() - startTime.getTime()%>
</body>
</html>