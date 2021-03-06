$(document).ready()
{
	// S-DataTable
	var table = $('#student-presents-table').DataTable({

		columnDefs : [ {
			orderable : false,
			className : 'select-checkbox',
			targets : 0,
			data : 0
		} ],
		select : {
			style : 'multi'
		},
		paginate : false,
		dom : 'Bfrtip',
		buttons : [ {
			extend : "excel",
			className : "btn btn-sm  btn-outline-info",
			exportOptions : {
				columns : ':not(.cus-not-export)'
			}
		}, {
			extend : "csv",
			className : "btn btn-sm btn-outline-info",
			exportOptions : {
				columns : ':not(.cus-not-export)'
			}
		} ],
		bInfo : false,
	});

}

function getStudentStudentPresents(_this) {
	console.log("getStudentStudentPresents->fired");
	var id = $(_this).data("student-id");

	console.log("studentId=", id);

	$.ajax({
		url : $$ContextURL + "/studentPresents/student/" + id,
		type : 'GET',
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

function getAddClassGroupStudentPresent(_this) {
	console.log("getAddClassGroupTable->fired");
	var id = 2;
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
		failure : function(errMsg) {
			alert(errMsg);
		}
	});

}

function deleteLessonTime(_this) {
	console.log("deleteLessonTime->fired");
	console.log(_this);
	var id = $(_this).data("lesson-time-id");
	console.log("id=", id);
	$.ajax({
		url : $$ContextURL + '/lessonTimes/' + id,
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