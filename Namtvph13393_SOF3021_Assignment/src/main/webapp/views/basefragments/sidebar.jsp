<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!-- Sidebar -->
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar -->
	
	<c:if test="${ accLogin.admin == 1 }">
		<a
			class="sidebar-brand d-flex align-items-center justify-content-center"
			href="index.html">
			<div class="sidebar-brand-icon rotate-n-15">
				<i class="fas fa-laugh-wink"></i>
			</div>
			<div class="sidebar-brand-text mx-3">
				FPT<sup>2</sup>
			</div>
		</a>
		<!-- Divider -->
		<hr class="sidebar-divider my-0">

		<!-- Nav Item - Dashboard -->
		<li class="nav-item"><a class="nav-link"
			href="${pageContext.request.contextPath}/home"> <i
				class="fas fa-fw fa-tachometer-alt"></i> <span>Trang chủ</span>
		</a></li>

		<!-- Divider -->
		<hr class="sidebar-divider">

		<!-- Heading -->
		<div class="sidebar-heading">Interface</div>
		<!-- Nav Item - Pages Collapse Menu -->
		<li class="nav-item"><a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#collapseTwo"
			aria-expanded="true" aria-controls="collapseTwo"> <i
				class="fas fa-fw fa-folder"></i> <span>Tài khoản</span>
		</a>
			<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
				data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Function</h6>
					<a class="collapse-item"
						href="${pageContext.request.contextPath}/admin/accounts/index">index</a>

				</div>
			</div></li>

		<!-- Nav Item - Utilities Collapse Menu -->
		<li class="nav-item active"><a class="nav-link" href="#"
			data-toggle="collapse" data-target="#collapseUtilitiess"
			aria-expanded="true" aria-controls="collapseUtilities"> <i
				class="fas fa-fw fa-folder"></i> <span>Thể loại</span>
		</a>
			<div id="collapseUtilitiess" class="collapse show"
				aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Function</h6>
					<a class="collapse-item"
						href="${pageContext.request.contextPath}/admin/category/index">index</a>
				</div>
			</div></li>

		<!-- Product -->

		<li class="nav-item"><a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#collapsePagesX"
			aria-expanded="true" aria-controls="collapsePages"> <i
				class="fas fa-fw fa-folder"></i> <span>Sản phẩm</span>
		</a>
			<div id="collapsePagesX" class="collapse"
				aria-labelledby="headingPages" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Function</h6>
					<a class="collapse-item"
						href="${pageContext.request.contextPath}/admin/product/index">Index</a>
				</div>
			</div></li>

		<!-- Oder -->

		<li class="nav-item"><a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#order" aria-expanded="true"
			aria-controls="collapsePages"> <i class="fas fa-fw fa-folder"></i>
				<span>Hóa đơn</span>
		</a>
			<div id="order" class="collapse" aria-labelledby="headingPages"
				data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Function</h6>
					<a class="collapse-item"
						href="${pageContext.request.contextPath}/admin/order/index">Index</a>
				</div>
			</div></li>

		<!-- Oder Detail-->

		<li class="nav-item"><a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#orderD" aria-expanded="true"
			aria-controls="collapsePages"> <i class="fas fa-fw fa-folder"></i>
				<span>Hóa đơn chi tiết</span>
		</a>
			<div id="orderD" class="collapse" aria-labelledby="headingPages"
				data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Function</h6>
					<a class="collapse-item"
						href="${pageContext.request.contextPath}/admin/orderDetail/index">Index</a>
				</div>
			</div></li>
		<hr class="sidebar-divider d-none d-md-block">
	</c:if>
	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

</ul>