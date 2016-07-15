function praseMarkdownToHtml(id) {
	editormd.markdownToHTML(id, {
		emoji: true,
		taskList: true,
		tex: true, // 默认不解析
	});
}

function voteAnswer(obj) {
	console.log(obj);
//	console.log(obj.getAttribute("answerid"));
}

function voteQuestion(obj) {
	console.log(obj);
//	console.log(obj.getAttribute("answerid"));
}