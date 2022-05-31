<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT16309 - Create Category</title>
</head>
<body>
	<form:form method="POST"
		action="/namtvph13393/admin/category/store"
		modelAttribute="category">
		<div>
			<label>Name</label>
			<form:input path="name" />
		</div>
		<button>Save</button>
	</form:form>
</body>
</html>