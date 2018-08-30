<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<div>
	<table id="studentTable" class="table table-bordered">
		<thead>
			<tr>
				<th>بەروار</th>
				<th>هاتوە</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="totalAttendDays" value="${0}" />
			<c:set var="totalAbsentDays" value="${0}" />
			<c:forEach items="${studentPresents}" var="item">
				<tr>
					<td>${item.date}</td>
					<td><input disabled="disabled" type="checkbox"
						${item.attend==true?"checked":""} /> <c:if
							test="${item.attend==true}">
							<c:set var="totalAttendDays" value="${totalAttendDays+1}" />
						</c:if> <c:if test="${item.attend==false}">
							<c:set var="totalAbsentDays" value="${totalAbsentDays+1}" />
						</c:if></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="py-2">
		<span>ژمارەی رۆژەنەهاتوەکان</span> <span class="text-danger">${totalAbsentDays}</span>
	</div>
	<div>
		<span>ژمارەی رۆژە هاتوەکان</span> <span class="text-success">${totalAttendDays}</span>
	</div>
</div>