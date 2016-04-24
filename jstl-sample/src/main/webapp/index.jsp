<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!-- The JSTL tag library can be imported into your pages with the following directives:
https://www.apache.org/dist/tomcat/taglibs/taglibs-standard-1.2.5/README_bin.txt

CORE LIBRARY
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  XML LIBRARY
    <%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
  FMT LIBRARY 
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  SQL LIBRARY
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
  FUNCTIONS LIBRARY
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
-->

<!-- set new variable -->
<c:set var="jspVariable" value="sample value for jspVariable" />
<c:set var="test" value="10" />
<%@ page import="java.util.ArrayList"%>
<!-- лучше не использовать Java вставки, а пользоваться jstl тегами -->

<%
	ArrayList<String> numList = new ArrayList<String>();
	numList.add("one");
	numList.add("two");
	numList.add("three");
	request.setAttribute("numList", numList);
%>
<html>
<head>
<title></title>
</head>
<body>
	<!--  вывод переменной jspVariable из запроса -->
	<h1>jspVariable = ${jspVariable}</h1>
	<br>
	<!--  вывод переменной textA из запроса -->
	${textA} Tutorial:
	<br> http://www.tutorialspoint.com/jsp/jsp_sending_email.htm
	<!-- Пример вывода по условию -->
	<br>Результат сравнения:
	<br>

	<c:set var="num" scope="session" value="10" />
	<c:choose>
		<c:when test="${num <= 0}">
       Если num <= 0
    </c:when>
		<c:when test="${num > 1000}">
        Если num > 1000
    </c:when>
		<c:otherwise>
        Если не одно условие не есть верно.
    </c:otherwise>
	</c:choose>

	<ul>
		<li><b>Value of JSESSIONID Cookie:</b> <c:out value="${cookie.JSESSIONID.value}" /> 
		<li><b>User-Agent Header:</b> 
		<%-- Using [] syntax because of dash in name!--%>
			<c:out value='${header["User-Agent"]}' />
	</ul>

	<br>List is
	<c:if test="${ empty( numList ) }">
        empty
    </c:if>
	<c:if test="${! empty( numList ) }">
        n
	ot empty
    </c:if>
	<br> List values:
	<br>
	<ul>
		<c:forEach var="num" items="${numList}">
			<li><p>${num}</p> <c:out value="${num}" />
		</c:forEach>
	</ul>

</body>
</html>