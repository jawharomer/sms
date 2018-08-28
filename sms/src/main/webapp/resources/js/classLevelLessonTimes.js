function getAddLessonTime(_this) {
	console.log("getAddLessonTime->fired");
	var id = $(_this).data("class-level-id");
	console.log("id=", id);
	$.get($$ContextURL + "/lessonTimes/add/classLevel/" + id,
			function(response) {
				console.log("response=", response);
				$("#modal").modal("show");
				$("#modal-body").html(response);
			});

}

function deleteLessonTime(_this) {
	console.log("deleteLessonTime->fired");
	console.log(_this);
	var id = $(_this).data("lesson-time-id");
	console.log("id=", id);

	$.when(cusConfirm()).done(function(result) {
		if (result) {
			$.ajax({
				url : $$ContextURL + '/lessonTimes/delete/' + id,
				type : 'POST',
				success : function(response) {
					console.log(response);
					if (response == "success") {
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

function editLessonTime(_this) {
	console.log(_this);
	var id = $(_this).data("lesson-time-id");
	console.log("id=", id);
	$.get($$ContextURL + "/lessonTimes/edit/" + id, function(response) {
		console.log("response=", response);
		$("#modal-body").html(response);
		$("#modal").modal("show");
	});
}