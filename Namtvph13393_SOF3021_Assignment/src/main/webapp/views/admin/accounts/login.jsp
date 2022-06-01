<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<form:form method="POST" action="/namtvph13393/admin/accounts/login"
		modelAttribute="account">
		<!-- Email input -->
		<div class="form-outline mb-4">
			<form:input type="email" class="form-control" path="email" />
			<label class="form-label" for="form2Example1">Email address</label>
		</div>

		<!-- Password input -->
		<div class="form-outline mb-4">
			<form:input type="password" class="form-control" path="password" />
			<label class="form-label" for="form2Example1">Password</label>
		</div>

		<button  class="btn btn-primary">Sign
			in</button>
	</form:form>
</body>
</html>