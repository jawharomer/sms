<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-user-container">
	<sf:form id="add-user-form" method="POST" commandName="appUser"
		onsubmit="addUser(event)">

		<sf:input path="id" type="hidden" />
		<sf:input path="reference" type="hidden" />
		<sf:input path="role" type="hidden" />
		<sf:errors path="role" />
		<table class="w-100">
			<tbody>
				<tr>
					<td>ناوی بەکاربەر</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="userName" /></td>
					<td><sf:errors path="userName" /></td>
				</tr>


				<tr>
					<td>وشەی تێپەر</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="password" /></td>
					<td><sf:errors path="password" /></td>
				</tr>

				<tr>
					<td><c:if test="${appUser.id==null}">
							<button class="btn btn-sm btn-success">
								<i class="fa fa-plus"></i>
							</button>
						</c:if> <c:if test="${appUser.id!=null}">
							<button class="btn btn-sm btn-warning">
								<i class="fa fa-edit"></i>
							</button>
						</c:if></td>
				</tr>

			</tbody>

		</table>


	</sf:form>

</div>


<script>
	function addUser(event) {
		event.preventDefault();
		console.log("addUser->fired");
		var data = $("#add-user-form").serializeObject();
		console.log("data=", data);
		$.ajax({
			type : "POST",
			url : "<c:url value="/admin/users/add"/>",
			data : JSON.stringify(data),
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