<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
</head>
<body>

<h1 style="color:red;text-align:center">
    Edit Student
</h1>

<form:form action="edit" method="post" modelAttribute="student">

    <table border="1" bgcolor="cyan" align="center" cellpadding="8">

        <tr>
            <td>Student Id :</td>
            <td>
                <form:input path="id" readonly="true"/>
                <form:errors path="id" cssStyle="color:red"/>
            </td>
        </tr>

        <tr>
            <td>Student Name :</td>
            <td>
                <form:input path="name"/>
                <form:errors path="name" cssStyle="color:red"/>
            </td>
        </tr>

        <tr>
            <td>Gender :</td>
            <td>
                <form:radiobutton path="gender" value="Male"/> Male
                <form:radiobutton path="gender" value="Female"/> Female
                <br>
                <form:errors path="gender" cssStyle="color:red"/>
            </td>
        </tr>

        <tr>
            <td>Age :</td>
            <td>
                <form:input path="age"/>
                <form:errors path="age" cssStyle="color:red"/>
            </td>
        </tr>

        <tr>
            <td>Course :</td>
            <td>
                <form:input path="course"/>
                <form:errors path="course" cssStyle="color:red"/>
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Update Student"/>
            </td>
        </tr>

    </table>

</form:form>

</body>
</html>