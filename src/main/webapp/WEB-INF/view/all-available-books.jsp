<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>book list</title>
</head>
<body>
	<h3>List of all available books</h3>
	<hr>
		    <form:form action="searchBooks" method="POST">
                Search book by title or author: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" />
            </form:form>
	
	<table>
		<tr>
			<th>ID</th>
			<th>Author</th>
			<th>Title</th>
			<th>Category</th>
			<th>Action</th>
		<tr>
		<c:forEach var="tempBook" items="${allAvailableBooks}">
		<c:url var="lendLink" value="/book/showFormForLend">
			<c:param name="bookId" value="${tempBook.id }"/>
		</c:url>
			<tr>
				<td>${tempBook.id }</td>
				<td>${tempBook.author }</td>
				<td>${tempBook.title }</td>
				<td>${tempBook.category }</td>
				<td><a href="${lendLink }">Lend</a>
				
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath }/menu">Back to menu</a>
</body>
</html>










