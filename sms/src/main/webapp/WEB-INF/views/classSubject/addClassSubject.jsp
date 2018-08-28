<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-class-subject-container">
	<sf:form id="add-class-subject-form" method="POST"
		commandName="classSubject" onsubmit="addClassSubject(event)">
		<table class="w-100">
			<tbody>
				<tr>
					<td>ناو</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="name" /></td>
					<td><sf:errors path="name" /></td>
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
	function addClassSubject(event) {
		event.preventDefault();
		console.log("addClassSubject->fired");

		var data = $("#add-class-subject-form").serializeObject();
		console.log("data=", data);

		$
				.ajax({
					type : "POST",
					url : "<c:url value="/classSubjects/add/classLevel/"/>${classLevelId}",
					data : JSON.stringify(data),
					contentType : "application/json",
					success : function(response) {
						$("#add-class-subject-container").html(response);
					},
					error : function(response) {
						$("#modal-body").html(response.responseText);
						$("#modal").modal("show");
					}
				});
	}
</script>