<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-class-subject-container">
	<form id="add-balance-form" method="POST" onsubmit="addBalance(event)">
		<table class="w-100">
			<tbody>
				<tr>
					<td>ژمارەی کارتەکە</td>
					<td><input class="form-control form-control-sm"
						name="cardNumber" /></td>
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


	</form>

</div>


<script>
	function addBalance(event) {
		event.preventDefault();
		showProgress();
		console.log("addBalance->fired");

		var data = $("#add-balance-form").serialize();
		console.log("data=", data);
		$.ajax({
			type : "POST",
			url : "<c:url value="/messages/balance/add"/>",
			data : data,
			success : function(response) {
				$("#add-class-subject-container").html(response);
			},
			error : function(response) {
				$("#modal-body").html(response.responseText);
				$("#modal").modal("show");
			},
			complete : function(response) {
				hideProgress();
			}
		});
	}
</script>