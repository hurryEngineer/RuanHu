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
function parseMarkdownToHtmlByWapper(wapper) {
	wapper.removeClass("pure-markdown");
	editormd.markdownToHTML(wapper, {
		markdownSourceCode: true,
		emoji: true,
		taskList: true,
		tex: true // 默认不解析
	});
}

function parseAllMarkDown() {
	$(".pure-markdown").each(
		function() {
			parseMarkdownToHtmlByWapper($(this));
		}
	);
}

function replaceHtml(html,item){
	for(name in item){
		html = html.replace("\$"+name,item[name]);
	}
	return html;
}

function initSelect(data){
//	selectClass,url,idList,itemBox,itemContainer,itemHtml,selectionItemHtml
	var selectClass = data.selectClass;
	var url = data.url;
	var idList = data.idList;
	var itemBox = data.itemBox;
	var itemContainer = data.itemContainer;
	var itemHtml = data.itemHtml;
	var selectionItemHtml = data.selectionItemHtml;
	var selection = new Object();

	$(function() {
		
		$.extend(selection,
			$("."+selectClass).select2({
				tags: false,
			})
		);
		
		selection.idList = idList||[];
		selection.showBox = function(box) {
			if(box.css("display") == "none") {
				box.css("display", "");
			}
			return box;
		}
		
		selection.addItemSelection = function(item){
			this.idList.push(item.id);
			this.showBox(itemBox);
			var html = itemHtml;
			html = this.replaceHtml(html,item);
			itemContainer.append(html);
		}
		
		selection.replaceHtml = replaceHtml;
		
		selection.removeByIdList = function(data, idList) {
			for(var i = 0; i < data.length; i++) {
				if($.inArray(data[i].id, idList) != -1) {
					$.remove(data, data[i]);
					i -= 1;
				}
			}
		}
		
		selection.formatSelection = function(item){
			if(item.loading){
        	    return item.text;
            }
			var html = selectionItemHtml;
			return selection.replaceHtml(html,item);
		}

		selection.on("select2:selecting",
			function(e) {
				selection.select2("close");
				//e.params.args.data是一个wiki item
				selection.addItemSelection(e.params.args.data);
				e.preventDefault();
			});

		selection.select2({
			ajax: {
				url: url,
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
					
					selection.removeByIdList(data,selection.idList);
					
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
			templateResult: selection.formatSelection,
		});

	});
	
	return selection;
}

