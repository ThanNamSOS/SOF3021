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
	<div class="col-3">
		<p class="alert alert warning">${ messages }</p>
		<form:form method="POST"
			action="${pageContext.request.contextPath}/loginForm"
			modelAttribute="account">
			<div class="form-outline mb-4 ">
				<label for="exampleInputEmail1" class="form-label">Email</label>
				<form:input type="text" class="form-control" path="email" />
				${message }
				<form:errors path="email" class="form-text text-danger" />
			</div>

			<!-- Password input -->
			<div class="form-outline mb-4">
				<label for="exampleInputEmail1" class="form-label">Password</label>
				<form:input type="password" class="form-control" path="password" />
				${message }
				<form:errors path="password" class="form-text text-danger" />
			</div>

			<button class="btn btn-primary">Sign in</button>
		</form:form>
	</div>
</body>
</html>