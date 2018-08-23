<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-subject-notification">

	Adding Subject Notification Page

	<sf:form id="add-subject-notificaion-form" method="POST"
		commandName="subjectNotificationD"
		onsubmit="addSubjectNotificaion(event)">
		<sf:input type="hidden" path="classGroupId" />
		<sf:input type="hidden" path="classSubjectId" />
		<div>
			<sf:textarea path="note" rows="4" cols="20" />

			<button type="submit">Add Notificaion</button>
		</div>



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
			success : function(response) {
				$("#add-subject-notification-container").html(response);
			},
			failure : function(errMsg) {
				alert(errMsg);
			}
		});
	}
</script>