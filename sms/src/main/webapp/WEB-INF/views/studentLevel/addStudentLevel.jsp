<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-student-level-container">

	<sf:form id="add-student-level-form" method="POST"
		commandName="studentLevel" onsubmit="addStudentLevel(event)">
		<sf:input type="hidden" path="id" />
		<input type="hidden" name="studentLevelDate[id]"
			value="${studentLevel.studentLevelDate.id}" />

		<input type="hidden" name="student[id]"
			value="${studentLevel.student.id}" />
		<input type="hidden" name="classSubject[id]"
			value="${studentLevel.classSubject.id}" />
		<table class="w-100">
			<tbody>
				<tr>
					<td>ئاست</td>
					<td><sf:radiobutton path="level" value="${0}"
							label="زۆرلاوازە" /> <sf:radiobutton path="level" value="${1}"
							label="لاوازە" /> <sf:radiobutton path="level" value="${2}"
							label="پەسەندە" /> <br>
					<sf:radiobutton path="level" value="${3}" label="ناوەندە" /> <sf:radiobutton
							path="level" value="${4}" label="باشە" /> <sf:radiobutton
							path="level" value="${5}" label="زۆرباشە" /> <sf:radiobutton
							path="level" value="${6}" label="نایابە" /></td>
					<td><sf:errors path="level" /></td>
				</tr>
				<tr>
					<td>
						<button class="btn btn-success btn-sm">
							<i class="fa fa-plus"></i>
						</button>
					</td>
				</tr>

			</tbody>

		</table>

	</sf:form>

</div>


<script>
	function addStudentLevel(event) {
		event.preventDefault();
		console.log("addStudentLevel->fired");
		var data = $("#add-student-level-form").serializeJSON();
		console.log("data=", data);
		$.ajax({
			type : "POST",
			url : "<c:url value="/studentLevels/add"/>",
			data : JSON.stringify(data),
			contentType : "application/json",
			success : function(response) {
				$("#modal-body").html(response);
				$("#modal").modal("show");
			},
			error : function(response) {
				$("#modal-body").html(response.responseText);
				$("#modal").modal("show");
			}
		});
	}
</script>