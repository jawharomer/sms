tinymce
		.init({
			selector : 'textarea',
			height : 200,
			plugins : [
					'table',
					'advlist autolink lists link image charmap print preview anchor textcolor',
					'searchreplace visualblocks code fullscreen',
					'insertdatetime media table contextmenu paste code help wordcount' ],
			toolbar : 'table|insert | undo redo |  formatselect | bold italic backcolor  | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | removeformat | help',
			content_css : $$ContextURL + "/resources/css/cusTinymce.css",
			directionality : 'rtl',
			setup : function(ed) {
				ed.on('init', function() {
					this.getDoc().body.style.fontSize = '20px';
					this.getDoc().body.style.fontFamily = 'Noto Kufi Arabic';
				});
			}
		});

function updateWebSite(event) {
	event.preventDefault();
	tinymce.triggerSave();
	console.log("updateWebSite->fired");
	var data = $("#update-web-site-form").serializeJSON();
	console.log("data=", data);
	$.ajax({
		type : "POST",
		url : $$ContextURL + "/webSite/update",
		data : JSON.stringify(data),
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

function deleteCarouselFile(id) {
	console.log("deleteCarouselFile->fired");
	console.log("id=", id);

	$.when(cusConfirm()).done(function(result) {
		if (result) {
			$.ajax({
				url : $$ContextURL + '/webSite/files/delete/coursel/' + id,
				type : 'POST',
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
	})

}

function deleteAlbumFile(id) {
	console.log("deleteAlbumFile->fired");
	console.log("id=", id);

	$.when(cusConfirm()).done(function(result) {
		if (result) {
			$.ajax({
				url : $$ContextURL + '/webSite/files/delete/album/' + id,
				type : 'POST',
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
	})

}