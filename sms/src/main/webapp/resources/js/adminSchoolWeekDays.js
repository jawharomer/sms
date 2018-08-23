function getAddSchoolWeekDay() {
	console.log("getAddSchoolWeekDay->fired");
	$.get($$ContextURL + "/schoolWeekDays/add", function(response) {
		console.log("response=", response);
		$("#modal").modal("show");
		$("#modal-body").html(response);
	});

}

function deleteSchoolWeekDay(_this) {
	console.log("deleteSchoolWeekDay->fired");
	console.log(_this);
	var id = $(_this).data("school-week-day-id");
	console.log("id=", id);
	$.ajax({
		url : $$ContextURL + '/schoolWeekDays/' + id,
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

function editSchoolWeekDay(_this) {
	console.log(_this);
	var id = $(_this).data("school-week-day-id");
	console.log("id=", id);
	$.get($$ContextURL + "/schoolWeekDays/edit/" + id, function(response) {
		console.log("response=", response);
		$("#modal-body").html(response);
		$("#modal").modal("show");
	});

}