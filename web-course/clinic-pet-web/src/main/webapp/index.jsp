<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<jsp:usebean id="mybean" class="ru.mdy.clinic.beans.TestBean" scope="request"></jsp:usebean>
<html>
<body>
<h2>This page render: ${mybean.currentCount}</h2>
</body>
</html>