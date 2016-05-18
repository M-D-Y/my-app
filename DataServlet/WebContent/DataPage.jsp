<%@page language="java" import="java.util.*"%>

<html>
<head>
<title>Данные из БД</title>
</head>
<style type="text/css">
table {
	width: 100%;
	border: 1px;
}
</style>


<body>
	<table>
		<tr>
			<td width="119"><b>ID</b></td>
			<td width="168"><b>Сообщение</b></td>
		</tr>
		<% Iterator<String> itr; %>
		<%
			List data = (List) request.getAttribute("data");
			for (itr = data.iterator(); itr.hasNext();) {
		%>
		<tr>
			<td width="119"><%=itr.next()%></td>
			<td width="168"><%=itr.next()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>