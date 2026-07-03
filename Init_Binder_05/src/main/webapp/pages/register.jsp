<%@ taglib uri="http://www.springframework.org/tags/form"
prefix="form"%>

<h1 align="center">
Student Registration
</h1>

<form:form method="post"
           modelAttribute="student">

<table border="1" align="center">

<tr>
<td>Id</td>
<td>
<form:input path="id"/>
</td>
</tr>

<tr>
<td>Name</td>
<td>
<form:input path="name"/>
</td>
</tr>

<tr>
<td>Date Of Birth</td>
<td>
<form:input path="dob"/>
</td>
</tr>

<tr>
<td colspan="2">
<input type="submit" value="Register"/>
</td>
</tr>

</table>

</form:form>