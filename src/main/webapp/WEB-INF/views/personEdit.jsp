<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/WEB-INF/styles/my.css" />" rel="stylesheet">
    <title>Person</title>
</head>
<body>
<h3>
    Enter Person.
</h3>


<form:form method="POST" modelAttribute="person" action="save">
    <div>
        Name:
        <form:input path="name"/>
        <form:errors path="name" cssClass="error"/>
    </div>

    <div>
        Age:
        <form:input path="age"/>
        <form:errors path="age" cssClass="error"/>
    </div>

    <button type="submit">Registration</button>
</form:form>

</body>
</html>