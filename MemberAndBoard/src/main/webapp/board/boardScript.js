

function back(){
	history.back();
}


function checkContent(){
	if(!writeForm.inputSub.value){
		alert("제목을 입력하세요");
		return false;
	}
	else if(!writeForm.inputContent.value){
		alert("내용을 입력하세요");
		return false;
	}
}
