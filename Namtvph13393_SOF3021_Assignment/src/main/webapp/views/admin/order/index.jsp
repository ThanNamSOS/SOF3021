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
				<th scope="col">Địa chỉ</th>
				<th scope="col">Ngày tạo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listOrder}" var="order">
				<tr>
					<td>${(order.user).fullname }</td>
					<td>${order.address }</td>
					<td>${order.createdDate }</td>
					<td><a type="button"
						href="${pageContext.request.contextPath}/admin/order/edit/${order.id}"
						class="btn btn-primary">Cập nhật </a>
					
						<button type="button" class="btn btn-danger"
							data-bs-toggle="modal" data-bs-target="#exampleModal_${order.id}">
							Xóa</button> <!-- Modal delete-->
						<div class="modal fade" id="exampleModal_${order.id}" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Xác nhận</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">Xóa Order: ${(order.user).fullname }</div>
									<div class="modal-footer">
										<a type="button"
											href="${pageContext.request.contextPath}/admin/order/delete/${order.id}"
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
</body>
</html>