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
	<c:if test="${ empty products }">
		<p class="alert alert warning">Không có dữ liệu</p>
	</c:if>
	<div class="row">
		<c:forEach items="${products.content}" var="product">
			<div class="card col-3" style="width: 18rem;">
				<img src="${pageContext.request.contextPath}/img/${product.image}"
					class="card-img-top">
				<div class="card-body">
					<h5 class="card-title">Ten SP: ${product.name }</h5>
					<h5 class="card-title">Gia: ${product.price }</h5>
					<h5 class="card-title">The loai: ${(product.category).name }</h5>

				</div>
				<div class="card-footer text-muted">
					<a href="#" class="btn btn-primary">ADD TO CARD</a>
				</div>
			</div>
		</c:forEach>
	</div>
	<nav aria-label="Page navigation example" class="m-20">
		<ul class="pagination justify-content-center">

			<c:forEach var="index" begin="0" end="${ products.totalPages - 1 }">
				<li class="page-item"><a class="page-link"
					href="/namtvph13393/home?page=${index}"> ${ index + 1 }</a></li>
			</c:forEach>

		</ul>
	</nav>
</body>
</html>