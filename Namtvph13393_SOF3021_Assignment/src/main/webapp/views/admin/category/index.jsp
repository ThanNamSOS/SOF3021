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

<div class="row">
<a href="/namtvph13393/admin/category/create" class="btn btn-dark btn-lg"
 role="button" >CREATE</a>
</div>
<c:if test="${ empty categorys }">
		<p class="alert alert warning">Không có dữ liệu</p>
	</c:if>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">id</th>
				<th scope="col">name</th>
				<th colspan="2"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categorys.content}" var="cate">
				<tr>
					<td>${cate.id }</td>
					<td>${cate.name }</td>
					<td><a href="/namtvph13393/admin/category/edit/${cate.id }"
						class="btn btn-primary">Update</a> <a
						href="/namtvph13393/admin/category/delete/${cate.id }"
						class="btn btn-danger">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>