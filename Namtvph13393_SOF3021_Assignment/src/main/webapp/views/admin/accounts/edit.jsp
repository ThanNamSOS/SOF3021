<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<form:form method="POST"
		action="/namtvph13393/admin/accounts/update"
		modelAttribute="account">
		<div>
		<label>id</label>
			<form:input path="id" />
		</div>
		<div>
			<label>Fullname</label>
			<form:input path="fullname" />
		</div>
		<div>
			<label>Email</label>
			<form:input path="email" type="email" />
		</div>
		<div>
			<label>Username</label>
			<form:input path="username" />
		</div>
		<div>
			<label>Password</label>
			<form:password path="password" />
		</div>
		<div>
			<label>Photo</label>
			<form:input path="photo" />
		</div>
		<div>
			<label>Admin</label>
			<form:select path="fullname">
				<form:option value="0">Member</form:option>
				<form:option value="1">Admin</form:option>
			</form:select>
		</div>
		<button>Save</button>
	</form:form>
</body>
</html>