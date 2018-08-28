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

	$.when(cusConfirm()).done(function(result) {
		if (result) {
			$.ajax({
				url : $$ContextURL + '/classLevels/delete/' + id,
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

function editClassLevel(_this) {
	console.log(_this);
	var id = $(_this).data("classlevel-id");
	console.log("id=", id);
	$.get($$ContextURL + "/classLevels/edit/" + id, function(result) {
		console.log("result=", result);
		$("#modal-body").html(result);
		$("#modal").modal("show");
	});

}