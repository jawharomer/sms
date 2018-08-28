<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="edit-enrollment-payment-container">
	<sf:form id="edit-enrollment-payment-form" method="POST"
		commandName="enrollmentPayment"
		onsubmit="editEnrollmentPayment(event)">
		<table class="w-100">
			<tbody>
				<tr>
					<td>بر</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="amount" /></td>
					<td><sf:errors path="amount" /></td>
				</tr>

				<tr>
					<td>تێبینی</td>
					<td><sf:input cssClass="form-control form-control-sm"
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
	function editEnrollmentPayment(event) {
		event.preventDefault();
		console.log("editEnrollmentPayment->fired");
		var data = $("#edit-enrollment-payment-form").serializeObject();
		console.log("data=", data);
		$
				.ajax({
					type : "POST",
					url : "<c:url value="/enrollmentPayments/edit/"/>${enrollmentPayment.id}",
					data : JSON.stringify(data),
					contentType : "application/json",
					success : function(response) {
						$("#edit-enrollment-payment-container").html(response);
					},
					failure : function(errMsg) {
						alert(errMsg);
					}
				});
	}
</script>