<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-enrollment-payment-container">

	Adding Enrollment Payment

	<sf:form id="add-enrollment-payment-form" method="POST"
		commandName="enrollmentPayment" onsubmit="addEnrollmentPayment(event)">
		<table>
			<tbody>
				<tr>
					<td>بر</td>
					<td><sf:input path="amount" /></td>
					<td><sf:errors path="amount" /></td>
				</tr>

				<tr>
					<td>تێبینی</td>
					<td><sf:input path="note" /></td>
					<td><sf:errors path="note" /></td>
				</tr>
				<tr>
					<td>Add</td>
					<td><input type="submit" value="Adding"></td>
				</tr>

			</tbody>

		</table>

	</sf:form>

</div>


<script>
	function addEnrollmentPayment(event) {
		event.preventDefault();
		console.log("addEnrollmentPayment->fired");
		var data = $("#add-enrollment-payment-form").serializeObject();
		console.log("data=", data);
		$.ajax({
			type : "POST",
			url : "<c:url value="/enrollmentPayments/add/"/>${enrollmentId}",
			data : JSON.stringify(data),
			contentType : "application/json",
			success : function(response) {
				$("#add-enrollment-payment-container").html(response);
			},
			failure : function(errMsg) {
				alert(errMsg);
			}
		});
	}
</script>