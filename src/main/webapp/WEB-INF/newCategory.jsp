<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Category</title>
</head>
<body>
	<h1>New Category</h1>
	
	<form:form action="/category/new" method="POST" modelAttribute="category">
		<form:input type="text" path="name" placeholder="Product Category"/><br>
		<br><input type="submit" value="Create">
	</form:form>
</body>
</html>