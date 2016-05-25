<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>Это index.jsp</title>
</head>
<body>
	Это index.jsp
	<br>

<!--  -->
	<img src="images/edit.jpg" />
	
<!--  -->
	<%
		String imagePath;
		String contextPath = request.getContextPath();
	%>
	<br>
	<br> request.getContextPath()=<%=contextPath%>
	<br>
	<!--  -->
	<br> {pageContext.request.contextPath} =
	"${pageContext.request.contextPath}"
	<br>
	<img src="${pageContext.request.contextPath}" />
	<!--  -->
<jsp:forward page="controller" />
	
</body>
</html>