<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!-- Sidebar -->
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
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
	<li class="nav-item"><a class="nav-link" href="index.html"> <i
			class="fas fa-fw fa-tachometer-alt"></i> <span>Trang chủ</span></a></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Interface</div>
	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true"
		aria-controls="collapseTwo"> <i class="fas fa-fw fa-folder"></i> <span>Account</span>
	</a>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" 
		data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Function</h6>
				<a class="collapse-item" href="/namtvph13393/admin/accounts/list">List
					All</a> <a class="collapse-item"
					href="/namtvph13393/admin/accounts/create">Create</a>
					<a class="collapse-item"
					href="/namtvph13393/admin/accounts/index">index</a>
			</div>
		</div></li>

	<!-- Nav Item - Utilities Collapse Menu -->
	<li class="nav-item active"><a class="nav-link" href="#"
		data-toggle="collapse" data-target="#collapseUtilities"
		aria-expanded="true" aria-controls="collapseUtilities"> <i
			class="fas fa-fw fa-folder"></i> <span>Category</span>
	</a>
		<div id="collapseUtilities" class="collapse show" aria-labelledby="headingUtilities" 
		data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Function</h6>
				<a class="collapse-item" href="/namtvph13393/admin/category/list">List All</a> 
				<a class="collapse-item" href="/namtvph13393/admin/category/create">Create</a>
			</div>
		</div></li>

<!-- Product -->
	<li class="nav-item active"><a class="nav-link" href="#"
		data-toggle="collapse" data-target="#collapseProduct"
		aria-expanded="true" aria-controls="collapseUtilities"> <i
			class="fas fa-fw fa-folder"></i> <span>Product</span>
	</a>
		<div id="#collapseProduct" class="collapse show" aria-labelledby="headingUtilities" 
		data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Function</h6>
				<a class="collapse-item" href="/namtvph13393/admin/category/list">List All</a> 
				<a class="collapse-item" href="/namtvph13393/admin/category/create">Create</a>
			</div>
		</div></li>
	<!-- Divider -->

	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsePages"
		aria-expanded="true" aria-controls="collapsePages"> <i
			class="fas fa-fw fa-folder"></i> <span>Pages</span>
	</a>
		<div id="collapsePages" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Login Screens:</h6>
				<a class="collapse-item" href="login.html">Login</a> <a
					class="collapse-item" href="register.html">Register</a> <a
					class="collapse-item" href="forgot-password.html">Forgot
					Password</a>
				<div class="collapse-divider"></div>
				<h6 class="collapse-header">Other Pages:</h6>
				<a class="collapse-item" href="404.html">404 Page</a> <a
					class="collapse-item" href="blank.html">Blank Page</a>
			</div>
		</div></li>

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

</ul>