<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="edit-classlevel-container">

	<sf:form id="eidtClassLevelForm" method="POST" commandName="classLevel"
		onsubmit="modalEditClassLevel(event)">
		<sf:input path="id" type="hidden" />
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
	function modalEditClassLevel(event) {
		console.log("modalEditClassLevel->fired");
		event.preventDefault();
		var data = JSON.stringify($("#eidtClassLevelForm").serializeObject());
		console.log("data=", data);
		$.ajax({
			type : "POST",
			url : "<c:url value="/classLevels/update"/>",
			data : data,
			contentType : "application/json",
			success : function(data) {
				console.log("data=", data);
				$("#edit-classlevel-container").html(data);
			},
			failure : function(errMsg) {
				alert(errMsg);
			}
		});
	}
</script>