//
//function initSelect(data){
////	selectClass,url,idList,itemBox,itemContainer,itemHtml,selectionItemHtml
//	var selectClass = data.selectClass;
//	var url = data.url;
//	var idList = data.idList;
//	var itemBox = data.itemBox;
//	var itemContainer = data.itemContainer;
//	var itemHtml = data.itemHtml;
//	var selectionItemHtml = data.selectionItemHtml;
//
//
//	$(function() {
//
//		var selection = $("."+selectClass).select2({
//			tags: false,
//		});
//		
//		selection.idList = idList||[];
//		selection.showBox = function(box) {
//			if(box.css("display") == "none") {
//				box.css("display", "");
//			}
//			return box;
//		}
//		
//		selection.addItemSelection = function(item){
//			this.idList.push(item.id);
//			this.showBox(itemBox);
//			var html = itemHtml;
//			html = this.replaceHtml(html,item);
//			itemContainer.append(html);
//		}
//		
//		selection.replaceHtml = function(html,item){
//			for(name in item){
//				html = html.replace("\$"+name,item[name]);
//			}
//			return html;
//		}
//		
//		selection.removeByIdList = function(data, idList) {
//			for(var i = 0; i < data.length; i++) {
//				if($.inArray(data[i].id, idList) != -1) {
//					$.remove(data, data[i]);
//					i -= 1;
//				}
//			}
//		}
//		
//		selection.formatSelection = function(item){
//			var html = selectionItemHtml;
//			return selection.replaceHtml(html,item);
//		}
//
//		selection.on("select2:selecting",
//			function(e) {
//				selection.select2("close");
//				//e.params.args.data是一个wiki item
//				selection.addItemSelection(e.params.args.data);
//				e.preventDefault();
//			});
//
//		selection.select2({
//			ajax: {
//				url: url,
//				dataType: 'json',
//				delay: 250,
//				data: function(params) {
//					return {
//						key: params.term, // search term
//						page: params.page || 1
//					};
//				},
//				processResults: function(data, params) {
//					params.page = params.page || 1;
//					
//					selection.removeByIdList(data,selection.idList);
//					
//					return {
//						results: data,
//						pagination: {
//							more: (params.page * 30) < data.length
//						}
//					};
//				},
//				cache: true
//			},
//			tags: false,
//			language: "zh-CN",
//			escapeMarkup: function(markup) {
//				return markup;
//			},
//			minimumInputLength: 1,
//			templateResult: selection.formatSelection,
//		});
//
//	});
//	
//	return selection;
//}
