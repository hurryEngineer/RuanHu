function editorOnLoad(){
	if(localStorage[this.questionID]!=null){
		this.setMarkdown(localStorage[this.questionID]);
	}
}

function editorOnChange(){
	localStorage[this.questionID] = this.getMarkdown();
}
