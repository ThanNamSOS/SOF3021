<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<form:form method="POST"
		action="${pageContext.request.contextPath}/admin/product/update/${idProduct }"
		modelAttribute="product">
		<div class="mb-3 col-6">
			<label for="exampleInputEmail1" class="form-label">Name</label>
			<form:input type="text" class="form-control" path="name" />
			${message }
			<form:errors path="name" class="form-text text-danger" />
		</div>
		<div class="mb-3 col-6">
			<label for="exampleInputEmail1" class="form-label">price</label>
			<form:input type="number" class="form-control" path="price" />
			${message }
			<form:errors path="price" class="form-text text-danger" />
		</div>

		<div class="mb-3 col-6">
			<label>Category</label>
			<form:select path="category" id="selected_company">
				<c:forEach items="${ categorys }" var="category">
					<form:option value="${ category.id }">${ category.name }</form:option>
				</c:forEach>
			</form:select>
			${message }
			<form:errors path="category" class="form-text text-danger" />
		</div>
		<div class="mb-3 col-6">
			<label for="exampleInputEmail1" class="form-label">available</label>
			<form:input type="number" class="form-control" path="available" />
			${message }
			<form:errors path="available" class="form-text text-danger" />
		</div>
	
		<div class="mb-3 col-6">
			<label for="exampleInputEmail1" class="form-label">Photo</label>
			<form:input type="file" class="form-control" path="image" />
			${message }
			<form:errors path="image" class="form-text text-danger" />
		</div>

		<button class="btn btn-dark">Save</button>
	</form:form>
</body>
</html>