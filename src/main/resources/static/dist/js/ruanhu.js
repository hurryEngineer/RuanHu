//还未转化为html的带class: pure-markdown
function parseMarkdownToHtmlById(id) {
	$("#" + id).removeClass("pure-markdown");
	editormd.markdownToHTML(id, {
		markdownSourceCode: true,
		emoji: true,
		taskList: true,
		tex: true // 默认不解析
	});
}

function parseAllMarkDown() {
	$(".pure-markdown").each(
		function() {
			parseMarkdownToHtmlById(this.id);
		}
	);
}


//维基条目搜索框的class是 wiki-selection
function initWikiSelection() {
	console.log("init wiki selection");
	$(function() {

		var wikiSelection = $(".wiki-selection").select2({
			tags: false,
			
		});

		wikiSelection.on("select2:selecting",
			function(e) {
				wikiSelection.select2("close");
				//e.params.args.data是一个wiki item
				addWikiSelection(e.params.args.data);
				e.preventDefault();
			});

		wikiSelection.select2({
			ajax: {
				url: "/json/wiki/search",
				dataType: 'json',
				delay: 250,
				data: function(params) {
					return {
						key: params.term, // search term
						page: params.page || 1
					};
				},
				processResults: function(data, params) {
					params.page = params.page || 1;

					return {
						results: data,
						pagination: {
							more: (params.page * 30) < data.length
						}
					};
				},
				cache: true
			},
			language: "zh-CN",
			escapeMarkup: function(markup) {
				return markup;
			},
			minimumInputLength: 1,
			templateResult: formatWikiItem,
		});

	});

}

function formatWikiItem(wikiItem){
	var html = '<i class="fa fa-text-width"></i> <h3 class="wiki-selection-title">$title</h3>';
	return html.replace("\$title",wikiItem.title);
}

function addWikiSelection(wikiItem){
	
	var wikiBox = $(".wiki-box");
	if(wikiBox.css("display") == "none"){
		wikiBox.css("display","");
	}
	
	var html = '<blockquote> \
		<h4><a href="#" >$title</a><h4> \
	    <p>$content</p> \
	</blockquote> ';
	
	html = html.replace("\$title",wikiItem.title);
	html = html.replace("\$content",wikiItem.content);
	
	wikiBox.children(".box-body").append(html);
	
}

//document搜索框的class是 doc-selection
function initDocumentSelection() {
	$(function() {

		var docSelection = $(".doc-selection").select2({
			tags: false
		});

		docSelection.on("select2:selecting",
			function(e) {
				docSelection.select2("close");
				e.preventDefault();
			});

		docSelection.select2({
			ajax: {
				url: "/json/doc/search",
				dataType: 'json',
				delay: 250,
				data: function(params) {
					return {
						key: params.term, 
						page: params.page
					};
				},
				processResults: function(data, params) {
					params.page = params.page || 1;

					return {
						results: data,
						pagination: {
							more: (params.page * 30) < data.length
						}
					};
				},
				cache: true
			},
			escapeMarkup: function(markup) {
				return markup;
			},
			language : "zh-CN",
			minimumInputLength: 1,
			templateResult: formatDocItem
		});

	});

}

function formatDocItem(docItem){

    var html = '<img src="$icon" width=15px height=15px ></img> <h3 class="box-title">$docItem.title</h3>';
	return html.replace("\$icon",docItem.icon).replace("\$title",docItem.title);
	
}
