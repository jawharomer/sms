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

		columnDefs : [ {
			orderable : false,
			className : 'select-checkbox',
			targets : 0,
			data : 0
		} ],
		select : {
			style : 'multi'
		},
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

	function getAddingStudentNotificaion() {
		console.log("table=", table);
		var data = table.rows({
			selected : true
		}).data();
		var selectedStudentIds = [];
		for (var i = 0; i < data.length; i++) {
			console.log(data[i][0]);
			selectedStudentIds.push(+data[i][0]);
		}
		console.log(selectedStudentIds);

		if (selectedStudentIds.length != 0) {
			$.ajax({
				url : $$ContextURL + '/admin/students/notificaions/add',
				data : {
					studentIds : selectedStudentIds
				},
				type : 'GET',
				dataType : 'json',
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
		} else {
			$("#modal-body").html("هیچ قوتابیەک دەستینشان نەکراوە");
			$("#modal").modal("show");
		}

	}
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