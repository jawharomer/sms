$(document).ready()
{
	var table = $('#studentsTable').DataTable({
		paginate : false,
		dom : 'Bfrtip',
		buttons : [ {
			extend : "excel",
			charset : 'UTF-8',
			className : "btn btn-sm  btn-outline-info",
			exportOptions : {
				columns : ':not(.cus-not-export)'
			}
		}, {
			extend : "csv",
			charset : 'UTF-8',
			className : "btn btn-sm btn-outline-info",
			exportOptions : {
				columns : ':not(.cus-not-export)'
			}
		} ]
	});

}

function getAddStudent() {
	console.log("getAddStudent->fired");
	$.get("./students/add", function(response) {
		console.log("response=", response);
		$("#modal-body").html(response);
		$("#modal").modal("show");
	});

}

function deleteStudent(_this) {

	console.log(_this);
	$.when(cusConfirm()).done(function(value) {
		if (value) {
			var id = $(_this).data("student-id");
			console.log("id=", id);
			$.ajax({
				type : "POST",
				url : "./students/" + id,
				data : JSON.stringify($("#addStudentForm").serializeObject()),
				contentType : "application/json",
				success : function(data) {
					if (data == "success") {
						location.reload();
					}
				},
				error : function(response) {
					$("#modal-body").html(response.responseText);
					$("#modal").modal("show");
				}
			});
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

function getAddUser(_this) {
	var id = $(_this).data("student-id");
	var role = $(_this).data("role");

	console.log("reference=", id);
	console.log("role=", role);
	$.ajax({
		type : "GET",
		url : $$ContextURL + "/admin/users/add/" + role,
		data : {
			reference : id
		},
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