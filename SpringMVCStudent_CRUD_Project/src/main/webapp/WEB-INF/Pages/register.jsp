<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1 style="color:red;text-align:center">
    Register Student
</h1>

<form:form modelAttribute="student">

    <table border="1" bgcolor="cyan" align="center">

        <tr>
            <td>Student Id ::</td>
            <td>
                <form:input path="id"/>
            </td>
        </tr>

        <tr>
            <td>Student Name ::</td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>

        <tr>
            <td>Gender ::</td>
            <td>
                <form:input path="gender"/>
            </td>
        </tr>

        <tr>
            <td>Age ::</td>
            <td>
                <form:input path="age"/>
            </td>
        </tr>

        <tr>
            <td>Course ::</td>
            <td>
                <form:input path="course"/>
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Register Student"/>
            </td>
        </tr>

    </table>

</form:form>
