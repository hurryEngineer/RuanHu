$.extend({
	stdPost : function(url, args) {
		submitStdForm(url,args,'post');
	}
});

$.extend({
	stdGet : function(url, args) {
		submitStdForm(url,args,'get');
	}
});

function submitStdForm(url, args, type) {
	var form = $("<form method='"+type+"'></form>"), input;
	form.attr({
		"action" : url
	});
	$.each(args, function(key, value) {
		input = $("<input type='hidden'>");
		input.attr({
			"name" : key
		});
		input.val(value);
		form.append(input);
	});
	form.submit();
}