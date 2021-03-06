<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-student-notificaion-container">
	<sf:form id="add-student-notificaion-form" method="POST"
		commandName="studentNotificaionD"
		onsubmit="addStudentNotificaion(event)">
		<table class="w-100">
			<tbody>
				<tr>
					<td colspan="3"><sf:errors path="studentIds" /></td>
				</tr>
				<tr>
					<td>ناونیشان</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="title" /></td>
					<td><sf:errors path="title" /></td>
				</tr>

				<tr>
					<td>تێبینی</td>
					<td><sf:textarea cssClass="form-control form-control-sm"
							path="note" /></td>
					<td><sf:errors path="note" /></td>
				</tr>
				<tr>
					<td>
						<button class="btn btn-outline-success btn-sm">
							<i class="fa fa-plus"></i>
						</button>
					</td>
				</tr>

			</tbody>

		</table>

	</sf:form>

</div>


<script>

$(document)
.ready(
		function() {
			tinymce.remove();

			tinymce
					.init({
						selector : 'textarea',
						height : 200,
						plugins : [
								'table',
								'advlist autolink lists link image charmap print preview anchor textcolor',
								'searchreplace visualblocks code fullscreen',
								'insertdatetime media table contextmenu paste code help wordcount' ],
						toolbar : 'table|insert | undo redo |  formatselect | bold italic backcolor  | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | removeformat | help',
						content_css : $$ContextURL
								+ "/resources/css/cusTinymce.css",
						directionality : 'rtl',
						setup : function(ed) {
							ed
									.on(
											'init',
											function() {
												this.getDoc().body.style.fontSize = '20px';
												this.getDoc().body.style.fontFamily = 'Noto Kufi Arabic';
											});
						}
					});
		});

$(document).on('focusin', function(e) {
if ($(event.target).closest(".mce-window").length) {
e.stopImmediatePropagation();
}
});



	function addStudentNotificaion(event) {
		event.preventDefault();
		tinymce.triggerSave();
		console.log("addStudentNotificaion->fired");
		var data = $("#add-student-notificaion-form").serializeObject();
		data.studentIds =cusPF(${studentIds});
		console.log("data=", data);
		$.ajax({
			type : "POST",
			url : "<c:url value="/admin/students/notificaions/add"/>",
			data : JSON.stringify(data),
			contentType : "application/json",
			success : function(response) {
				$("#add-student-notificaion-container").html(response);
			},
			error : function(response) {
				$("#modal-body").html(response.responseText);
				$("#modal").modal("show");
			}
		});
	}
</script>