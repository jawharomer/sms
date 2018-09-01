$(document).ready(function() {

	$("#from").datepicker({
		dateFormat : "yy-mm-dd"
	}).datepicker("setDate", $("#from").val());

	$("#to").datepicker({
		dateFormat : "yy-mm-dd"
	}).datepicker("setDate", $("#to").val());
});

function getAddTeacherPresent() {
	console.log("getAddTeacherPresent->fired");
	$.ajax({
		url : $$ContextURL + '/admin/teacherPresents/add',
		type : 'GET',
		success : function(response) {
			console.log(response);
			$("#modal-body").html(response);
			$("#modal").modal("show");
		},
		error : function(response) {
			$("#modal-body").html(response.responseText);
			$("#modal").modal("show");
		}
	});
}

function deleteTeacherPresent(_this) {
	console.log("deleteStudentPresents->fired");
	$.when(cusConfirm()).done(function(value) {
		if (value) {
			var id = $(_this).data("teacher-present-id");
			console.log("id=", id);
			$.ajax({
				type : "POST",
				url : $$ContextURL + "/admin/teacherPresents/delete/" + id,
				contentType : "application/json",
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
	});

}
