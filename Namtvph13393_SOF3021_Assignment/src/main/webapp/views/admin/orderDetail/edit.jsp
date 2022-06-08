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
	<form:form method="POST"
		action="${pageContext.request.contextPath}/admin/orderDetail/update/${idorderDe }"
		modelAttribute="orderDe" class="row">
			<div class="mb-3">
				<label>User</label>
				<form:select path="order" id="selected_company">
					<c:forEach items="${ orders }" var="od">
						<form:option value="${ od }">${ (od.user).fullname }</form:option>
					</c:forEach>
					${message }
				<form:errors path="order" class="form-text text-danger" />
				</form:select>
			</div>
			<div class="mb-3">
				<label>User</label>
				<form:select path="product" id="selected_company">
					<c:forEach items="${ products }" var="pro">
						<form:option value="${ pro }">${ pro.name }</form:option>
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
				<label for="exampleInputEmail1" class="form-label">quantity</label>
				<form:input type="number" class="form-control" path="quantity" />
				${message }
				<form:errors path="quantity" class="form-text text-danger" />
			</div>
		
		<div class="col-12">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>

	</form:form>
</body>
</html>