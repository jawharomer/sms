$(document).ready()
{
	// S-DataTable
	$('#enrollment-table tfoot th:not(.cus-not-search)')
			.each(
					function() {
						var title = $(this).text();
						$(this)
								.html(
										'<input class="form-control fomt-control-sm cus-inline" type="text" />');
					});
	var table = $('#enrollment-table').DataTable({
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

	// Apply the search
	table.columns().every(function() {
		var that = this;
		console.log("that=", that);
		console.log("that.search()=", that.search());

		$('input', this.footer()).on('keyup change', function() {
			if (that.search() !== this.value) {
				that.search(this.value).draw();
			}
		});
	});
	// E-DataTable

}

function getAddEnrollment() {
	console.log("getAddEnrollment->fired");
	$.get($$ContextURL + "/enrollments/add", function(response) {
		console.log("response=", response);
		$("#modal").modal("show");
		$("#modal-body").html(response);
	});

}

function deleteEnrollment(_this) {
	console.log("deleteEnrollment->fired");
	console.log(_this);
	var id = $(_this).data("enrollment-id");
	console.log("id=", id);

	$.when(cusConfirm()).done(function(result) {
		if (result) {
			$.ajax({
				url : $$ContextURL + '/enrollments/' + id,
				type : 'DELETE',
				success : function(result) {
					console.log(result);
					if (result == "success") {
						location.reload();
					}
				},
				error : function(response) {
					$("#modal-body").html(response.responseText);
					$("#modal").modal("show");
				}
			});
		}
	});

}

function editEnrollment(_this) {
	console.log("editEnrollment->fired");
	console.log(_this);
	var id = $(_this).data("enrollment-id");
	console.log("id=", id);
	$.get($$ContextURL + "/enrollments/edit/" + id, function(result) {
		console.log("result=", result);
		$("#modal-body").html(result);
		$("#modal").modal("show");
	});

}