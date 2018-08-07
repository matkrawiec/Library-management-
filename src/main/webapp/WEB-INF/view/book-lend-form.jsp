<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Lend book form</title>
</head>
<body>
	<h2>Lend book form</h2>
	
		<c:out value="${lendBook.id }"/>
		<table>
		<tr>
			<th>ID</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Email</th>
			<th>Action</th>
		<tr>
		<c:forEach var="tempCustomer" items="${customers}">
		<c:url var="lendLink" value="/book/showFormForLend/lendToCustomer">
			<c:param name="customerId" value="${tempCustomer.id }"/>
			<c:param name="bookId" value="${lendBook.id }"/>
		</c:url>
		
			<tr>
				<td>${tempCustomer.id }</td>
				<td>${tempCustomer.firstName }</td>
				<td>${tempCustomer.lastName }</td>
				<td>${tempCustomer.email }</td>
				<td><a href="${lendLink }">Lend</a></td>
				
				
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath }/book/allAvailableBooks">Back</a>
	
</body>

</html>




