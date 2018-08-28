<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="edit-lesson-time-container">
	<sf:form id="edit-lesson-time-form" method="POST"
		commandName="lessonTime" onsubmit="modalEditLessonTime(event)">
		<sf:input path="id" type="hidden" />
		<table class="w-100">
			<tbody>
				<tr>
					<td>کات</td>
					<fmt:formatDate value="${lessonTime.time}" pattern="HH:mm"
						var="formattedTime" />
					<td><input id="lesson-time"
						class="form-control form-control-sm" name="time"
						value="${formattedTime}"></td>
					<td><sf:errors path="time" /></td>
				</tr>
				<tr>
					<td>
						<button class="btn btn-sm  btn-warning">
							<i class="fa fa-edit"></i>
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
	function modalEditLessonTime(event) {
		console.log("modalEditLessonTime->fired");
		event.preventDefault();
		var data = JSON
				.stringify($("#edit-lesson-time-form").serializeObject());
		console.log("data=", data);

		$.ajax({
			type : "POST",
			url : "<c:url value="/lessonTimes/edit"/>",
			data : data,
			contentType : "application/json",
			success : function(response) {
				console.log("response=", response);
				$("#edit-lesson-time-container").html(response);
			},
			error : function(response) {
				$("#modal-body").html(response.responseText);
				$("#modal").modal("show");
			}
		});
	}
</script>