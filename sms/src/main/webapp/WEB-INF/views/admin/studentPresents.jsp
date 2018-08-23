<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

this is admin students

<a href="<c:url value="/studentPresents/add/classGroup/" />${classGroupId}"
	target="_blank">زیادکردن</a>

<table id="studentTable" class="display nowrap">
	<thead>
		<tr>
			<th>ناوەی قووتابی</th>
			<th>ژ.رۆژە هاتووەکان</th>
			<th>ژ.رۆژە نەهاتووەکان</th>
			<th>krdarakan</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${studentPresentDs}" var="item">
			<tr>
				<td>${item.studentName}</td>
				<td>${item.attendDays}</td>
				<td>${item.absentDays}</td>
				<td>
					<div>
						<button data-student-id="${item.studentId}"
							onclick="getStudentStudentPresents(this)">زیاتر</button>
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





