<%@page import="com.joh.sms.domain.model.StudentSubjectMarkD"%>
<%@ page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="student-notificaions-container">
	<h3>ئاگادارکردنەوەکان</h3>
	<c:forEach items="${studentNotifications}" var="item">
		<div class="card my-1 border border-warning">
			<h5 class="card-header">
				<fmt:formatDate value="${item.time}" pattern="yyyy-MM-dd HH:mm:ss" />

			</h5>
			<div class="card-body">
				<h5 class="card-title">${item.title}</h5>
				<p class="card-text">${item.note}</p>
			</div>
		</div>
	</c:forEach>

</div>