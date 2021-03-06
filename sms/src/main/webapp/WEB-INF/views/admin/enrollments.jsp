<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="admin-enrollments-container">
	<h3>ناونیسین</h3>
	<button onclick="getAddEnrollment()" type="button"
		class="btn btn-primary">
		<i class="fa fa-plus"></i>
	</button>
	<button class="btn btn-info" onclick="getAddingStudentNotificaion()">ئاگادارکرنەوە</button>
	<div id="enrollment-table-div">
		<table id="enrollment-table" class="display w-100">
			<thead>
				<tr>
					<th style="min-width: 80px;">#</th>
					<th>قوتابی</th>
					<th>پۆل</th>
					<th>بڕ</th>
					<th class="cus-not-export">زیاتر</th>
					<th>تێبینی</th>
					<th class="cus-not-export">کردارەکان</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${enrollments}" var="item">
					<tr>
						<td>${item.studentId}</td>
						<td>${item.studentName}</td>
						<td>${item.groupName}</td>
						<td>${item.fee}</td>
						<td><a class="btn btn-sm btn-info" target="_blank"
							href="<c:url value="/enrollmentPayments/enrollment/"/>${item.enrollmentId}">
								<i class="fa fa-money"></i>
						</a></td>
						<td class="cus-note-td">${item.note}</td>
						<td>
							<div>
								<button class="btn btn-sm btn-danger"
									data-enrollment-id="${item.enrollmentId}"
									onclick="deleteEnrollment(this)">
									<i class="fa fa-times"></i>
								</button>
								<button class="btn btn-sm btn-warning"
									data-enrollment-id="${item.enrollmentId}"
									onclick="editEnrollment(this)">
									<i class="fa fa-edit"></i>
								</button>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th class="cus-not-search">&nbsp;</th>
					<th>قوتابی</th>
					<th>پۆل</th>
					<th>بڕ</th>
					<th class="cus-not-search">&nbsp;</th>
					<th>تێبینی</th>
					<th class="cus-not-search">&nbsp;</th>
				</tr>
			</tfoot>
		</table>
	</div>

</div>



