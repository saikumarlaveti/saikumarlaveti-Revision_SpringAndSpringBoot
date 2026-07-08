<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h2>
<spring:message code="cust.registration.title"/>
</h2>

<table>

<tr>
<td>
<spring:message code="cust.registration.name"/>
</td>

<td>
<input type="text"/>
</td>
</tr>

<tr>
<td>
<spring:message code="cust.registration.address"/>
</td>

<td>
<input type="text"/>
</td>
</tr>

<tr>
<td>
<spring:message code="cust.registration.billAmt"/>
</td>

<td>
<input type="text"/>
</td>
</tr>

<tr>
<td colspan="2">

<input type="submit"
value="<spring:message code='cust.btn.register'/>">

</td>
</tr>

</table>