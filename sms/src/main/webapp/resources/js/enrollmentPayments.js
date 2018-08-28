$(document).ready()
{
	// S-DataTable
	var table = $('#enrollment-payment-table').DataTable({
		paginate : false,
		dom : 'Bfrtip',
		buttons : [ {
			extend : "excel",
			className : "btn btn-sm  btn-outline-info",
			footer : true,
			exportOptions : {
				columns : ':not(.cus-not-export)'
			}
		}, {
			extend : "csv",
			className : "btn btn-sm btn-outline-info",
			footer : true,
			exportOptions : {
				columns : ':not(.cus-not-export)'
			}
		}, {
			text : 'print',
			className : "btn btn-sm btn-outline-info",
			action : function() {
				cusPrint();
			}

		} ],
		bInfo : false,
	});
	// E-DataTable

}
function cusPrint() {
	console.log("cusPrint->fired");
	window.print();
}
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

	$.when(cusConfirm()).done(function(result) {
		if (result) {
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