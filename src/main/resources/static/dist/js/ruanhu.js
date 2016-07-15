//还未转化为html的带class: pure-markdown
function parseMarkdownToHtmlById(id) {
	$("#"+id).removeClass("pure-markdown");
	editormd.markdownToHTML(id, {
		markdownSourceCode : true,
		emoji: true,
		taskList: true,
		tex: true // 默认不解析
	});
}

function parseAllMarkDown(){
	$(".pure-markdown").each(
		function(){
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