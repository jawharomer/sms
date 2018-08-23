<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-class-mark-container">

	Adding class mark page

	<sf:form id="add-class-mark-form" method="POST" commandName="classMark"
		onsubmit="addClassMark(event)">
		<table>
			<tbody>
				<tr>
					<td>Name</td>
					<td><sf:input path="name" /></td>
					<td><sf:errors path="name" /></td>
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
	function addClassMark(event) {
		event.preventDefault();
		console.log("addClassMark->fired");
		var data = $("#add-class-mark-form").serializeObject();
		console.log("data=", data);
		$
				.ajax({
					type : "POST",
					url : "<c:url value="/classMarks/add/classLevel/"/>${classLevelId}",
					data : JSON.stringify(data),
					contentType : "application/json",
					success : function(response) {
						$("#add-class-mark-container").html(response);
					},
					failure : function(errMsg) {
						alert(errMsg);
					}
				});
	}
</script>