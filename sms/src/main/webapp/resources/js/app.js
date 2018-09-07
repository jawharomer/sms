var $$ContextURL = "/sms";

$.datepicker.setDefaults({ changeMonth: true,changeYear: true,
	monthNamesShort: [ "1", "2", "3", "4",
        "5", "6", "7", "8", "9",
        "10", "11", "12" ]});

function cusConfirm() {
	var deferred=$.Deferred();
	console.log("cusConfirm->fired");
	$('<div></div>').appendTo('body').html(`
	<p>
	ئایە تۆ دلنیایت ؟
	</p>
	`)
			.dialog({
				title : 'پەنجەرەی دلنیایی',
				zIndex : 10000,
				autoOpen : true,
				width : '300',
				resizable : false,
				buttons : {
					"بەلێ" : function() {
						deferred.resolve(true);
						$(this).dialog("close");
					},
					"نەخێر" : function() {
						$(this).dialog("close");
					}
				},
				close : function(event, ui) {
					$(this).remove();
				}
			});
	return deferred.promise();
}


function cusPF(input){
// custom prevent Eclipse formating ${variable} inside Javascipt code
	return input;
}
