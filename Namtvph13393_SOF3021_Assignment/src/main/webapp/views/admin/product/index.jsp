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
		<a href="/namtvph13393/admin/product/create"
			class="btn btn-dark btn-lg" role="button">CREATE</a>
	</div>
	<c:if test="${ empty products }">
		<p class="alert alert warning">Không có dữ liệu</p>
	</c:if>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">name</th>
				<th scope="col">price</th>
				<th scope="col">createdDate</th>
				<th scope="col">available</th>
				<th scope="col">category</th>
				<th scope="col">image</th>
				<th colspan="2">Acction</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products.content}" var="product">
				<tr>
					<td>${product.name }</td>
					<td>${product.price }</td>
					<td>${product.createdDate }</td>
					<td>${product.available }</td>
					<td>${(product.category).name }</td>
					<td><img style="width: 100px" alt=""
						src="../../img/${product.image }"></td>
					<td><a type="button"
						href="${pageContext.request.contextPath}/admin/product/edit/${product.id}"
						class="btn btn-primary">Cập nhật </a>

						<button type="button" class="btn btn-danger"
							data-bs-toggle="modal"
							data-bs-target="#exampleModal_${product.id}">Xóa</button> <!-- Modal delete-->
						<div class="modal fade" id="exampleModal_${product.id}"
							tabindex="-1" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Xác nhận</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">Xóa product: ${product.name} - id ${product.id}</div>
									<div class="modal-footer">
										<a type="button"
											href="${pageContext.request.contextPath}/admin/product/delete/${product.id}"
											class="btn btn-primary">Xóa</a> <a type="button"
											class="btn btn-primary" data-bs-dismiss="modal">cancel</a>
									</div>
								</div>
							</div>
						</div></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">

			<c:forEach var="index" begin="0" end="${ products.totalPages - 1 }">
				<li class="page-item"><a class="page-link"
					href="/namtvph13393/admin/accounts/index?page=${index}"> ${ index + 1 }</a>
				</li>
			</c:forEach>

		</ul>
	</nav>
</body>
</html>