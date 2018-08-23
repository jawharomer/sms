<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

this is admin students
<div>
	<!-- Button trigger modal -->
	<button id="cus-btn-addstudent" onclick="getAddEnrollment()"
		type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#modal">زیادکردن</button>
</div>

<table id="studentTable" class="display nowrap">
	<thead>
		<tr>
			<td>ناوری قوتابی</td>
			<td>پۆل</td>
			<td>بڕ</td>
			<td>تێبینی</td>
			<td>کردارەکان</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${enrollments}" var="item">
			<tr>
				<td>${item.studentName}</td>
				<td>${item.groupName}</td>
				<td>${item.fee}</td>
				<td>${item.note}</td>
				<td>
					<div>
						<button data-enrollment-id="${item.enrollmentId}"
							onclick="deleteEnrollment(this)">delete</button>
						<button data-enrollment-id="${item.enrollmentId}"
							onclick="editEnrollment(this)">edit</button>
					</div>
				</td>
			</tr>
		</c:forEach>
	</tbody>


</table>





<!-- Modal -->
<div class="modal fade" id="modal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLongTitle" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body" id="modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Save changes</button>
			</div>
		</div>
	</div>
</div>





