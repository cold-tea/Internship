$(".alert-dismissible").fadeTo(2000, 500).slideUp(500, function(){
    $(".alert-dismissible").alert('close');
});

$('#addInstallment').on('shown.bs.modal', function (event) {
	var $invoker = $(event.relatedTarget)
	var sid = $invoker.attr("sid");
	var cid = $invoker.attr("cid");
	var $hiddenSid = $('#hidden_sid');
	var $hiddenCid = $('#hidden_cid');
	$hiddenSid.attr("value", sid);
	$hiddenCid.attr("value", cid);
	console.log($hiddenSid.attr("value"));
	console.log($hiddenCid.attr("value"));
})


