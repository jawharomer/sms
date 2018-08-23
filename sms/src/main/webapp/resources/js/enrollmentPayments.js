function getAddEnrollmentPayment(_this) {
	console.log("getAddEnrollmentPayment->fired");
	var id = $(_this).data("enrollment-id");
	console.log("enrollmentId=" + id);
	$.ajax({
		url : $$ContextURL + "/enrollmentPayments/add/" + id,
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

function deleteEnrollmentPayment(_this) {
	console.log("deleteEnrollmentPayment->fired");
	console.log(_this);
	var id = $(_this).data("enrollment-payment-id");
	console.log("id=", id);
	$.ajax({
		url : $$ContextURL + '/enrollmentPayments/' + id,
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

function editEnrollmentPayment(_this) {
	console.log(_this);
	var id = $(_this).data("enrollment-payment-id");
	console.log("id=", id);
	$.get($$ContextURL + "/enrollmentPayments/edit/" + id, function(response) {
		console.log("response=", response);
		$("#modal-body").html(response);
		$("#modal").modal("show");
	});
}