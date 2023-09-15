function check(){
		var writer = document.getElementById("writer");
		var passwd = document.getElementById("passwd");
		var subject = document.getElementById("subject");
		var content = document.getElementById("content");
		
		if(writer.value == ""){
			alert("작성자명을 입력 하세요.");
			writer.focus();
			return false;
		}
		if(passwd.value == ""){
			alert("비밀번호를 입력 하세요.");
			passwd.focus();
			return false;
		}
		if(passwd.value.length < 2 || passwd.value.length > 8){
			alert("비밀번호는 2~8자 이내로 입력 하세요.");
			passwd.value = "";		// 입력한 비번 삭제
			passwd.focus();
			return false;
		}
		if(subject.value == ""){
			alert("제목을 입력 하세요.");
			subject.focus();
			return false;
		}
		if(subject.value.length > 50){
			alert("제목을 50자 이내로 입력 하세요.");
			subject.value = "";		// 입력한 제목 삭제
			subject.focus();
			return false;
		}
		if(content.value == ""){
			alert("내용을 입력 하세요.");
			content.focus();
			return false;			
		}
		if(content.value.length > 200){
			alert("내용을 200자 이내로 입력 하세요.");
			content.focus();
			return false;
		}		
}