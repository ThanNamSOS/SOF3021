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
	<a href="/namtvph13393/admin/order/create" class="btn btn-dark btn-lg"
		role="button">CREATE</a>
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
						class="btn btn-danger">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>