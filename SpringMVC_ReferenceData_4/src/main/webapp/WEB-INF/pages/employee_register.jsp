<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="form"%>

<script>

function loadStates(){

    document.forms[0].action="statesurl";

    document.forms[0].submit();

}

</script>

<form:form modelAttribute="emp" method="post">

Country :

<form:select path="country"
             onchange="loadStates()">

    <form:options items="${countriesInfo}"/>

</form:select>

<br><br>

State :

<form:select path="state">

    <form:options items="${statesInfo}"/>

</form:select>

</form:form>