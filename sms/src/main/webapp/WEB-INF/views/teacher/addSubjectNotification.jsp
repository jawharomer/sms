<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div id="add-subject-notification">
	<sf:form id="add-subject-notificaion-form" method="POST"
		commandName="subjectNotificationD"
		onsubmit="addSubjectNotificaion(event)">
		<sf:input type="hidden" path="classGroupId" />
		<sf:input type="hidden" path="classSubjectId" />
		<table class="w-100">

			<tr>
				<td>وێنە</td>
				<td><input type="file" class="form-control form-control-sm"
					name="file" /></td>
			</tr>

			<tr>
				<td>بابت</td>
				<td><sf:input cssClass="form-control" path="title" rows="4"
						cols="20" /></td>
				<td><sf:errors path="title" /></td>
			</tr>

			<tr>
				<td>ناوەڕۆک</td>
				<td><sf:textarea cssClass="form-control" path="note" rows="4"
						cols="20" /></td>
				<td><sf:errors path="note" /></td>
			</tr>


			<tr>
				<td>
					<button class="btn btn-outline-success btn-sm">
						<i class="fa fa-plus"></i>
					</button>
				</td>
			</tr>


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

	function addSubjectNotificaion(event) {
		event.preventDefault();
		tinymce.triggerSave();
		console.log("addSubjectNotificaion->fired");
		var data = $("#add-subject-notificaion-form").serializeObject();

		var form = $("#add-subject-notificaion-form")[0];
		console.log("form=", form);
		var data = new FormData(form);

		$.ajax({
			type : "POST",
			url : "<c:url value="/teachers/notifications/add"/>",
			data : data,
			enctype : 'multipart/form-data',
			processData : false, // Important!
			contentType : false,
			cache : false,
			success : function(response) {
				$("#modal-body").html(response);
				$("#modal").modal("show");
			},
			error : function(response) {
				$("#modal-body").html(response.responseText);
				$("#modal").modal("show");
			}
		});
	}
</script>