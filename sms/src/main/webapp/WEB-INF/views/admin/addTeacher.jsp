<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-teacher-container">
	<sf:form id="addTeacherForm" method="POST" commandName="teacher"
		onsubmit="addTeacher(event)">
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
					<td>Hire Amount</td>
					<td><sf:input path="hireAmount" /></td>
					<td><sf:errors path="hireAmount" /></td>
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
	function addTeacher(event) {
		event.preventDefault();
		console.log("addTeacher->fired");
		console.log($("#addTeacherForm").serializeObject());
		$.ajax({
			type : "POST",
			url : "<c:url value="/admin/teachers/add"/>",
			data : JSON.stringify($("#addTeacherForm").serializeObject()),
			contentType : "application/json",
			success : function(data) {
				$("#add-teacher-container").html(data);
			},
			failure : function(errMsg) {
				alert(errMsg);
			}
		});
	}
</script>