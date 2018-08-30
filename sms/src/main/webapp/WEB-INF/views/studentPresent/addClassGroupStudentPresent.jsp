<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<div id="add-class-group-presents-container">
	<h3>زیادکردنی تۆماری نەهاتنی قوتابیان</h3>

	<div class="py-1">
		<input class="w-50 form-control form-control-sm" id="presentDate" />
	</div>
	<form method="post"
		action="<c:url value="/studentPresents/add/classGroup" />"
		onsubmit="addClassGroupStudentPresent(event,this)">

		<table id="studentTable" class="table table-bordered">
			<thead>
				<tr>
					<th>قوتابی</th>
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
						<button class="btn btn-success" type="submit">
						<i class="fa fa-plus"></i>
						</button>
					</td>
				</tr>
			</tbody>
		</table>

	</form>

</div>