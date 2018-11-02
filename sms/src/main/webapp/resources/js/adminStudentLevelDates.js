$(document).ready(function() {
	console.log("Activate data table");
	var table = $('#student-level-dates').DataTable({
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

function getAddingStudentLevelDates() {
	console.log("getAddingStudentLevelDates->fired");
	$.get($$ContextURL + "/studentLevelDates/add", function(response) {
		console.log("response=", response);
		$("#modal-body").html(response);
		$("#modal").modal("show");
	});
}

function deleteStudentLevelDate(id) {
	console.log("deleteStudentLevelDate->fired");
	console.log("id=", id);

	$.when(cusConfirm()).done(function(result) {
		if (result) {
			$.ajax({
				url : $$ContextURL + '/studentLevelDates/delete/' + id,
				type : 'POST',
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