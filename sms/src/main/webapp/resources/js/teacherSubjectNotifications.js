function getAddSubjectNotification(_this) {
	console.log("getAddSubjectNotification->fired");
	var classGroupId = $(_this).data("class-group-id");
	var classSubjectId = $(_this).data("class-subject-id");

	console.log("classGroupId=", classGroupId);
	console.log("classSubjectId=", classSubjectId);

	$.ajax({
		url : $$ContextURL + "/teachers/notifications/add",
		type : 'GET',
		data : {
			classGroupId : classGroupId,
			classSubjectId : classSubjectId
		},
		success : function(response) {
			console.log("response=", response);
			$("#modal").modal("show");
			$("#modal-body").html(response);
		},
		failure : function(errMsg) {
			alert(errMsg);
		}
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
	$.get($$ContextURL + "/classLevels/edit/" + id, function(result) {
		console.log("result=", result);
		$("#modal-body").html(result);
		$("#modal").modal("show");
	});

}