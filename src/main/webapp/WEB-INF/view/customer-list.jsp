<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>customer list</title>
</head>
<body>
	<h3>List of customers</h3>
	<hr>
	
		<input type="button" value="Add Customer"
			   onclick="window.location.href='showFormForAdd'; return false;" />
	
	<table>
		<tr>
			<th>ID</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Email</th>
			<th>Action</th>
		<tr>
		<c:forEach var="tempCustomer" items="${customers}">
		<c:url var="updateLink" value="/customer/showFormForUpdate">
			<c:param name="customerId" value="${tempCustomer.id}"/>
		</c:url>
		<c:url var="deleteLink" value="/customer/delete">
			<c:param name="customerId" value="${tempCustomer.id}"/>
		</c:url>
			<tr>
				<td>${tempCustomer.id }</td>
				<td>${tempCustomer.firstName }</td>
				<td>${tempCustomer.lastName }</td>
				<td>${tempCustomer.email }</td>
				<td>
					<a href="${updateLink }">Update</a>
					<a href="${deleteLink }"
					onclick="if(!(confirm('Are you sure?'))) return false">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
		<a href="${pageContext.request.contextPath }/menu">Back to menu</a>
	
</body>
</html>






