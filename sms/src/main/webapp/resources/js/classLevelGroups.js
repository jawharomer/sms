function getAddClassGroup(_this) {
	console.log("getAddClassGroup->fired");
	var id = $(_this).data("class-level-id");
	console.log("id=", id);
	$.get($$ContextURL + "/classGroups/add/classLevel/" + id,
			function(response) {
				console.log("response=", response);
				$("#modal").modal("show");
				$("#modal-body").html(response);
			});

}

function deleteClassGroup(_this) {
	console.log("deleteClassGroup->fired");
	console.log(_this);
	var id = $(_this).data("class-group-id");
	console.log("id=", id);
	$.ajax({
		url : $$ContextURL + '/classGroups/' + id,
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

function editClassGroup(_this) {
	console.log(_this);
	var id = $(_this).data("class-group-id");
	console.log("id=", id);
	$.get($$ContextURL + "/classGroups/edit/" + id, function(response) {
		console.log("response=", response);
		$("#modal-body").html(response);
		$("#modal").modal("show");
	});

}