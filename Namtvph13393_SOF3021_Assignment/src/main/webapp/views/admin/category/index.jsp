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
		<a href="/namtvph13393/admin/category/create"
			class="btn btn-dark btn-lg" role="button">CREATE</a>
	</div>
	<c:if test="${ empty categorys }">
		<p class="alert alert warning">Không có dữ liệu</p>
	</c:if>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">id</th>
				<th scope="col">name</th>
				<th colspan="2"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categorys.content}" var="cate">
				<tr>
					<td>${cate.id }</td>
					<td>${cate.name }</td>
					<td><a href="/namtvph13393/admin/category/edit/${cate.id }"
						class="btn btn-primary">Update</a> <a
						href="/namtvph13393/admin/category/delete/${cate.id }"
						class="btn btn-danger">Delete</a></td>
						<td>
						<button type="button" class="btn btn-primary"
							data-bs-toggle="modal"
							data-bs-target="#exampleModal_${cate.id}">Xóa</button>
					</td>
				</tr>
				<!-- Modal delete category-->
				<div class="modal fade" id="exampleModal_${cate.id}"
					tabindex="-1" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Xác nhận xóa</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">Xác nhận xóa: ${cate.name }</div>
							<div class="modal-footer">
								<a type="button"
									href="/categories/delete?id=${cate.id}"
									class="btn btn-primary">Xóa</a> <a type="button"
									class="btn btn-primary" data-bs-dismiss="modal">cancel</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</tbody>
	</table>
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">

			<c:forEach var="index" begin="0" end="${ categorys.totalPages - 1 }">
				<li class="page-item"><a class="page-link"
					href="/namtvph13393/admin/category/index?page=${index}"> ${ index + 1 }</a>
				</li>
			</c:forEach>

		</ul>
	</nav>
</body>
</html>