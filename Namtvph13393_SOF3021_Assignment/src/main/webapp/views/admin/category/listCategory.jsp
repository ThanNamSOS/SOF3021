<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
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
			<c:forEach items="${categorys}" var="cate">
				<tr>
					<td>${cate.id }</td>
					<td>${cate.name }</td>
					<td><a href="/namtvph13393/admin/category/edit/${cate.id }"
						class="btn btn-primary">Update</a> <a
						href="/namtvph13393/admin/category/delete/${cate.id }"
						class="btn btn-primary">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>