<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-student-subject-mark-container">

	This is Add Student Subject Mark page

	<sf:form id="add-student-subject-mark-form" method="POST"
		commandName="studentSubjectMarkD"
		onsubmit="addStudentSubjectMark(event)">
		<sf:input type="hidden" path="studentId" />
		<sf:input type="hidden" path="classSubjectId" />
		<sf:input type="hidden" path="classMarkId" />
		<table>
			<tbody>

				<tr>
					<td><sf:input path="mark" /></td>
					<td><sf:errors path="mark" /></td>
				</tr>

				<tr>
					<td><input type="submit"></td>
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
			failure : function(errMsg) {
				alert(errMsg);
			}
		});
	}
</script>