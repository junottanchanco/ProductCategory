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
	<h1>${category.name}</h1>
	
	<form action="/category/${category.id}" method="POST">
		<select name="product">
			<c:forEach items="${products}" var="product">
				<option value="${product.id}">${product.name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Add">
	</form>
	<h3>Products:</h3>
	<ul>
	<c:forEach items="${category.product}" var="product">
		<li><c:out value="${product.name}"/></li>
	</c:forEach>
	</ul>
</body>
</html>