<%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>

<html>

<body>

<h2>Employee Registration</h2>

<form:form action="register"
           method="post"
           modelAttribute="emp">

Name :

<form:input path="name"/>

<br><br>

Country :

<form:select path="country">

    <form:options items="${countriesInfo}"/>

</form:select>

<br><br>

<input type="submit" value="Register"/>

</form:form>

</body>

</html>