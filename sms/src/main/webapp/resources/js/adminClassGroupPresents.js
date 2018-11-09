function deleteClassGroupPresent(id, date) {
	console.log("deleteClassGroupPresent->fired");

	console.log("id=", id);
	console.log("date=", date);

	$.when(cusConfirm()).done(
			function(result) {
				if (result) {
					$.ajax({
						url : $$ContextURL
								+ '/studentPresents/delete/classGroup/' + id
								+ "/" + date,
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