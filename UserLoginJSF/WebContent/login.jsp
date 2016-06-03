<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<html>
<head>
<title>Login Page</title>
</head>
<body>
	<f:view>
		<h1>
			<h:outputText value="Login Page" />
		</h1>
		<h:form id="LoginForm">
			<h:outputText value="Enter Your Name:" />
			<h:inputText value="#{loginBean.userName}" />
			<h:commandButton action="welcome" value="OK" />

<br><br>on error<br><br>
<b>JasperException: Cannot find FacesContext</b>

<br><br>
Check your web.xml for Faces servlet mapping url pattern,
if the pattern is *.jsf or *.faces
then try to use exam.jsf or exam.faces
if the pattern is /faces/*
then try navigating to /faces/exam.jsp
			
		</h:form>
	</f:view>
</body>
</html>
