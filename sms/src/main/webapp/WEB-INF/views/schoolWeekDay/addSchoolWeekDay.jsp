<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-school-week-day-container">
	<sf:form id="add-school-week-day-form" method="POST"
		commandName="schoolWeekDay" onsubmit="addSchoolWeekDay(event)">
		<table>
			<tbody>
				<tr>
					<td>weekDay</td>
					<td><sf:input path="weekDay" /></td>
					<td><sf:errors path="weekDay" /></td>
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
	function addSchoolWeekDay(event) {
		event.preventDefault();
		console.log("addSchoolWeekDay->fired");
		console.log($("#add-school-week-day-form").serializeObject());
		$.ajax({
			type : "POST",
			url : "<c:url value="/schoolWeekDays/add"/>",
			data : JSON.stringify($("#add-school-week-day-form")
					.serializeObject()),
			contentType : "application/json",
			success : function(response) {
				$("#add-school-week-day-container").html(response);
			},
			failure : function(errMsg) {
				alert(errMsg);
			}
		});
	}
</script>