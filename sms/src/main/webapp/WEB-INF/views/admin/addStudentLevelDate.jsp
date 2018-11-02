<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div>
	<sf:form id="add-student-level-date-form" method="POST"
		commandName="studentLevelDate" onsubmit="addStudentLevelDate(event)">
		<table class="w-100">
			<tbody>
				<tr>
					<td>بەروار</td>
					<td><sf:input readonly="true"
							cssClass="form-control form-control-sm" path="date" /></td>
					<td><sf:errors path="date" /></td>
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
	$(document).ready()
	{
		$("#date").datepicker({
			dateFormat : "yy-mm-dd"
		});

		$("#modal").append($("#ui-datepicker-div"));

	};
	function addStudentLevelDate(event) {
		event.preventDefault();
		console.log("addStudentLevelDate->fired");
		console.log($("#add-student-level-date-form").serializeObject());

		$.ajax({
			type : "POST",
			url : "<c:url value="/studentLevelDates/add"/>",
			data : JSON.stringify($("#add-student-level-date-form")
					.serializeObject()),
			contentType : "application/json",
			success : function(response) {
				$("#modal-body").html(response);
				$("#modal").modal("show");
			},
			error : function(response) {
				$("#modal-body").html(response.responseText);
				$("#modal").modal("show");
			}
		});
	}
</script>