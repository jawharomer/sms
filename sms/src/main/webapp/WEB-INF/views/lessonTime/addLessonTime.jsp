<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="add-lesson-time-container">
	<sf:form id="add-lesson-time-form" method="POST"
		commandName="lessonTime" onsubmit="addLessonTime(event)">
		<table class="w-100">
			<tbody>
				<tr>
					<td>کات</td>
					<fmt:formatDate value="${item.time}" pattern="HH:mm"
						var="formattedTime" />
					<td><input id="lesson-time" class="form-control form-control-sm" name="time"
						value="${formattedTime}"></td>
					<td><sf:errors path="time" /></td>
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

	function addLessonTime(event) {
		event.preventDefault();
		console.log("addLessonTime->fired");
		var data = $("#add-lesson-time-form").serializeObject();
		console.log("data=", data);
		$
				.ajax({
					type : "POST",
					url : "<c:url value="/lessonTimes/add/classLevel/"/>${classLevelId}",
					data : JSON.stringify(data),
					contentType : "application/json",
					success : function(response) {
						$("#add-lesson-time-container").html(response);
					},
					error : function(response) {
						$("#modal-body").html(response.responseText);
						$("#modal").modal("show");
					}
				});
	}
</script>