$(document).ready(function() {
	console.log("Activate data table");
	var table = $('#teachersTable').DataTable({
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
		} ],
		bInfo : false,
	});
});

function getAddTeacher() {
	console.log("getAddTeacher->fired");
	$.get($$ContextURL + "/teachers/add", function(response) {
		console.log("response=", response);
		$("#modal-body").html(response);
		$("#modal").modal("show");
	});
}

function deleteTeacher(_this) {
	console.log("deleteTeacher->fired");
	console.log(_this);
	var id = $(_this).data("teacher-id");
	console.log("id=", id);

	$.when(cusConfirm()).done(function(result) {
		if (result) {
			$.ajax({
				url : $$ContextURL + '/teachers/' + id,
				type : 'POST',
				success : function(result) {
					console.log(result);
					if (result == "success") {
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

function editTeacher(_this) {
	console.log(_this);
	var id = $(_this).data("teacher-id");
	console.log("id=", id);

	$.get($$ContextURL + "/teachers/edit/" + id, function(result) {
		console.log("result=", result);
		$("#modal-body").html(result);
		$("#modal").modal("show");
	});

}