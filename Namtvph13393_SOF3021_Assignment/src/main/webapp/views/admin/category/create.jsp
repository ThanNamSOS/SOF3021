<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<form:form method="POST"
		action="/namtvph13393/admin/category/store"
		modelAttribute="category">
		${messages }
		<div class="mb-3 col-6">
			<label for="exampleInputEmail1" class="form-label">Name</label>
			<form:input type="text" class="form-control" path="name" />
			${message }
			<form:errors path="name" class="form-text text-danger" />
		</div>
		<button class="btn btn-dark">Save</button>
	</form:form>
