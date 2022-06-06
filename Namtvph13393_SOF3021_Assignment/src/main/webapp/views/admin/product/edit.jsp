<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<form:form method="POST" action="/namtvph13393/admin/product/update"
		modelAttribute="product">
		<form:hidden path="id" />
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
			<form:select path="category" id="selected_company">
				<c:forEach items="${ categorys }" var="category">
					<form:option value="${ category.id }">${ category.name }</form:option>
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