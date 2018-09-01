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

function deleteSubjectNotificaion(_this) {
	console.log("deleteSubjectNotificaion->fired");
	console.log(_this);
	var id = $(_this).data("subject-notificaion-id");
	console.log("id=", id);
	$.when(cusConfirm()).done(function(result) {
		if (result) {
			$.ajax({
				url : $$ContextURL + '/teachers/notifications/delete/' + id,
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
