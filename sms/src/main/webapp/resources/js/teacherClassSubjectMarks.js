function getAddStudentSubjectMark(_this) {
	console.log("getAddStudentSubjectMark->fired");
	var studentId = $(_this).data("student-id");
	var classSubjectId = $(_this).data("class-subject-id");
	var classMarkId = $(_this).data("class-mark-id");

	console.log("studentId=", studentId);
	console.log("classSubjectId=", classSubjectId);
	console.log("classMarkId=", classMarkId);

	$.ajax({
		type : "GET",
		url : $$ContextURL + "/studentSubjectMarks/add",
		data : {
			studentId : studentId,
			classSubjectId : classSubjectId,
			classMarkId : classMarkId
		},
		contentType : "application/json",
		success : function(response) {
			console.log("response=", response);
			$("#modal-body").html(response);
			$("#modal").modal("show");
		},
		failure : function(errMsg) {
			alert(errMsg);
		}
	});
}

function getEditStudentSubjectMark(_this) {
	console.log("getEditStudentSubjectMark->fired");
	var studentSubjectMarkId = $(_this).data("student-subject-mark-id");
	console.log("studentSubjectMarkId=", studentSubjectMarkId);
	$.ajax({
		type : "GET",
		url : $$ContextURL + "/studentSubjectMarks/edit/"
				+ studentSubjectMarkId,
		contentType : "application/json",
		success : function(response) {
			console.log("response=", response);
			$("#modal-body").html(response);
			$("#modal").modal("show");
		},
		failure : function(errMsg) {
			alert(errMsg);
		}
	});
}
