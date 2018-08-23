<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="edit-student-container">

	<sf:form id="eidtStudentForm" method="POST" commandName="student"
		onsubmit="modalEditStudent(event)">

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
					<td>Birth Day</td>
					<td><sf:input path="birthDate" id="birthDate" /></td>
					<td><sf:errors path="birthDate" /></td>
				</tr>

				<tr>
					<td>Add</td>
					<td><input type="submit" value="Adding"></td>
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
	function modalEditStudent(event) {
		console.log("modalEditStudent->fired");
		event.preventDefault();

		var data = JSON.stringify($("#eidtStudentForm").serializeObject());
		console.log("data=", data);

		$.ajax({
			type : "POST",
			url : "<c:url value="/admin/students/update"/>",
			data : data,
			contentType : "application/json",
			success : function(data) {
				console.log("data=", data);
				$("#edit-student-container").html(data);
			},
			failure : function(errMsg) {
				alert(errMsg);
			}
		});
	}
</script>