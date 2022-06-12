<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
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
		<c:forEach items="${products}" var="product">
			<div class="card col-3" style="width: 18rem;">
				<img src="${pageContext.request.contextPath}/img/${product.image}"
					class="card-img-top">
				<div class="card-body">
					<h5 class="card-title">Ten SP: ${product.name }</h5>
					<h5>
						Gia:
						<fmt:formatNumber value="${product.price }" groupingUsed="true" />
						&nbsp;₫
					</h5>
					<h5 class="card-title">The loai: ${(product.category).name }</h5>
					<h5 class="card-title">Số lượng hàng: ${product.available  }</h5>
				</div>
				<div class="card-footer text-muted">
					<a href="${pageContext.request.contextPath}/cart/${product.id }"
						class="btn btn-primary">Thêm vào giỏ hàng</a>

				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>