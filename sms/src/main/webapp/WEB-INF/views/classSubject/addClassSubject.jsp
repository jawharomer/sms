<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-class-subject-container">

	Adding class subject page

	<sf:form id="add-class-subject-form" method="POST"
		commandName="classSubject" onsubmit="addClassSubject(event)">
		<table>
			<tbody>
				<tr>
					<td>Name</td>
					<td><sf:input path="name" /></td>
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
	function addClassSubject(event) {
		event.preventDefault();
		console.log("addClassSubject->fired");

		var data = $("#add-class-subject-form").serializeObject();
		console.log("data=", data);

		$
				.ajax({
					type : "POST",
					url : "<c:url value="/classSubjects/add/classLevel/"/>${classLevelId}",
					data : JSON.stringify(data),
					contentType : "application/json",
					success : function(response) {
						$("#add-class-subject-container").html(response);
					},
					failure : function(errMsg) {
						alert(errMsg);
					}
				});
	}
</script>