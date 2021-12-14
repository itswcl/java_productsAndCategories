<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- Bootstrap JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<title>Starting page</title>
</head>
<body>
	
	<div class="container">
		<!-- SHOW DATA WITH EDIT ROUTE / DELETE FORM-->
		<h1> ${ category.name }</h1>
			<h3>Products: </h3>
		<ul>
			<c:forEach var="product" items="${ category.products }">
				<li>${ product.name }</li>
			</c:forEach>
		</ul>
			<form action="/category/addProduct/${ category.id }">
				<select name="products">
					<c:forEach var="product" items="${ products }">
						<c:if test="${ category.products.contains(product) == false }">
							<option value="${ product.id }">${ product.name }</option>
						</c:if>
					</c:forEach>
				</select>
				<input type="submit" value="Add" />
			</form>
	</div>
	
</body>
</html>