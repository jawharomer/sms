function getAddingStudentLevel(studentLevelId, studentId, classSubjectId) {
	console.log("getAddingStudentLevel->fired");
	console.log("studentLevelId=" + studentLevelId);
	console.log("studentId=" + studentId);
	console.log("classSubjectId=" + classSubjectId);

	var data = {
		studentId : studentId,
		classSubjectId : classSubjectId
	};
	if (studentLevelId)
		data.studentLevelId = studentLevelId;

	$.ajax({
		url : $$ContextURL + "/studentLevels/add",
		data : data,
		type : 'GET',
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