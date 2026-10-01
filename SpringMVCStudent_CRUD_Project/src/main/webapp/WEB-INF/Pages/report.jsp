<%@ page isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<h1 style="color:red;text-align:center">
    Student Details
</h1>

<c:if test="${not empty resultMsg}">
    <h3 style="color:green;text-align:center">
        ${resultMsg}
    </h3>
</c:if>

<c:choose>

    <c:when test="${not empty std}">

        <table border="1" align="center" bgcolor="cyan">

            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>GENDER</th>
                <th>AGE</th>
                <th>COURSE</th>
                <th>EDIT</th>
            </tr>

            <c:forEach var="student" items="${std}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.gender}</td>
                    <td>${student.age}</td>s
                    <td>${student.course}</td>
                    <td><a href="edit?no=${student.id}"><img src=images/edit.png" width="50" height="50"/></a>
                    <a href="delete?no=${student.id}"><img src=images/delete.png" width="50" height="50"/></a></td>
                </tr>
            </c:forEach>

        </table>

    </c:when>

    <c:otherwise>
        <h2 style="color:red;text-align:center">
            No Students Found
        </h2>
    </c:otherwise>

</c:choose>

<br><br>

<h3 style="text-align:center">
    Total Students : ${std.size()}
</h3>

<br>

<h3 style="text-align:center">
    <a href="/">Home</a>
</h3>