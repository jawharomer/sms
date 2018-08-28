<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="edit-class-mark-container">

	<sf:form id="edit-class-mark-form" method="POST"
		commandName="classMark" onsubmit="modalEditClassMark(event)">

		<sf:input path="id" type="hidden" />
		<table class="w-100">
			<tbody>
				<tr>
					<td>ناوی</td>
					<td><sf:input cssClass="form-control form-control-sm" path="name" /></td>
					<td><sf:errors path="name" /></td>
				</tr>
				<tr>
					<td>نمرە</td>
					<td><sf:input cssClass="form-control form-control-sm" path="limit" /></td>
					<td><sf:errors path="limit" /></td>
				</tr>
				<tr>
					<td>
						<button class="btn btn-warning btn-sm">
							<i class="fa fa-edit"></i>
						</button>
					</td>
				</tr>

			</tbody>

		</table>


	</sf:form>

</div>


<script>
	function modalEditClassMark(event) {
		console.log("modalEditClassMark->fired");
		event.preventDefault();
		var data = JSON.stringify($("#edit-class-mark-form")
				.serializeObject());
		console.log("data=", data);

		$.ajax({
			type : "POST",
			url : "<c:url value="/classMarks/edit"/>",
			data : data,
			contentType : "application/json",
			success : function(response) {
				console.log("response=", response);
				$("#edit-class-mark-container").html(response);
			},
			failure : function(errMsg) {
				alert(errMsg);
			}
		});
	}
</script>