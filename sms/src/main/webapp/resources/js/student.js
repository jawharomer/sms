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