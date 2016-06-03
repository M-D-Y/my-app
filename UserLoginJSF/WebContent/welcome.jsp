<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<html>
<head>
<title>Welcome</title>
</head> 
<body>
<f:view>
<h3>
<h:outputText value="Welcome" />,
<h:outputText value="#{loginBean.userName}" /> to javawebtutor.com!
</h3>
</f:view>
</body> 
</html> 