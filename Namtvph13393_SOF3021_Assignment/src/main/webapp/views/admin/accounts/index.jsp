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
	<table class="table">
		<thead>
			<tr>
				<th scope="col">username</th>
				<th scope="col">password</th>
				<th scope="col">fullname</th>
				<th scope="col">email</th>
				<th scope="col">photo</th>
				<th scope="col">activated</th>
				<th scope="col">Role</th>
				<th colspan="2">Acction</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${data.content}" var="acc">
				<tr>
					<td>${acc.username }</td>
					<td>${acc.password }</td>
					<td>${acc.fullname }</td>
					<td>${acc.email }</td>
					<td>${acc.photo }</td>
					<td>${acc.activated == 0? "In-active" : "active" }</td>
					<td>${acc.admin == 1? "Admin" : "Member"}</td>
					<td><a href="/namtvph13393/admin/accounts/edit/${acc.id }"
						class="btn btn-primary">Update</a> <a 
						
						href="/namtvph13393/admin/accounts/delete/${acc.id }" class="btn btn-danger">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">

			<c:forEach var="index" begin="0" end="${ data.totalPages - 1 }">
				<li class="page-item"><a class="page-link"
					href="/namtvph13393/admin/accounts/index?page=${index}"> ${ index + 1 }</a>
				</li>
			</c:forEach>

		</ul>
	</nav>
</body>
</html>