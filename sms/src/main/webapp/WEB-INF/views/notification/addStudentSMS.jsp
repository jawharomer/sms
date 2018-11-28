<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-student-sms-container">
	<h4>ناردنی کورتەنامە</h4>
	<sf:form id="add-student-sms-form" method="POST"
		commandName="studentNotificaionD" onsubmit="addStudentSMS(event)">
		<table class="w-100">
			<tbody>
				<tr>
					<td colspan="3"><sf:errors path="studentIds" /></td>
				</tr>
				<tr>
					<td><label>قوتابی<sf:radiobutton path="title"
								value="0" /></label> <label>بەخێوکەر<sf:radiobutton
								path="title" value="1" /></label> <label>قوتابی-بەخێوکەر<sf:radiobutton
								path="title" value="2" /></label></td>
					<td><c:set var="selectedContact">
							<sf:errors path="title" />
						</c:set> <c:if test="${not empty  selectedContact}">
						تکایە یەکێک لەمانە هەلبژێرە
						</c:if></td>
				</tr>

				<tr>
					<td><sf:textarea cssClass="form-control form-control-sm"
							path="note" /></td>
					<td><sf:errors path="note" /></td>
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
	function addStudentSMS(event) {
		event.preventDefault();
		console.log("addStudentSMS->fired");
		var data = $("#add-student-sms-form").serializeObject();
		data.studentIds =cusPF(${studentIds});
		console.log("data=", data);
		showProgress();
		$.ajax({
			type : "POST",
			url : "<c:url value="/admin/students/sms/add"/>",
			data : JSON.stringify(data),
			contentType : "application/json",
			success : function(response) {
				$("#modal-body").html(response);
				$("#modal").modal("show");
			},
			error : function(response) {
				$("#modal-body").html(response.responseText);
				$("#modal").modal("show");
			},
			complete:function(response){
				hideProgress();
			}
		});
	}
</script>