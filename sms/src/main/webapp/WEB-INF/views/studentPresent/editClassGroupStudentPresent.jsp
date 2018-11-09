<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<div id="add-class-group-presents-container">
	<h3 class="text-warning">گۆران تۆماری نەهاتنی قوتابیان</h3>
	<form method="post"
		action="<c:url value="/studentPresents/add/classGroup" />"
		onsubmit="updateClassGroupStudentPresent(event,this)">

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
					<input type="hidden"
						name="studentPresentDs[${i.index}][studentPresentId]"
						value="${item.studentPresentId}" />
					<tr>
						<td><input type="hidden"
							name="studentPresentDs[${i.index}][studentId]"
							value="${item.studentId}" /> ${item.studentName}</td>
						<td><c:set var="isCheck" /> <c:if test="${item.attend}">
								<c:set var="isCheck" value="checked='checked'" />
							</c:if><input type="checkbox"
							name="studentPresentDs[${i.index}][attend]" ${isCheck}
							value="true" /></td>
					</tr>
				</c:forEach>
				<tr>
					<td>
						<button class="btn btn-warning" type="submit">
							<i class="fa fa-edit"></i>
						</button>
					</td>
				</tr>
			</tbody>
		</table>

	</form>

</div>