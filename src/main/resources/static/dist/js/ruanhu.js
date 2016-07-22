$.extend({
	remove : function(list, item) {
		var index = jQuery.inArray(item,list);
		if(index!=-1){
			list.splice(index,1);
		}
	}
});

$.extend({
	removeList : function(originList, otherList) {
		for(var i=0;i<otherList.length;i++){
			$.remove(originList,otherList[i]);
		}
	}
});

function removeByIdList(data,idList){
	for(var i=0;i<data.length;i++){
		if($.inArray(data[i].id,idList)!=-1){
			$.remove(data,data[i]);
			i-=1;
		}
	}
}

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

//初始化wiki和doc的选择框
function initSelection(){
	initWikiSelection();
	initDocumentSelection();
}

var wikiIdList=[];
var docIdList=[];

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
					
					removeByIdList(data,wikiIdList);
					
					return {
						results: data,
						pagination: {
							more: (params.page * 30) < data.length
						}
					};
				},
				cache: true
			},
			tags: false,
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
	var html = '<i class="fa fa-text-width"></i> <h3 class="selection-title">$title</h3>';
	return html.replace("\$title",wikiItem.title);
}

function addWikiSelection(wikiItem){
	
	wikiIdList.push(wikiItem.id);
	var wikiBox = showBox("wiki-box");
	
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
				addDocSelection(e.params.args.data);
				e.preventDefault();
			});

		docSelection.select2({
			ajax: {
				url: "/json/doc/search",
				dataType: 'json',
				delay: 250,
				data: function(params) {
					return {
						key: params.term||"", 
						page: params.page||1
					};
				},
				processResults: function(data, params) {
					params.page = params.page || 1;
					removeByIdList(data,docIdList);
					return {
						results: data,
						pagination: {
							more: (params.page * 30) < data.length
						}
					};
				},
				cache: true
			},
			tags: false,
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

    var html = '<img src="$icon" alt="a" width=20px height=20px ></img> <h3 class="selection-title">$title</h3>';
	return html.replace("\$icon",docItem.icon).replace("\$title",docItem.title);
	
}

function addDocSelection(docItem){
	
	docIdList.push(docItem.id);
	
	docBox = showBox("doc-box");
	
	var html = ' <tr> \
	    <td>$title</td> \
	    <td> \
	    	<a href="$url" > \
	    		<span class="badge bg-red"> \
	    			<i class="ion ion-ios-cloud-download-outline"> \
	    			</i> \
	    		</span> \
	    	</a> \
	    </td> \
	</tr> ';
	
	html = html.replace("\$title",docItem.title);
	html = html.replace("\$url",docItem.url);
	
	docBox.children(".box-body").children(".table").children("tbody").append(html);
}

function showBox(classStr){
	var box = $("."+classStr);
	if(box.css("display") == "none"){
		box.css("display","");
	}
	return box;
}
