<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Product</title>
</head>
<body>
	<h1>New Product</h1>
	
	<form:form action="/products/new" method="POST" modelAttribute="product">
		<form:errors path="name"/>
		<form:input type="text" path="name" placeholder="Product Name"/><br>
		<form:errors path="description"/>
		<form:textarea path="description" placeholder="describe the product..."/><br>
		<form:errors path="price"/>
		<form:input path="price" placeholder="$1.00"/><br>
		<br><input type="submit" value="create">
	</form:form>
</body>
</html>