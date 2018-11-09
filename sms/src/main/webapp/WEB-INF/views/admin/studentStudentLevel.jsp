<%@page import="com.joh.sms.domain.model.ClassGroupTableD"%>
<%@ page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="student-level-container" class="p-1">

	<div class="d-print-none p-2">
		<button class="btn btn-sm btn-info" onclick="window.print()">
			<i class="fa fa-print"></i>
		</button>

	</div>
	<div id="section-to-print" class="py-2">
		<h6>قوتابخانەی کۆرەکی ناحوکمی</h6>
		<table class="w-100">
			<tr>
				<td>ناوی قوتابی</td>
				<td><span>${student.firstName}</span> <span>${student.middleName}</span>
					<span>${student.lastName}</span></td>
			</tr>
			<tr>
				<td>بەرواری هەلسەنگاندن</td>
				<td><fmt:formatDate value="${studentLevelDate.date}"
						pattern="yyyy-MM-dd" /></td>
			</tr>
		</table>
	</div>

	<table class="table table-bordered">
		<thead>
			<tr>
				<th>بابەت</th>
				<th>ئاست</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${studentLevels}" var="item">
				<tr>
					<td>${item.classSubject.name}</td>
					<td><c:choose>
							<c:when test="${item.level==0}">زۆرلاوازە</c:when>
							<c:when test="${item.level==1}">لاوازە</c:when>
							<c:when test="${item.level==2}">پەسەندە</c:when>
							<c:when test="${item.level==3}">ناوەندە</c:when>
							<c:when test="${item.level==4}">باشە</c:when>
							<c:when test="${item.level==5}">زۆرباشە</c:when>
							<c:when test="${item.level==6}">نایابە</c:when>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>