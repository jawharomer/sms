<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="edit-student-subject-mark-container">
	<sf:form id="edit-student-subject-mark-form" method="POST"
		commandName="studentSubjectMarkD"
		onsubmit="editStudentSubjectMark(event)">
		<sf:input type="hidden" path="studentId" />
		<sf:input type="hidden" path="classSubjectId" />
		<sf:input type="hidden" path="classMarkId" />
		<table>
			<tbody>

				<tr>
					<td><sf:input cssClass="form-control form-control-sm" path="mark" /></td>
					<td><sf:errors path="mark" /></td>
				</tr>

				<tr>
					<td><button class="btn btn-outline-warning btn-sm">
							<i class="fa fa-edit"></i>
						</button></td>
				</tr>
			</tbody>

		</table>

	</sf:form>

</div>


<script>
	function editStudentSubjectMark(event) {
		event.preventDefault();
		console.log("editStudentSubjectMark->fired");
		var data = $("#edit-student-subject-mark-form").serializeObject();
		console.log("data=", data);
		$
				.ajax({
					type : "POST",
					url : "<c:url value="/studentSubjectMarks/edit/"/>${studentSubjectMarkId}",
					data : JSON.stringify(data),
					contentType : "application/json",
					success : function(response) {
						$("#edit-student-subject-mark-container")
								.html(response);
					},
					error : function(response) {
						$("#modal-body").html(response.responseText);
						$("#modal").modal("show");
					}
				});
	}
</script>