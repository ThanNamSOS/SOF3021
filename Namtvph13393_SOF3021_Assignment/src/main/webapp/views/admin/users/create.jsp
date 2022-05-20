<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form:form method="POST" 
 modelAttribute="user"
 action="/Namtvph13393_SOF3021_Assignment/admin/users/store">
 <div>
 	<label>Họ tên</label>
 	<form:input name="hoTen" path="hoTen"/>
 	<form:errors path="hoTen" class="text-danger"></form:errors>
 </div>
  <div>
 	<label>Địa chỉ</label>
 	<form:input name="diaChi" path="diaChi"/>
 	<form:errors path="diaChi" class="text-danger"></form:errors>
 </div>
  <div>
 	<label>Email</label>
 	<form:input name="email" path="email"/>
 	<form:errors path="email" class="text-danger"></form:errors>
 </div>
 <div>
 	<label>Password</label>
 	<form:password name="password" path="password"/>
 	<form:errors path="password" class="text-danger"></form:errors>
 </div>
 <div>
 	<label>Gioi Tính</label>
 	<form:radiobutton name="gioiTinh" path="gioiTinh" value="1" label="Nam"/> 
 	<form:radiobutton name="gioiTinh" path="gioiTinh" value="0" label="Nữ"/>
 	<form:errors path="gioiTinh" class="text-danger"></form:errors>
 </div>
  <div>
 	<label>SDT</label>
 	<form:input name="sdt" path="sdt"/>
 	<form:errors path="sdt" class="text-danger"></form:errors>
 </div>
  <div>
 	<label>Avarta</label>
 	<form:input name="avatar" path="avatar"/>
 	<form:errors path="avatar" class="text-danger"></form:errors>
 </div>
 <button>Submit</button>
 </form:form>
</body>
</html>