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
	<div class="row">

		<a href="/namtvph13393/admin/accounts/create"
			class="btn btn-dark btn-lg" role="button">CREATE</a>
	</div>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">username</th>
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
					<td>${acc.fullname }</td>
					<td>${acc.email }</td>
					<td><img style="width: 100px" alt=""
						src="../../img/${acc.photo }"></td>

					<td>${acc.activated == 0 ? "In-active" : "active" }</td>
					<td>${acc.admin == 1 ? "Admin" : "Member"}</td>
					<td><a type="button"
						href="${pageContext.request.contextPath}/admin/accounts/edit/${acc.id}"
						class="btn btn-primary">Cập nhật </a>
					
						<button type="button" class="btn btn-danger"
							data-bs-toggle="modal" data-bs-target="#exampleModal_${acc.id}">
							Xóa</button> <!-- Modal delete-->
						<div class="modal fade" id="exampleModal_${acc.id}" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Xác nhận</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">Xóa User: ${acc.fullname}</div>
									<div class="modal-footer">
										<a type="button"
											href="${pageContext.request.contextPath}/admin/accounts/delete/${acc.id}"
											class="btn btn-primary">Xóa</a> <a type="button"
											class="btn btn-primary" data-bs-dismiss="modal">cancel</a>
									</div>
								</div>
							</div>
						</div>
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