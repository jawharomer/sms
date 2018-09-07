<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-student-subject-mark-container">
	<sf:form id="add-student-subject-mark-form" method="POST"
		commandName="studentSubjectMarkD"
		onsubmit="addStudentSubjectMark(event)">
		<sf:input type="hidden" path="studentId" />
		<sf:input type="hidden" path="classSubjectId" />
		<sf:input type="hidden" path="classMarkId" />
		<table class="w-100">
			<tbody>

				<tr>
					<td><sf:input cssClass="form-control form-control-sm"
							path="mark" /></td>
					<td><sf:errors path="mark" /></td>
				</tr>

				<tr>
					<td><button class="btn btn-outline-success btn-sm">
							<i class="fa fa-plus"></i>
						</button></td>


				</tr>
			</tbody>

		</table>

	</sf:form>

</div>


<script>
	function addStudentSubjectMark(event) {
		event.preventDefault();
		console.log("addStudentSubjectMark->fired");
		var data = $("#add-student-subject-mark-form").serializeObject();
		console.log("data=", data);
		$.ajax({
			type : "POST",
			url : "<c:url value="/studentSubjectMarks/add"/>",
			data : JSON.stringify(data),
			contentType : "application/json",
			success : function(response) {
				$("#add-student-subject-mark-container").html(response);
			},
			error : function(response) {
				$("#modal-body").html(response.responseText);
				$("#modal").modal("show");
			}
		});
	}
</script>