
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>XYZ Bank Login</title>
</head>
<body>

<h1>XYZ Bank Login</h1>

<form action="${pageContext.request.contextPath}/login"
      method="post">

    <label>Username:</label>
    <input type="text" name="username" required>

    <br><br>

    <label>Password:</label>
    <input type="password" name="password" required>

    <br><br>

    <label>
        <input type="checkbox" name="remember-me">
        Remember Me
    </label>

    <br><br>

    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}">

    <button type="submit">Login</button>
</form>

<% if (request.getParameter("error") != null) { %>
    <p style="color:red">Invalid username or password!</p>
<% } %>

<% if (request.getParameter("logout") != null) { %>
    <p style="color:green">Successfully logged out!</p>
<% } %>

</body>
</html>
