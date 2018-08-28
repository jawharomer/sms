<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-class-group-table-container">

	<sf:form id="add-class-group-table-form" method="POST"
		commandName="classGroupTableD" onsubmit="addClassGroupTable(event)">
		<sf:input type="hidden" path="classGroupId" />
		<sf:input type="hidden" path="schoolWeekDayId" />
		<sf:input type="hidden" path="lessonTimeId" />

		<table class="w-100">
			<tbody>

				<tr>
					<td>بابەت</td>
					<td><sf:select cssClass="form-control form-control-sm"
							path="classSubjectId">
							<c:if test="${classGroupTableD.classSubjectId==null}">
								<option value="null">بابەت</option>
							</c:if>
							<c:forEach items="${classSubjects}" var="item">
								<c:choose>
									<c:when test="${item.id==classGroupTableD.classSubjectId}">
										<option value="${item.id}" selected="true">${item.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${item.id}">${item.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</sf:select></td>
					<td><sf:errors path="classSubjectId" /></td>
				</tr>
				<tr>
					<td>مامۆستا</td>
					<td><sf:select cssClass="form-control form-control-sm"
							path="teacherId">
							<c:if test="${classGroupTableD.teacherId==null}">
								<option value="null">مامۆستا</option>
							</c:if>
							<c:forEach items="${teachers}" var="item">

								<c:choose>
									<c:when test="${item.id==classGroupTableD.teacherId}">
										<option value="${item.id}" selected="true">${item.firstName}</option>
									</c:when>
									<c:otherwise>
										<option value="${item.id}">${item.firstName}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</sf:select></td>
					<td><sf:errors path="teacherId" /></td>
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
	function addClassGroupTable(event) {
		event.preventDefault();
		console.log("addClassGroupTable->fired");
		var data = $("#add-class-group-table-form").serializeObject();
		console.log("data=", data);
		$
				.ajax({
					type : "POST",
					url : "<c:url value="/classGroupTables/add/"/>${classGroupTableD.classGroupId}",
					data : JSON.stringify(data),
					contentType : "application/json",
					success : function(response) {
						$("#add-class-group-table-form").html(response);
					},
					error : function(response) {
						$("#modal-body").html(response.responseText);
						$("#modal").modal("show");
					}
				});
	}
</script>