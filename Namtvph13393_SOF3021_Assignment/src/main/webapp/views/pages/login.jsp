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
	<!-- Outer Row -->
	<div class="row justify-content-center">
		<div class="col-xl-10 col-lg-12 col-md-9">
			<div class="alert alert-danger" role="alert">${ messages }</div>
			<div class="card o-hidden border-0 shadow-lg my-5">
				<div class="card-body p-0">
					<!-- Nested Row within Card Body -->
					<div class="row">
						<div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
						<div class="col-lg-6">
							<div class="p-5">
								<div class="text-center">
									<h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
								</div>
								<form:form method="POST"
									action="${pageContext.request.contextPath}/loginForm"
									modelAttribute="account">
									<div class="form-group">
										<label for="exampleInputEmail1" class="form-label">Email</label>
										<form:input type="text" class="form-control form-control-user"
											path="email" />
										${message }
										<form:errors path="email" class="form-text text-danger" />
									</div>
									<!-- Password input -->
									<div class="form-group">
										<label for="exampleInputEmail1" class="form-label">Password</label>
										<form:input type="password"
											class="form-control form-control-user" path="password" />
										${message }
										<form:errors path="password" class="form-text text-danger" />
									</div>
									<div class="form-group">
										<div class="custom-control custom-checkbox small">
											<input type="checkbox" class="custom-control-input"
												id="customCheck"> <label
												class="custom-control-label" for="customCheck">Remember
												Me</label>
										</div>
									</div>
									<button class="btn btn-primary">Sign in</button>
									<hr>
									<a href="index.html" class="btn btn-google btn-user btn-block">
										<i class="fab fa-google fa-fw"></i> Login with Google
									</a>
									<a href="index.html"
										class="btn btn-facebook btn-user btn-block"> <i
										class="fab fa-facebook-f fa-fw"></i> Login with Facebook
									</a>
								</form:form>
								<hr>
								<div class="text-center">
									<a class="small" href="forgot-password.html">Forgot
										Password?</a>
								</div>
								<div class="text-center">
									<a class="small" href="register.html">Create an Account!</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

	</div>
</body>
</html>