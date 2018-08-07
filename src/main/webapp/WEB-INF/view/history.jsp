<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>history</title>
</head>
<body>
	<h3>History</h3>
	<hr>
	
	<table>
		<tr>
			<th>Rental ID</th>
			<th>Issue date</th>
			<th>Return date</th>
			<th>Book ID</th>
			<th>Book title</th>
			<th>Customer ID</th>
			<th>Customer first name</th>
			<th>Customer last name</th>
		<tr>
		<c:forEach var="tempRental" items="${rentalsHistory}">
		
			<tr>
				<td>${tempRental.id }</td>
				<td>${tempRental.issueDate }</td>
				<td>${tempRental.returnDate }</td>
				<td>${tempRental.book.id}</td>
				<td>${tempRental.book.title}</td>
				<td>${tempRental.customer.id }</td>
				<td>${tempRental.customer.firstName }</td>
				<td>${tempRental.customer.lastName }</td>
				

			</tr>
		</c:forEach>
	</table>
		<a href="${pageContext.request.contextPath }/menu">Back to menu</a>
	
</body>
</html>














