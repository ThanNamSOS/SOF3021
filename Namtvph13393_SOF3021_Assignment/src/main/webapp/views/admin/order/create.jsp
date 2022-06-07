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
	${messages }
	<form:form method="POST" action="/namtvph13393/admin/order/store"
		modelAttribute="orderModel" class="row">

		<div class="col-5">
			<div class="mb-3">
				<label>User</label>
				<form:select path="account" id="selected_company">
					<c:forEach items="${ accounts }" var="account">
						<form:option value="${ account }">${ account.fullname }</form:option>
					</c:forEach>
					${message }
				<form:errors path="account" class="form-text text-danger" />
				</form:select>
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">address</label>
				<form:input type="text" class="form-control" path="address" />
				${message }
				<form:errors path="address" class="form-text text-danger" />
			</div>
		</div>
		<div class="col-7">
			<div class="mb-3">
				<label>Product</label>
				<form:select path="product" id="selected_company">
					<c:forEach items="${ products }" var="product">
						<form:option value="${ product }">${ product.name }</form:option>
					</c:forEach>
					${message }
				<form:errors path="product" class="form-text text-danger" />
				</form:select>
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">price</label>
				<form:input type="number" class="form-control" path="price" />
				${message }
				<form:errors path="price" class="form-text text-danger" />
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">quatity</label>
				<form:input type="number" class="form-control" path="quatity" />
				${message }
				<form:errors path="quatity" class="form-text text-danger" />
			</div>

		</div>
		<div class="col-12">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>

	</form:form>
</body>
</html>