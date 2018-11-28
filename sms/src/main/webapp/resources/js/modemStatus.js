function getAddingBalance() {
	console.log("getAddingBalance->fired");

	$.ajax({
		type : "GET",
		url : $$ContextURL + "/messages/balance/add",
		contentType : "application/json",
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

function deleteExpense(id) {
	console.log("deleteExpense->fired");
	console.log("expenseId=" + id)
	$.when(cusConfirm()).done(function() {

		$.ajax({
			type : "POST",
			url : $$ContextURL + "/expenses/delete/" + id,
			contentType : "application/json",
			success : function(response) {
				$("#modal-body").html(response);
				$("#modal").modal("show");
			},
			error : function(response) {
				$("#modal-body").html(response.responseText);
				$("#modal").modal("show");
			}
		});

	});

}
