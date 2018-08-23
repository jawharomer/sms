<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="edit-lesson-time-container">
	${lessonTime}

	<sf:form id="edit-lesson-time-form" method="POST"
		commandName="lessonTime" onsubmit="modalEditLessonTime(event)">
${time}
		<sf:input path="id" type="hidden" />
		<table>
			<tbody>
				<tr>
					<td>Name</td>
					<fmt:formatDate value="${lessonTime.time}" pattern="HH:mm"
						var="formattedTime" />
					<td><input name="time" value="${formattedTime}"></td>
					<td><sf:errors path="time" /></td>
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
	function modalEditLessonTime(event) {
		console.log("modalEditLessonTime->fired");
		event.preventDefault();
		var data = JSON
				.stringify($("#edit-lesson-time-form").serializeObject());
		console.log("data=", data);

		$.ajax({
			type : "POST",
			url : "<c:url value="/lessonTimes/edit"/>",
			data : data,
			contentType : "application/json",
			success : function(response) {
				console.log("response=", response);
				$("#edit-lesson-time-container").html(response);
			},
			failure : function(errMsg) {
				alert(errMsg);
			}
		});
	}
</script>