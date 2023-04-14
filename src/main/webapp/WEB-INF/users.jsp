<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Project Manager</title>

    <link rel="stylesheet" href="<spring:url value="/resources/css/homeUser.css"/>" type="text/css"/>

</head>
<body>


<div class="container">

    <h2>Users</h2>
    <table class="table table-hover">
        <tbody>
        <tr>
            <th>Username</th><th>Password</th><th>Role</th><th>Email</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.role}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>