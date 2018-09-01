<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div id="admin-teachers-container">
	<h3>ئامادەبونی مامۆستایان</h3>
	<div>
		<button onclick="getAddTeacherPresent()" class="btn btn-primary">
			<i class="fa fa-plus"></i>
		</button>
	</div>

	<hr>

	<div class="p-1">
		<form action="<c:url value="/admin/teacherPresents" />">
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

		<table id="teacher-lecture-present-table" class="table tabl-bordered">
			<thead>
				<tr>
					<td>مامۆستا</td>
					<td>بەروار</td>
					<td>ژ.وانەکان</td>
					<td>تێبینی</td>
					<td>کردارەکان</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${teacherPresents}" var="item">
					<tr>
						<td>${item.teacher.firstName}&nbsp;${item.teacher.middleName}&nbsp;${item.teacher.lastName}</td>
						<td>${item.date}</td>
						<td>${item.numberOfLectures}</td>
						<td class="cus-note-td">${item.note}</td>
						<td>
							<button data-teacher-present-id="${item.id}"
								class="btn btn-sm btn-danger"
								onclick="deleteTeacherPresent(this)">
								<i class="fa fa-times"></i>
							</button>
						</td>
				</c:forEach>
			</tbody>
		</table>


	</div>

</div>

