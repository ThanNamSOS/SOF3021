<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<form:form method="POST" action="${pageContext.request.contextPath}/admin/accounts/update/${idAccount}"
		modelAttribute="account">
			${messages }
		<div class="mb-3 col-6">
			<label for="exampleInputEmail1" class="form-label">Fullname</label>
			<form:input type="text" class="form-control" path="fullname" />
			${message }
			<form:errors path="fullname" class="form-text text-danger" />
		</div>
		<div class="mb-3 col-6">
			<label for="exampleInputEmail1" class="form-label">Email</label>
			<form:input type="email" class="form-control" path="email" />
			${message }
			<form:errors path="email" class="form-text text-danger" />
		</div>
		<div class="mb-3 col-6">
			<label for="exampleInputEmail1" class="form-label">Username</label>
			<form:input type="text" class="form-control" path="username" />
			${message }
			<form:errors path="username" class="form-text text-danger" />
		</div>

		<div class="mb-3 col-6">
			<label for="exampleInputEmail1" class="form-label">Password</label>
			<form:input class="form-control" path="password" />
			${message }
			<form:errors path="password" class="form-text text-danger" />
		</div>
		<div class="mb-3 col-6">
			<label for="exampleInputEmail1" class="form-label">Photo</label>
			<form:input type="file" class="form-control" path="photo" />
			${message }
			<form:errors path="photo" class="form-text text-danger" />
		</div>
		<div class="mb-3 col-6">
			<label>Admin</label>
			<form:select path="admin">
				<form:option value="0">Member</form:option>
				<form:option value="1">Admin</form:option>
				${message }
			<form:errors path="admin" class="form-text text-danger" />
			</form:select>
			
		</div>
		<button class="btn btn-dark">Save</button>
	</form:form>
</body>
</html>