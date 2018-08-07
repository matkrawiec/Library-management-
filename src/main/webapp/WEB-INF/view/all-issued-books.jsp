<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>book list</title>
</head>
<body>
	<h3>List of all issued books</h3>
	<hr>
	<table>
		<tr>
			<th>ID</th>
			<th>Author</th>
			<th>Title</th>
			<th>Category</th>
		<tr>
		<c:forEach var="tempBook" items="${allIssuedBooks}">
			<tr>
				<td>${tempBook.id }</td>
				<td>${tempBook.author }</td>
				<td>${tempBook.title }</td>
				<td>${tempBook.category }</td>
			</tr>
		</c:forEach>
	</table>
		<a href="${pageContext.request.contextPath }/menu">Back to menu</a>
	
</body>
</html>
