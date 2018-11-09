<%@page import="com.joh.sms.domain.model.StudentSubjectMarkD"%>
<%@ page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div>
	<h5>
		ئاستی زانستی
		<fmt:formatDate value="${studentLevelDate.date}" pattern="yyy-MM-dd" />
	</h5>

	<table class="table table-bordered">
		<thead>
			<tr>
				<th>ناوی قوتابی</th>
				<th>ئاست</th>
				<th>کردارەکان</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${studentLevels}" var="item">
				<tr>
					<td>${item.student.firstName}&nbsp;${item.student.middleName}&nbsp;${item.student.lastName}</td>
					<td><c:if test="${item.level!=null}">
							<c:choose>
								<c:when test="${item.level==0}">زۆرلاوازە</c:when>
								<c:when test="${item.level==1}">لاوازە</c:when>
								<c:when test="${item.level==2}">پەسەندە</c:when>
								<c:when test="${item.level==3}">ناوەندە</c:when>
								<c:when test="${item.level==4}">باشە</c:when>
								<c:when test="${item.level==5}">زۆرباشە</c:when>
								<c:when test="${item.level==6}">نایابە</c:when>
							</c:choose>
						</c:if></td>
					<td>
						<button class="btn btn-success btn-sm"
							onclick="getAddingStudentLevel(${item.id==null?'null':item.id},${item.student.id},${item.classSubject.id},${studentLevelDate.id})">
							<i class="fa fa-plus"></i>
						</button>
					</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

</div>