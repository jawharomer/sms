function getAddClassSubject(_this) {
	console.log("getAddClassSubject->fired");
	var id = $(_this).data("class-level-id");
	console.log("id=", id);
	$.get($$ContextURL + "/classSubjects/add/classLevel/" + id, function(
			response) {
		console.log("response=", response);
		$("#modal").modal("show");
		$("#modal-body").html(response);
	});

}

function deleteClassSubject(_this) {
	console.log("deleteClassSubject->fired");
	console.log(_this);
	var id = $(_this).data("class-subject-id");
	console.log("id=", id);
	$.ajax({
		url : $$ContextURL + '/classSubjects/' + id,
		type : 'DELETE',
		success : function(response) {
			console.log(response);
			if (response == "success") {
				location.reload();
			}
		},
		failure : function(errMsg) {
			alert(errMsg);
		}
	});
}

function editClassSubject(_this) {
	console.log(_this);
	var id = $(_this).data("class-subject-id");
	console.log("id=", id);
	$.get($$ContextURL + "/classSubjects/edit/" + id, function(response) {
		console.log("response=", response);
		$("#modal-body").html(response);
		$("#modal").modal("show");
	});

}