<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<table class="table table-dark">
	<tr>
		<th scope="col">Image</th>
		<th scope="col">Tên sản phẩm</th>
		<th scope="col">Gía</th>
		<th scope="col">Số lượng</th>
		<th scope="col">Tổng giá</th>
		<th>Thao tác</th>
	</tr>
	<tbody>
		<c:forEach items="${sessionScope.cart}" var="orderDetail">
			<tr>
				<td><img alt="product"
					src="${pageContext.request.contextPath}/img/${orderDetail.value.product.image }"
					style="max-width: 150px" /></td>
				<td>${ orderDetail.value.product.name }</td>
				<td><fmt:formatNumber
						value="${orderDetail.value.product.price }" groupingUsed="true" />
					&nbsp;₫</td>

				<td>x${ orderDetail.value.quantity }</td>
				<td>
					<div>
						<fmt:formatNumber
							value="${orderDetail.value.quantity * orderDetail.value.product.price }"
							groupingUsed="true" />
						&nbsp;₫
					</div>
				</td>
				<td><a
					href="${pageContext.request.contextPath}/cart/delete/${orderDetail.value.product.id }"><button
							class="btn btn-danger">Xóa</button></a></td>
			</tr>
			<c:set var="total"
				value="${total + orderDetail.value.quantity * orderDetail.value.product.price }" />
		</c:forEach>
	</tbody>
</table>
<div class="card">
	<h5 class="card-header">
		Tổng tiền đơn hàng: <span class="text-danger"> <fmt:formatNumber
				value="${total }" groupingUsed="true" />&nbsp;₫
		</span>
	</h5>

	<div class="card-body">
		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#exampleModal">Đặt hàng</button>

	</div>
</div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
		
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Để đặt hàng, vui
					lòng thêm địa chỉ nhận hàng</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form>
				<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Họ và tên người nhận</label>
						<input type="text" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp">
					</div>
					
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Số điện
							thoại</label> <input type="text" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp">
					</div>
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Địa chỉ chi tiết</label>
						<input type="text" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp">
					</div>
					<button type="submit" class="btn btn-primary">Trở lại</button>
					<button type="submit" class="btn btn-success">Hoàn thành</button>
				</form>
			</div>
		</div>
	</div>
</div>



