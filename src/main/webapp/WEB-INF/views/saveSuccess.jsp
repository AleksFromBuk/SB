<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/WEB-INF/styles/my.css" />" rel="stylesheet">
    <title>Person Saved Successfully</title>
</head>
<body>
<h3>
    Person Saved Successfully.
</h3>

<form:form method="POST" modelAttribute="person" action="edit">
    <div>
            ${name}
    </div>
    <div>
            ${age}
    </div>
    <button type="submit">Edit</button>
</form:form>
</body>
</html>