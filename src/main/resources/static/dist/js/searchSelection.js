/*
 * data:{
 * 	 idList : [] //初始的已经选择好的ID list,默认为空
 *   itemHtml : 
 *   
 * 
 * }
 * 
 */

function initSelect(selectClass,url,idList,itemBox,itemContainer,itemHtml,selectionItemHtml){
	$(function() {

		var wikiSelection = $("."+selectClass).select2({
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
