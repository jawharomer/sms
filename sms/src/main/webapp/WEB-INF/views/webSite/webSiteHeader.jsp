<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="<c:url value="/" />">قوتابخانەی کۆرەکی ناحکومی</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href="<c:url value="#abount" />">دەبارە</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="<c:url value="#gallary-div-container" />">وێنەکان</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="<c:url value="#address" />">ناونیشان</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="<c:url value="#contact" />">پایوەندی</a></li>

			<li class="nav-item border border-success"><a class="nav-link"
				href="<c:url value="/app" />">چوونە ژورەوە</a></li>
		</ul>
	</div>
</nav>
