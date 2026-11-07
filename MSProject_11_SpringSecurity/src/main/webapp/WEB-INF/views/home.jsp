
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>XYZ Bank Home</title>
</head>
<body>

<h1>Welcome to XYZ Bank</h1>

<a href="${pageContext.request.contextPath}/balance">
    Check Balance
</a>
<br><br>

<a href="${pageContext.request.contextPath}/offers">
    Show Offers
</a>
<br><br>

<a href="${pageContext.request.contextPath}/loanApprove">
    Approve Loan
</a>
<br><br>

<form action="${pageContext.request.contextPath}/logout"
      method="post">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}">
    <button type="submit">Logout</button>
</form>

</body>
</html>
