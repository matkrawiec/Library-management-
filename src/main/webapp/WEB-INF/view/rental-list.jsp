<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>return book</title>
</head>
<body>
	<h3>Return book</h3>
	<hr>
	
	<table>
		<tr>
			<th>Rental ID</th>
			<th>Issue data</th>
			<th>Book ID</th>
			<th>Book title</th>
			<th>Customer ID</th>
			<th>Customer first name</th>
			<th>Customer last name</th>
			<th>Action</th>
		<tr>
		<c:forEach var="tempRental" items="${rentals}">
		<c:url var="returnLink" value="/rental/return">
			<c:param name="bookId" value="${tempRental.book.id }"/>
			<c:param name="customerId" value="${tempRental.customer.id }"/>
			<c:param name="rentalId" value="${tempRental.id }"/>
		</c:url>
			<tr>
				<td>${tempRental.id }</td>
				<td>${tempRental.issueDate }</td>
				<td>${tempRental.book.id}</td>
				<td>${tempRental.book.title}</td>
				<td>${tempRental.customer.id }</td>
				<td>${tempRental.customer.firstName }</td>
				<td>${tempRental.customer.lastName }</td>
				<td><a href="${returnLink}">Return</a>
				

			</tr>
		</c:forEach>
	</table>
		<a href="${pageContext.request.contextPath }/menu">Back to menu</a>
	
</body>
</html>














