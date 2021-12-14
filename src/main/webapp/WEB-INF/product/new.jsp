<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
		<h1>New Product</h1>
		<!-- ADD NEW CLASS FORM -->
		<form:form action="/product/new" method="post" modelAttribute="product">
    		<p>
       			<form:label path="name">Name: </form:label>
      			<form:errors path="name"/>
     			<form:input path="name"/>
    		</p>
    		<p>
       			<form:label path="description">Description </form:label>
      			<form:errors path="description"/>
     			<form:input path="description"/>
    		</p>
    		<p>
       			<form:label path="price">Price </form:label>
      			<form:errors path="price"/>
     			<form:input type="float" path="price"/>
    		</p>
    		<input type="submit" value="Submit"/>
		</form:form>
		


	</div>
	
</body>
</html>