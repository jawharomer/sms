<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-classlevel-container">
	<sf:form id="addClassLevelForm" method="POST" commandName="classLevel"
		onsubmit="addClassLevel(event)">
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
						<button class="btn btn-sm  btn-success">
							<i class="fa fa-plus"></i>
						</button>
					</td>

				</tr>

			</tbody>

		</table>


	</sf:form>

</div>


<script>
	function addClassLevel(event) {
		event.preventDefault();
		console.log("addClassLevel->fired");
		console.log($("#addClassLevelForm").serializeObject());
		$.ajax({
			type : "POST",
			url : "<c:url value="/classLevels/add"/>",
			data : JSON.stringify($("#addClassLevelForm").serializeObject()),
			contentType : "application/json",
			success : function(data) {
				$("#add-classlevel-container").html(data);
			},
			error : function(response) {
				$("#modal-body").html(response.responseText);
				$("#modal").modal("show");
			}
		});
	}
</script>