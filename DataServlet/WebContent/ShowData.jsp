<%@page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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


<body>
	<table border = "1">
		<tr style="background-color:gray; color:white">
			<td width="119"><b>ID</b></td>
			<td width="168"><b>Message</b></td>
		</tr>
		<% Iterator<String> itr; %>
		<%
			List data = (List) request.getAttribute("data");
			for (itr = data.iterator(); itr.hasNext();) {
		%>
		<tr>

			<td width="119"> <%=itr.next()%> </td>
			<td width="168"> <%=itr.next()%> </td>
			
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>