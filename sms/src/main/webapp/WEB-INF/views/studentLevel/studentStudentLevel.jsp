<%@page import="com.joh.sms.domain.model.ClassGroupTableD"%>
<%@ page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="p-1">

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
							<c:when test="${item.level==0}">زۆرخراپە</c:when>
							<c:when test="${item.level==1}">زۆرخراپە</c:when>
							<c:when test="${item.level==2}">زۆرخراپە</c:when>
							<c:when test="${item.level==3}">لاوازە</c:when>
							<c:when test="${item.level==4}">لاوازە</c:when>
							<c:when test="${item.level==5}">پەسەندە</c:when>
							<c:when test="${item.level==6}">ناوەندە</c:when>
							<c:when test="${item.level==7}">باشە</c:when>
							<c:when test="${item.level==8}">زۆرباشە</c:when>
							<c:when test="${item.level==9}">زۆرباشە</c:when>
							<c:when test="${item.level==10}">نایابە</c:when>
						</c:choose></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>

</div>