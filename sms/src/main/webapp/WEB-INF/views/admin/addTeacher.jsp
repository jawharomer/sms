<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-teacher-container">
	<sf:form id="addTeacherForm" method="POST" commandName="teacher"
		onsubmit="addTeacher(event)">
		<table class="w-100">
			<tbody>
				<tr>
					<td>ناو</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="firstName" /></td>
					<td><sf:errors path="firstName" /></td>
				</tr>

				<tr>
					<td>ناوی باوک</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="middleName" /></td>
					<td><sf:errors path="middleName" /></td>
				</tr>

				<tr>
					<td>ناوی باپیر</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="lastName" /></td>
					<td><sf:errors path="lastName" /></td>
				</tr>

				<tr>
					<td>بری دامەزراندن</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="hireAmount" /></td>
					<td><sf:errors path="hireAmount" /></td>
				</tr>


				<tr>
					<td>ناوی بەکاربەر</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="userName" /></td>
					<td><sf:errors path="userName" /></td>
				</tr>

				<tr>
					<td>وشەی تێپەر</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="password" /></td>
					<td><sf:errors path="password" /></td>
				</tr>

				<tr>
					<td>
						<button class="btn btn-sm btn-outline-success">
							<i class="fa fa-plus"></i>
						</button>
					</td>
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
			error : function(response) {
				$("#modal-body").html(response.responseText);
				$("#modal").modal("show");
			}
		});
	}
</script>