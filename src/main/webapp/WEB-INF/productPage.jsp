<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
</head>
<body>
	<h1>${product.name}</h1>
	
	<form action="/products/${product.id}" method="POST">
		<select name="category">
			<c:forEach items="${categories}" var="category">
				<option value="${category.id}">${category.name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Add">
	</form>
	<h3>Categories:</h3>
	<ul>
	<c:forEach items="${product.categories}" var="category">
		<li><c:out value="${category.name}"/></li>
	</c:forEach>
	</ul>
</body>
</html>