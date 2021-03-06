<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="edit-school-week-day-container">

	<sf:form id="edit-school-week-day-form" method="POST"
		commandName="schoolWeekDay" onsubmit="modalEditSchoolWeekDay(event)">
		<sf:input path="id" type="hidden" />
		<table class="w-100">
			<tbody>
				<tr>
					<td>رۆژی هەفتە</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="weekDay" /></td>
					<td><sf:errors path="weekDay" /></td>
				</tr>
				<tr>
					<td>
						<button class="btn btn-sm btn-success">
							<i class="fa fa-plus"></i>
						</button>
					</td>
				</tr>

			</tbody>

		</table>
		

	</sf:form>

</div>


<script>
	function modalEditSchoolWeekDay(event) {
		console.log("modalEditSchoolWeekDay->fired");
		event.preventDefault();
		var data = JSON.stringify($("#edit-school-week-day-form")
				.serializeObject());
		console.log("data=", data);
		$.ajax({
			type : "POST",
			url : "<c:url value="/schoolWeekDays/update"/>",
			data : data,
			contentType : "application/json",
			success : function(response) {
				console.log("response=", response);
				$("#edit-school-week-day-container").html(response);
			},
			error : function(response) {
				$("#modal-body").html(response.responseText);
				$("#modal").modal("show");
			}
		});
	}
</script>