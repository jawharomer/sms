$(document).ready(function() {
	console.log("Activate data table");
	$("#teacherTable").DataTable({
		responsive : true
	});
});

function getAddTeacher() {
	console.log("getAddTeacher->fired");
	$.get("./teachers/add", function(response) {
		console.log("response=", response);
		$("#modal").modal("show");
		$("#modal-body").html(response);
	});

}

function deleteTeacher(_this) {
	console.log("deleteTeacher->fired");
	console.log(_this);
	var id = $(_this).data("teacher-id");
	console.log("id=", id);
	$.ajax({
		url : './teachers/' + id,
		type : 'DELETE',
		success : function(result) {
			console.log(result);
			if (result == "success") {
				location.reload();
			}
		},
		failure : function(errMsg) {
			alert(errMsg);
		}
	});
}

function editTeacher(_this) {
	console.log(_this);
	var id = $(_this).data("teacher-id");
	console.log("id=", id);

	$.get("./teachers/edit/" + id, function(result) {
		console.log("result=", result);
		$("#modal-body").html(result);
		$("#modal").modal("show");
	});

}