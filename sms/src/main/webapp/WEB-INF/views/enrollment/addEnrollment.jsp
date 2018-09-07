<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-enrollment-container">
	<sf:form id="add-enrollment-form" method="POST"
		commandName="enrollmentD" onsubmit="addEnrollment(event)">
		<table class="w-100">
			<tbody>
				<tr>
					<td>قوتابی</td>
					<td><sf:select cssClass="form-control form-control-sm"
							path="studentId">
							<c:if test="${enrollmentD.studentId==null}">
								<option value="null">هالبژێرە</option>
							</c:if>
							<c:forEach items="${students}" var="item">
								<c:choose>
									<c:when test="${item.id==enrollmentD.studentId}">
										<option value="${item.id}" selected="true">${item.firstName}&nbsp;${item.middleName}&nbsp;${item.lastName}
										</option>
									</c:when>
									<c:otherwise>
										<option value="${item.id}">${item.firstName}&nbsp;${item.middleName}&nbsp;${item.lastName}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</sf:select></td>
					<td></td>
					<td><sf:errors path="studentId" /></td>
				</tr>

				<tr>
					<td>پۆل</td>
					<td><sf:select cssClass="form-control form-control-sm"
							path="classGroupId">
							<c:if test="${enrollmentD.classGroupId==null}">
								<option value="null">هالبژێرە</option>
							</c:if>
							<c:forEach items="${classGroups}" var="item">
								<c:choose>
									<c:when test="${item.id==enrollmentD.classGroupId}">
										<option value="${item.id}" selected="true">${item.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${item.id}">${item.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</sf:select></td>
					<td></td>
					<td><sf:errors path="classGroupId" /></td>
				</tr>

				<tr>
					<td>بردی پارە</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="fee" /></td>
					<td><sf:errors path="fee" /></td>
				</tr>

				<tr>
					<td>تێبینی</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="note" /></td>
					<td><sf:errors path="note" /></td>
				</tr>

				<tr>
					<td>
						<button class="btn btn-sm btn-success">
							<i class="fa fa-plus"></i>
						</button></td>

				</tr>

			</tbody>

		</table>

	</sf:form>

</div>


<script>
	function addEnrollment(event) {
		event.preventDefault();
		console.log("addEnrollment->fired");
		var data = $("#add-enrollment-form").serializeObject();
		console.log("data=", data);
		$.ajax({
			type : "POST",
			url : "<c:url value="/enrollments/add/"/>",
			data : JSON.stringify(data),
			contentType : "application/json",
			success : function(response) {
				$("#add-enrollment-container").html(response);
			},
			error : function(response) {
				$("#modal-body").html(response.responseText);
				$("#modal").modal("show");
			}
		});
	}
</script>