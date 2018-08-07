<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Customer form</title>
</head>
<body>
	<h2>Save customer form</h2>
	<form:form action="saveCustomer" modelAttribute="customer" method="POST">
	<form:hidden path="id"/>
	<table>
		<tr>
			<td>First Name:</td>
			<td><form:input path="firstName"/></td>
		<tr>
		<tr>
			<td>Last Name:</td>
			<td><form:input path="lastName"/></td>
		<tr>
		<tr>
			<td>Email:</td>
			<td><form:input path="email"/></td>
		<tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Save" class="save"/></td>
	</table>
	</form:form>
	<a href="${pageContext.request.contextPath }/customer/list">Back to list</a>
	
</body>

</html>




