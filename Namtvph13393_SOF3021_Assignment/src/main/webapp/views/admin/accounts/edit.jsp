
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form method="POST" action="/namtvph13393/admin/accounts/update"
	modelAttribute="account">
	<form:hidden path="id" />
		${messages }
		<div class="mb-3">
		<label class="form-label">Fullname</label>
		<form:input type="text" class="form-control" path="fullname" />
		${message }
		<form:errors path="fullname" class="form-text text-danger" />
	</div>
	<div>
		<label>Email</label>
		<form:input path="email" type="email" />
		${message }
		<form:errors path="email" class="form-text text-danger" />
	</div>
	<div>
		<label>Username</label>
		<form:input path="username" />
	</div>
	<div>
		<label>Password</label>
		<form:password path="password" />
	</div>
	<div>
		<label>Photo</label>
		<form:input type="file" path="photo" />
	</div>
	<div>
		<label>Activate</label>
		<form:select path="activated">
			<form:option value="0">In-active</form:option>
			<form:option value="1">Active</form:option>
		</form:select>
	</div>
	<div>
		<label>Admin</label>
		<form:select path="admin">
			<form:option value="0">Member</form:option>
			<form:option value="1">Admin</form:option>
		</form:select>
	</div>
	<button>Save</button>
</form:form>




