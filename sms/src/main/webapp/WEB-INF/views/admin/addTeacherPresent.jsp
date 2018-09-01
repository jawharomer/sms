<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-teacher-container">
	<sf:form id="addTeacherForm" method="POST" commandName="teacherPresent"
		onsubmit="addTeacher(event)">
		<table class="w-100">
			<tbody>
				<tr>
					<td>بەروار</td>
					<td><sf:input cssClass="form-control form-control-sm" path="date" /></td>
					<td><sf:errors path="date" /></td>
				</tr>
				<tr>
					<td>مامۆستا</td>
					<td><select  class="form-control form-control-sm" name="teacher[id]">
							<option selected="selected" value="">هەلبژێرە</option>
							<c:forEach items="${teachers}" var="item">
								<option value="${item.id}">${item.firstName}</option>
							</c:forEach>
					</select></td>
					<td><sf:errors path="teacher" /> <sf:errors path="teacher.id" />
					</td>
				</tr>
				<tr>
					<td>ژ.وانەکان</td>
					<td><sf:input  cssClass="form-control form-control-sm" path="numberOfLectures" /></td>
					<td><sf:errors path="numberOfLectures" /></td>
				</tr>
				<tr>
					<td>تێبینی</td>
					<td><sf:input  cssClass="form-control form-control-sm" path="note" /></td>
					<td><sf:errors path="note" /></td>
				</tr>
				<tr>
					<td>
						<button>add</button>
					</td>
				</tr>

			</tbody>

		</table>


	</sf:form>

</div>


<script>
	$(document).ready()
	{
		$("#date").datepicker({
			dateFormat : "yy-mm-dd"
		});
	}
	function addTeacher(event) {
		event.preventDefault();
		console.log("addTeacher->fired");
		var data = $("#addTeacherForm").serializeJSON();
		console.log("data=", data);
		console.log("data=", JSON.stringify(data));
		var data = $.ajax({
			type : "POST",
			url : "<c:url value="/admin/teacherPresents/add"/>",
			data : JSON.stringify(data),
			contentType : "application/json",
			success : function(data) {
				$("#add-teacher-container").html(data);
			},
			error : function(response) {
				$("#modal-body").html(response.responseText);
				$("#modal").modal("show");
			}
		});
	}
</script>