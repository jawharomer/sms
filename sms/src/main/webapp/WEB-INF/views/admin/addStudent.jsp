<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-student-container">



	<sf:form id="addStudentForm" method="POST" commandName="student"
		onsubmit="addStudent(event)" action="/admin/students/add">
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
	function addStudent(event) {
		event.preventDefault();
		console.log("addStudent->fired");

		console.log($("#addStudentForm").serializeObject());

		$.ajax({
			type : "POST",
			url : "<c:url value="/admin/students/add"/>",
			data : JSON.stringify($("#addStudentForm").serializeObject()),
			contentType : "application/json",
			success : function(data) {
				$("#add-student-container").html(data);
			},
			failure : function(errMsg) {
				alert(errMsg);
			}
		});
	}
</script>