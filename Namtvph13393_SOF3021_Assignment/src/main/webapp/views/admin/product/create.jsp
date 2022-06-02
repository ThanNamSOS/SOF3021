<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<form:form method="POST" action="/namtvph13393/admin/product/store"
		modelAttribute="productModel" >
		<div>
			<label>name</label>
			<form:input path="name" />
		</div>
		<div>
			<label>price</label>
			<form:input path="price" type="bumber" />
		</div>

		<div>
			<label>Category</label>
			<form:select  path="category" id="selected_company">
				<c:forEach items="${ categorys }" var="category">
					<form:option value="${ category }">${ category.name }</form:option>
				</c:forEach>
			</form:select>
		</div>
		<div>
			<label>available</label>
			<form:input path="available" />
		</div>

		<div>
			<label>Photo</label>
			<form:input type="file" path="image" />
		</div>
		<button>Save</button>
	</form:form>
</body>
</html>