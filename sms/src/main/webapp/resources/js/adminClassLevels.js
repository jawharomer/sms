function getAddClassLevel() {
	console.log("getAddClassLevel->fired");
	$.get($$ContextURL + "/classLevels/add", function(response) {
		console.log("response=", response);
		$("#modal").modal("show");
		$("#modal-body").html(response);
	});

}

function deleteClassLevel(_this) {
	console.log("deleteClassLevel->fired");
	console.log(_this);
	var id = $(_this).data("classlevel-id");
	console.log("id=", id);
	$.ajax({
		url : $$ContextURL + '/classLevels/' + id,
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

function editClassLevel(_this) {
	console.log(_this);
	var id = $(_this).data("classlevel-id");
	console.log("id=", id);
	$.get($$ContextURL+"/classLevels/edit/" + id, function(result) {
		console.log("result=", result);
		$("#modal-body").html(result);
		$("#modal").modal("show");
	});

}