<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-subject-notification">
	<sf:form id="add-subject-notificaion-form" method="POST"
		commandName="subjectNotificationD"
		onsubmit="addSubjectNotificaion(event)">
		<sf:input type="hidden" path="classGroupId" />
		<sf:input type="hidden" path="classSubjectId" />
		<table class="w-100">

			<tr>
				<td>بابت</td>
				<td><sf:input cssClass="form-control" path="title" rows="4"
						cols="20" /></td>
				<td><sf:errors path="title" /></td>
			</tr>

			<tr>
				<td>ناوەڕۆک</td>
				<td><sf:textarea cssClass="form-control" path="note" rows="4"
						cols="20" /></td>
				<td><sf:errors path="note" /></td>
			</tr>


			<tr>
				<td>
					<button class="btn btn-outline-success btn-sm">
						<i class="fa fa-plus"></i>
					</button>
				</td>
			</tr>


		</table>

	</sf:form>

</div>


<script>
	function addSubjectNotificaion(event) {
		event.preventDefault();
		console.log("addSubjectNotificaion->fired");
		var data = $("#add-subject-notificaion-form").serializeObject();
		console.log("data=", data);
		$.ajax({
			type : "POST",
			url : "<c:url value="/teachers/notifications/add"/>",
			data : JSON.stringify(data),
			contentType : "application/json",
			success : function(data) {
				$("#add-subject-notification").html(data);
			},
			error : function(response) {
				$("#modal-body").html(response.responseText);
				$("#modal").modal("show");
			}
		});
	}
</script>