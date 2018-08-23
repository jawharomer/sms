function getAddClassMark(_this) {
	console.log("getAddClassMark->fired");
	var id = $(_this).data("class-level-id");
	console.log("id=", id);
	$.get($$ContextURL + "/classMarks/add/classLevel/" + id, function(
			response) {
		console.log("response=", response);
		$("#modal").modal("show");
		$("#modal-body").html(response);
	});

}

function deleteClassMark(_this) {
	console.log("deleteClassMark->fired");
	console.log(_this);
	var id = $(_this).data("class-mark-id");
	console.log("id=", id);
	$.ajax({
		url : $$ContextURL + '/classMarks/' + id,
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

function editClassMark(_this) {
	console.log(_this);
	var id = $(_this).data("class-mark-id");
	console.log("id=", id);
	$.get($$ContextURL + "/classMarks/edit/" + id, function(response) {
		console.log("response=", response);
		$("#modal-body").html(response);
		$("#modal").modal("show");
	});

}