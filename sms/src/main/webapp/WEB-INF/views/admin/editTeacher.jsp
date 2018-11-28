<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="edit-teacher-container">

	<sf:form id="eidtTeacherForm" method="POST" commandName="teacher"
		onsubmit="modalEditTeacher(event)">
		<sf:input path="id" type="hidden" />
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
					<td>مۆبایل</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="mobile" /></td>
					<td><sf:errors path="mobile" /></td>
				</tr>

				<tr>
					<td>بری دامەزراندن</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="hireAmount" /></td>
					<td><sf:errors path="hireAmount" /></td>
				</tr>

				<tr>
					<td>تێبینی</td>
					<td><sf:textarea cssClass="form-control form-control-sm"
							path="note" /></td>
					<td><sf:errors path="note" /></td>
				</tr>

				<tr>
					<td>
						<button class="btn btn-sm btn-outline-warning">
							<i class="fa fa-edit"></i>
						</button>
					</td>
				</tr>
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