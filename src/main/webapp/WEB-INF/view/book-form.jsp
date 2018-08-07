<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Save book form</title>
</head>
<body>
	<h2>Save book form</h2>
	<form:form action="saveBook" modelAttribute="book" method="POST">
	<form:hidden path="id"/>
	<form:hidden path="availability"/>
	<table>
		<tr>
			<td>Author:</td>
			<td><form:input path="author"/></td>
		<tr>
		<tr>
			<td>Title:</td>
			<td><form:input path="title"/></td>
		<tr>
		<tr>
			<td>Category:</td>
			<td><form:input path="category"/></td>
		<tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Save" class="save"/></td>
	</table>
	</form:form>
	<a href="${pageContext.request.contextPath }/book/allBooks">Back to list</a>
	
</body>

</html>




