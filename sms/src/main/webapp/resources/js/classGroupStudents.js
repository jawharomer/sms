$(document).ready()
{
	// S-DataTable
	var table = $('#student-table').DataTable({

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