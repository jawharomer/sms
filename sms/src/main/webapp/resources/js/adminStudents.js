$(document).ready(function() {
	console.log("Activate data table");
	$("#studentTable").DataTable({
		responsive : true
	});
});

function getAddStudent() {
	console.log("getAddStudent->fired");
	$.get("./students/add", function(response) {
		console.log("response=", response);
		$("#modal-body").html(response);
	});

}

function deleteStudent(_this) {
	console.log(_this);
	var id = $(_this).data("student-id");
	console.log("id=", id);
	$.ajax({
		type : "DELETE",
		url : "./students/" + id,
		data : JSON.stringify($("#addStudentForm").serializeObject()),
		contentType : "application/json",
		success : function(data) {
			if (data == "success") {
				location.reload();
			}
		},
		failure : function(errMsg) {
			alert(errMsg);
		}
	});
}

function editStudent(_this) {
	console.log(_this);
	var id = $(_this).data("student-id");
	console.log("id=", id);

	$.get("./students/edit/" + id, function(response) {
		console.log("response=", response);
		$("#modal-body").html(response);
		$("#modal").modal("show");
	});

}