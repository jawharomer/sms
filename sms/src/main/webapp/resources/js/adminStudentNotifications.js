function getAddClassGroupTable(_this) {
	console.log("getAddClassGroupTable->fired");

	var id = $(_this).data("class-group-id");
	var schoolWeekDayId = $(_this).data("school-week-day-id");
	var lessonTimeId = $(_this).data("lesson-time-id");

	console.log("classGroupId=", id);
	console.log("schoolWeekDayId=", schoolWeekDayId);
	console.log("lessonTimeId=", lessonTimeId);

	$.ajax({
		url : $$ContextURL + "/classGroupTables/add/" + id,
		type : 'GET',
		data : {
			schoolWeekDayId : schoolWeekDayId,
			lessonTimeId : lessonTimeId
		},
		success : function(response) {
			console.log("response=", response);
			$("#modal").modal("show");
			$("#modal-body").html(response);
		},
		error : function(response) {
			$("#modal-body").html(response.responseText);
			$("#modal").modal("show");
		}
	});

}

function deleteStudentNotifications(_this) {
	console.log("deleteStudentNotifications->fired");
	var id = $(_this).data("student-notification-id");
	console.log("id=", id);
	$.when(cusConfirm()).done(
			function(result) {
				if (result) {
					$.ajax({
						url : $$ContextURL
								+ '/admin/students/notificaions/delete/' + id,
						type : 'POST',
						success : function(response) {
							console.log(response);
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

function getStudenttNotificationStudents(_this) {
	console.log("getStudenttNotificationStudents->fired");
	var id = $(_this).data("student-notification-id");
	console.log("id=", id);
	$.ajax({
		url : $$ContextURL + '/admin/notificaions/' + id + '/students',
		type : 'GET',
		success : function(response) {
			console.log(response);
			$("#modal-body").html(response);
			$("#modal").modal("show");
		},
		error : function(response) {
			$("#modal-body").html(response.responseText);
			$("#modal").modal("show");
		}
	});

}