<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="edit-teacher-container">

	<sf:form id="eidtTeacherForm" method="POST" commandName="teacher"
		onsubmit="modalEditTeacher(event)">
		<sf:input path="id" type="hidden" />
		<table>
			<tbody>
				<tr>
					<td>FirstName</td>
					<td><sf:input path="firstName" /></td>
					<td><sf:errors path="firstName" /></td>
				</tr>

				<tr>
					<td>MiddleName</td>
					<td><sf:input path="middleName" /></td>
					<td><sf:errors path="middleName" /></td>
				</tr>

				<tr>
					<td>LastName</td>
					<td><sf:input path="lastName" /></td>
					<td><sf:errors path="lastName" /></td>
				</tr>

				<tr>
					<td>Hire amount</td>
					<td><sf:input path="hireAmount" /></td>
					<td><sf:errors path="hireAmount" /></td>
				</tr>

				<tr>
					<td>Edit</td>
					<td><input type="submit" value="Edit"></td>
				</tr>

			</tbody>

		</table>


	</sf:form>

</div>


<script>
	$(document).ready()
	{
		$("#birthDate").datepicker({
			dateFormat : "yy-mm-dd"
		});
	}
	function modalEditTeacher(event) {
		console.log("modalEditTeacher->fired");
		event.preventDefault();

		var data = JSON.stringify($("#eidtTeacherForm").serializeObject());
		console.log("data=", data);

		$.ajax({
			type : "POST",
			url : "<c:url value="/admin/teachers/update"/>",
			data : data,
			contentType : "application/json",
			success : function(data) {
				console.log("data=", data);
				$("#edit-teacher-container").html(data);
			},
			error : function(response) {
				$("#modal-body").html(response.responseText);
				$("#modal").modal("show");
			}
		});
	}
</script>