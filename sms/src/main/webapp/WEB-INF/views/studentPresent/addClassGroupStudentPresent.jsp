<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
this is Add ClasGroup StdentPresentoogle

<div>
	<input id="presentDate" />
</div>
<form method="post"
	action="<c:url value="/studentPresents/add/classGroup" />"
	onsubmit="addClassGroupStudentPresent(event,this)">

	<table id="studentTable" class="display nowrap">
		<thead>
			<tr>
				<th>بەروار</th>
				<th>هاتوە</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${studentPresentDs}" var="item" varStatus="i"
				begin="0">
				<tr>
					<td><input type="hidden"
						name="studentPresentDs[${i.index}][studentId]"
						value="${item.studentId}" /> ${item.studentName}</td>
					<td><input type="checkbox"
						name="studentPresentDs[${i.index}][attent]" value="true" /></td>
				</tr>
			</c:forEach>
			<tr>
				<td>
					<button type="submit">تۆمارکردن</button>
				</td>
			</tr>
		</tbody>
	</table>

</form>





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