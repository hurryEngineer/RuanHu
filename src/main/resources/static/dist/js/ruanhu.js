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

function voteAnswer(obj) {
	console.log(obj);
	//	console.log(obj.getAttribute("answerid"));
}

function voteQuestion(obj) {
	console.log(obj);
	//	console.log(obj.getAttribute("answerid"));
}

//维基条目搜索框的class是 wiki-selection
function initWikiSelection() {
	$(function() {

		var wikiSelection = $(".wiki-selection").select2({
			tags: false
		});

		wikiSelection.on("select2:selecting",
			function(e) {
				wikiSelection.select2("close");
				e.preventDefault();
			});

		wikiSelection.select2({
			ajax: {
				url: "https://api.github.com/search/repositories",
				dataType: 'json',
				delay: 250,
				data: function(params) {
					return {
						q: params.term, // search term
						page: params.page
					};
				},
				processResults: function(data, params) {
					// parse the results into the format expected by Select2
					// since we are using custom formatting functions we do not need to
					// alter the remote JSON data, except to indicate that infinite
					// scrolling can be used
					params.page = params.page || 1;

					return {
						results: data.items,
						pagination: {
							more: (params.page * 30) < data.total_count
						}
					};
				},
				cache: true
			},
			escapeMarkup: function(markup) {
				return markup;
			},
			minimumInputLength: 1,
			templateResult: formatWikiItem,
			templateSelection: formatWikiSelection
		});

	});

}

function formatWikiItem(wikiItem){
	<blockquote>
        <p>Spring是一个开源框架，Spring是一个轻量级的Java 开发框架，由Rod Johnson创建。简单来说，Spring是一个分层的JavaSE/EEfull-stack(一站式) 轻量级开源框架。</p>
        <small>来自 wiki条目<cite title="Source Title"><a href="#" >Spring</a></cite></small>
    </blockquote>
}

function formatWikiSelection(){
	
}
