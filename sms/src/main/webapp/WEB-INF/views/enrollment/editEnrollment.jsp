<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-enrollment-container">

	Adding Enrollment

	<sf:form id="add-enrollment-form" method="POST"
		commandName="enrollmentD" onsubmit="addEnrollment(event)">
		<sf:input path="enrollmentId" type="hidden" />
		<table>
			<tbody>
				<tr>
					<td>Student name</td>
					<td><sf:select path="studentId">
							<c:if test="${enrollmentD.studentId==null}">
								<option value="null">qwtabi</option>
							</c:if>
							<c:forEach items="${students}" var="item">
								<c:choose>
									<c:when test="${item.id==enrollmentD.studentId}">
										<option value="${item.id}" selected="true">${item.lastName}&nbps;${item.middleName}&nbps;${item.firstName}</option>
									</c:when>
									<c:otherwise>
										<option value="${item.id}">${item.lastName}&nbsp;${item.middleName}&nbsp;${item.firstName}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</sf:select></td>
					<td></td>
					<td><sf:errors path="studentId" /></td>
				</tr>

				<tr>
					<td>classGroup</td>
					<td><sf:select path="classGroupId">
							<c:if test="${enrollmentD.classGroupId==null}">
								<option value="null">groupName</option>
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
					<td><sf:input path="fee" /></td>
				</tr>

				<tr>
					<td>تێبینی</td>
					<td><sf:input path="note" /></td>
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
	function addEnrollment(event) {
		event.preventDefault();
		console.log("addEnrollment->fired");
		var data = $("#add-enrollment-form").serializeObject();
		console.log("data=", data);
		$
				.ajax({
					type : "POST",
					url : "<c:url value="/enrollments/edit/"/>${enrollmentD.enrollmentId}",
					data : JSON.stringify(data),
					contentType : "application/json",
					success : function(response) {
						$("#add-enrollment-container").html(response);
					},
					failure : function(errMsg) {
						alert(errMsg);
					}
				});
	}
</script>