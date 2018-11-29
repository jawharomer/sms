<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div>

	<sf:form id="edit-expense-form" method="POST" commandName="expense"
		onsubmit="editExpense(event)">
		<sf:input path="id" type="hidden" />
		<table class="w-100">
			<tbody>
				<tr>
					<td>بڕ</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="amount" /></td>
					<td><sf:errors path="amount" /></td>
				</tr>

				<tr>
					<td>جۆر</td>
					<td><sf:input cssClass="form-control  form-control-sm"
							path="type" /></td>
					<td><sf:errors path="type" /></td>
				</tr>

				<tr>
					<td>تێبینی</td>
					<td><sf:textarea cssClass="form-control" path="note" /></td>
					<td><sf:errors path="note" /></td>
				</tr>

				<tr>
					<td>
						<button class="btn btn-outline-warning btn-sm">
							<i class="fa fa-edit"></i>
						</button>
					</td>
				</tr>

			</tbody>

		</table>


	</sf:form>

</div>


<script>
	function editExpense(event) {
		event.preventDefault();
		console.log("editExpense->fired");

		console.log($("#edit-expense-form").serializeObject());
		$.ajax({
			type : "POST",
			url : "<c:url value="/expenses/update"/>",
			data : JSON.stringify($("#edit-expense-form").serializeObject()),
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
