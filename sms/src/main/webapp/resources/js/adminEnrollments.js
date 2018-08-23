function getAddEnrollment() {
	console.log("getAddEnrollment->fired");
	$.get($$ContextURL + "/enrollments/add", function(response) {
		console.log("response=", response);
		$("#modal").modal("show");
		$("#modal-body").html(response);
	});

}

function deleteEnrollment(_this) {
	console.log("deleteEnrollment->fired");
	console.log(_this);
	var id = $(_this).data("enrollment-id");
	console.log("id=", id);
	$.ajax({
		url : $$ContextURL + '/enrollments/' + id,
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

function editEnrollment(_this) {
	console.log("editEnrollment->fired");
	console.log(_this);
	var id = $(_this).data("enrollment-id");
	console.log("id=", id);
	$.get($$ContextURL + "/enrollments/edit/" + id, function(result) {
		console.log("result=", result);
		$("#modal-body").html(result);
		$("#modal").modal("show");
	});

}