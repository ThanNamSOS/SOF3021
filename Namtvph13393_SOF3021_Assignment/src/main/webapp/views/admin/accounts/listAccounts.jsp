<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	
	<table class="table">
		<thead>
			<tr>
				<th scope="col">username</th>
				<th scope="col">password</th>
				<th scope="col">fullname</th>
				<th scope="col">email</th>
				<th scope="col">photo</th>
				<th scope="col">activated</th>
				<th scope="col">admin</th>
				<th colspan="2"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listAcc}" var="acc">
				<tr>
					<td>${acc.username }</td>
					<td>${acc.password }</td>
					<td>${acc.fullname }</td>
					<td>${acc.email }</td>
					<td>${acc.photo }</td>
					<td>${acc.activated }</td>
					<td>${acc.admin }</td>
					<td>
					<a href="/namtvph13393/admin/accounts/edit/${acc.id }" class="btn btn-primary" >Update</a>
					<a  class="btn btn-primary">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>