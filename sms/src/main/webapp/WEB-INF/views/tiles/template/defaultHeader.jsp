<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<nav class="navbar navbar-light bg-light">


	<span class="navbar-brand">
		<b>قوتابخانەی کۆرەکی ئەهلی</b>
	</span>


	<form action="<c:url value="/logout" />" method="POST">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}">
		<div>
			<span><sec:authentication property="principal.username" /></span>
			<button class="btn btn-outline-primary">دەرچوون</button>
		</div>
	</form>
</nav>