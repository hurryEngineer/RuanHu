function editorOnLoad(){
	console.log(localStorage[this.questionID]);
	if(localStorage[this.questionID]!=null && localStorage[this.questionID]!=""){
		this.setMarkdown(localStorage[this.questionID]);
	}
}

function editorOnChange(){
	localStorage[this.questionID] = this.getMarkdown();
}
