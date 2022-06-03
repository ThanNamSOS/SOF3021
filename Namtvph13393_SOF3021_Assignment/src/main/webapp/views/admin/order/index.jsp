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

	<form:form method="POST" action="/namtvph13393/admin/order/store"
		modelAttribute="orderModel" class="row">
		<div class="col-5">
			<div class="mb-3">
				<label>User</label>
				<form:select path="user" id="selected_company">
					<c:forEach items="${ accounts }" var="account">
						<form:option value="${ account }">${ account.fullname }</form:option>
					</c:forEach>
				</form:select>
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">address</label>
				<form:input type="text" class="form-control" path="address" />
			</div>

		</div>
		<div class="col-7">
			<div class="mb-3">
				<label>Product</label>
				<form:select path="product" id="selected_company">
					<c:forEach items="${ products }" var="product">
						<form:option value="${ product }">${ product.name }</form:option>
					</c:forEach>
				</form:select>
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">price</label>
				<form:input type="number" class="form-control" path="price" />
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">quatity</label>
				<form:input type="number" class="form-control" path="quatity" />
			</div>

		</div>
		<div class="col-12">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>

	</form:form>
	<table class="table" class="row">
		<thead>
			<tr>
				<th scope="col">Tên</th>
				<th scope="col">Ngày tạo</th>
				<th scope="col">Địa chỉ</th>
				<th scope="col">Sản phẩm</th>
				<th scope="col">giá</th>
				<th scope="col">Số lượng</th>
				<th scope="col">Thành tiền</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listOrder}" var="order">
				<tr>
					<td>${order[0].fullname }</td>
					<td>${order[1] }</td>
					<td>${order[2] }</td>
					<td>${order[3].name }</td>
					<td>${order[4] }</td>
					<td>${order[5] }</td>
					<td>${order[5] * order[4] }</td>
					<td><a href="/namtvph13393/admin/order/edit/${product.id }"
						class="btn btn-primary">Update</a> <a
						href="/namtvph13393/admin/order/delete/${product.id }"
						class="btn btn-danger">Delete</a>
						
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>