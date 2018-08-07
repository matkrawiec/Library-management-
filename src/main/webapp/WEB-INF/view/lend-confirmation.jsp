<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Lend book confirmation</title>
</head>
<body>
	<h2>Lend book confirmation</h2>
			<c:out value="${finalBook}"/>
			<c:out value="${finalCustomer}"/>
			
			<c:url var="saveLink" value="/book/confirmRent">
			<c:param name="customerId" value="${finalCustomer.id }"/>
			<c:param name="bookId" value="${finalBook.id }"/>			
			</c:url>
			
			
			<form action="${saveLink}" method="post">
    		<button name="test1" value="test2">Lend</button>
			</form>
			
			
	
</body>

</html>









