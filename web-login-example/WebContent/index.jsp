<%@page language="java" contentType="text/html; charset=windows-1251"
	pageEncoding="windows-1251"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style type="text/css">
h1 {
	color: #000099
}

table {
	width: 100%;
	border: 1px;
}

</style>
</head>
<!-- http://html5book.ru/css-colors/ -->
<body>
	<table>
		<tr>
			<td colspan="2" bgcolor="maroon" align="center">
			<%@include file="include/header.jsp"%>	</td>
		</tr>
		<tr>
			<td width="30%" valign="top" bgcolor="gray" align="center">
			<%@include file="include/leftmenu.jsp"%>	</td>
			<td width="70%" valign="top">
			<jsp:include page="include/main.jsp" flush="true"/> 
			
			</td>
		</tr>
		<tr>
			<td colspan="2" bgcolor="silver" align="center"> <%@include
					file="include/footer.jsp"%>
			</td>
		</tr>
	</table>
</body>
</html>
