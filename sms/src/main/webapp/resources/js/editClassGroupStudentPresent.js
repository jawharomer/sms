$(document).ready()
{
	$("#presentDate").datepicker({
		dateFormat : "yy-mm-dd"
	}).datepicker("setDate", new Date());
}
function updateClassGroupStudentPresent(event, _this) {
	console.log("updateClassGroupStudentPresent->fired");
	event.preventDefault();
	var formData = $(_this).serializeJSON().studentPresentDs;
	var data = $.map(formData, function(value, index) {
		return [ value ];
	});
	$.when(cusConfirm()).done(function(result) {
		if (result) {
			$.ajax({
				type : "POST",
				url : $$ContextURL + "/studentPresents/update",
				data : JSON.stringify(data),
				contentType : "application/json",
				success : function(response) {
					console.log("response=", response);
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
