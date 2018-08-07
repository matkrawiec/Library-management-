<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>book list</title>
</head>
<body>
	<h3>List of all books</h3>
	<hr>
	
	<input type="button" value="Add Book"
			   onclick="window.location.href='showFormForAdd'; return false;" />
	
	<table>
		<tr>
			<th>ID</th>
			<th>Author</th>
			<th>Title</th>
			<th>Category</th>
			<th>Availability</th>
			<th>Action</th>
		<tr>
		<c:forEach var="tempBook" items="${allBooks}">
		<c:url var="updateLink" value="/book/showFormForUpdate">
			<c:param name="bookId" value="${tempBook.id }"/>
		</c:url>
			<tr>
				<td>${tempBook.id }</td>
				<td>${tempBook.author }</td>
				<td>${tempBook.title }</td>
				<td>${tempBook.category }</td>
				<td>${tempBook.availability }</td>
				<td><a href="${updateLink }">Update</a></td>
			</tr>
		</c:forEach>
	</table>
		<a href="${pageContext.request.contextPath }/menu">Back to menu</a>
	
</body>
</html>














