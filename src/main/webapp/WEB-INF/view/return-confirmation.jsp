<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Return book confirmation</title>
</head>
<body>
	<h2>Return book confirmation</h2>
			<c:out value="${finalBook}"/>
			<c:out value="${finalCustomer}"/>
			<c:out value="${finalRental }"/>
			
			<c:url var="returnLink" value="/rental/confirmReturn">
			<c:param name="customerId" value="${finalCustomer.id }"/>
			<c:param name="bookId" value="${finalBook.id }"/>		
			<c:param name="rentalId" value="${finalRental.id }"/>
			</c:url>
			
			
			<form action="${returnLink}" method="post">
    		<button name="test1" value="test2">Return</button>
			</form>
			
			
	
</body>

</html>









