<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-student-container">



	<sf:form id="addStudentForm" method="POST" commandName="student"
		onsubmit="addStudent(event)" action="/admin/students/add">
		<table class="w-100">
			<tbody>
				<tr>
					<td>ناوی قوتابی</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="firstName" /></td>
					<td><sf:errors path="firstName" /></td>
				</tr>

				<tr>
					<td>ناوی باوک</td>
					<td><sf:input cssClass="form-control  form-control-sm"
							path="middleName" /></td>
					<td><sf:errors path="middleName" /></td>
				</tr>

				<tr>
					<td>ناوی باپر</td>
					<td><sf:input cssClass="form-control  form-control-sm"
							path="lastName" /></td>
					<td><sf:errors path="lastName" /></td>
				</tr>

				<tr>
					<td>بەواری لەدایکبون</td>
					<td><sf:input cssClass="form-control  form-control-sm"
							path="birthDate" id="birthDate" /></td>
					<td><sf:errors path="birthDate" /></td>
				</tr>

				<tr>
					<td>ناوی بەکاربەر</td>
					<td><sf:input cssClass="form-control  form-control-sm"
							path="userName" /></td>
					<td><sf:errors path="userName" /></td>
				</tr>


				<tr>
					<td>وشەی نهێنی</td>
					<td><sf:input cssClass="form-control  form-control-sm"
							path="password" /></td>
					<td><sf:errors path="password" /></td>
				</tr>

				<tr>
					<td>ناوی بەرکارەبەری بەخێوکەر</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="parentUserName" /></td>
					<td><sf:errors path="parentUserName" /></td>
				</tr>

				<tr>
					<td>وشوی تێپەری بەخێوکەر</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="parentPassword" /></td>
					<td><sf:errors path="parentPassword" /></td>
				</tr>

				<tr>
					<td>رەگەز</td>
					<td>
						<div class="form-check form-check-inline">
							<sf:radiobutton path="gender" label="مێ" value="${0}" />
						</div>
						<div class="form-check form-check-inline">
							<sf:radiobutton path="gender" label="نێر" value="${1}" />
						</div>
					</td>
					<td><sf:errors path="gender" /></td>
				</tr>

				<tr>
					<td>ژ.مۆبایل</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="mobile" /></td>
					<td><sf:errors path="mobile" /></td>
				</tr>

				<tr>
					<td>ژ.م بەخێوکەر</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="parentMobile" /></td>
					<td><sf:errors path="parentMobile" /></td>
				</tr>



				<tr>
					<td>
						<button class="btn btn-outline-success btn-sm">
							<i class="fa fa-plus"></i>
						</button>
					</td>
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
			success : function(response) {
				$("#add-student-container").html(response);
			},
			error : function(response) {
				$("#modal-body").html(response.responseText);
				$("#modal").modal("show");
			}
		});
	}
</script>