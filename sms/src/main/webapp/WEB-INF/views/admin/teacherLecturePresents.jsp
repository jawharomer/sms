<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div id="admin-teachers-container">
	<h3>وانەوتنەوەی مامۆستایان</h3>

	<hr>

	<div class="p-1">
		<form action="<c:url value="/admin/teacherLecturePresents" />">
			<table class="w-100">
				<tr>
					<td>
						<div class="d-flex">
							<div class="d-flex align-items-center p-1">لە</div>
							<div class="w-100">
								<input class="form-control" id="from" name="from"
									value="<fmt:formatDate pattern = "yyyy-MM-dd"  value = "${from}" />" />
							</div>
						</div>
					</td>
					<td>
						<div class="d-flex">
							<div class="d-flex align-items-center p-1">بۆ</div>
							<div class="w-100">
								<input class="form-control" id="to" name="to"
									value="<fmt:formatDate pattern = "yyyy-MM-dd"  value = "${to}" />" />
							</div>
						</div>
					</td>
					<td>
						<div class="p-1">
							<button class="btn btn-success">
								<i class="fa fa-eye"></i>
							</button>
						</div>
					</td>
				</tr>
			</table>

		</form>

	</div>

	<div id="teacher-table-div">

		<table id="teacher-lecture-present-table" class="display nowrap">
			<thead>
				<tr>
					<td>#</td>
					<td>مامۆستا</td>
					<td>بڕی پارە</td>
					<td>بەشە هەفتە</td>
					<td>کۆی وانە وتراوەکان</td>
					<td>کۆی پارە</td>
				</tr>
			</thead>
			<tbody>
				<c:set var="sumTotalLectures" value="${0}" />
				<c:set var="sumTotalPayment" value="${0}" />
				<c:forEach items="${teacherLecturePresentDs}" var="item">
					<tr>
						<td>${item.teacherId}</td>
						<td>${item.teacherName}</td>
						<td><fmt:formatNumber maxFractionDigits="3"
								value="${item.hireAmount}" /></td>
						<td>${item.lecturePerWeek}</td>
						<td>${item.totalLectures}</td>
						<td><fmt:formatNumber maxFractionDigits="3"
								value="${item.totalPayment}" /></td>
					</tr>

					<c:set var="sumTotalLectures"
						value="${sumTotalLectures+item.totalLectures}" />
					<c:set var="sumTotalPayment"
						value="${sumTotalPayment+item.totalPayment}" />

				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td>
						<div>
							<span>کۆی گشتی وانەکان</span> <span> <fmt:formatNumber
									type="number" maxFractionDigits="3" value="${sumTotalLectures}" />
							</span>
						</div>
						<div>
							<span>کۆی گشتی پارەکان</span> <span> <fmt:formatNumber
									type="number" maxFractionDigits="3" value="${sumTotalPayment}" />
							</span>
						</div>
					</td>
				</tr>
			</tfoot>


		</table>


	</div>

</div>

