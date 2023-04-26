let nameError = "이름을 입력하세요";
let idError = "ID를 입력하세요";
let passwdError = "패스워드를 입력하세요";
let notEqualPasswd = "패스워드가 다릅니다"
let licenseError = "약사면허번호를 입력하세요";
let telError = "전화번호를 입력하세요";
let emailError = "이메일을 입력하세요";
let idKrError = "아이디는 알파벳과 숫자로 조합해야 합니다";
let passwdKrError = "비밀번호는 알파벳과 숫자로 조합해야 합니다"
let emailCheckError = "이메일 서비스를 선택해주세요";
let emailFullInputError = "이메일은 xxxx@xxx.xxx의 형식으로 입력하세요";
let emailChooseError = "이메일의 @ 앞까지만 입력하세요"
let confirmError = "중복확인을 해주세요";
let invalidUserError = "회원만 이용할 수 있습니다";
let loginSuccessMsg = "로그인 되었습니다";
let missMatchInfo = "아이디 비밀번호가 다릅니다";
let changeSuccessInfo = "회원정보 변경이 성공하였습니다";
let changeFailInfo = "회원정보 변겅이 실패했습니다\n잠시후 다시 시도하세요";
let logoutAlert = "로그아웃 되었습니다";


function back(){
	history.back();
}

function checkedId(){
	registForm.checkId.value = 1;
	console.log("checked");
}

function checkedLicense(){
	registForm.checkLicense.value = 1;
	console.log("checked");
}

function checkPasswd(){
	if(!deleteForm.passwd.value){
		alert(passwdError);
		return false;
	}
}

function closingId(){
	if(confirmIdForm.confirm.value == "1"){
		opener.checkedId();
		window.open('','_self').close();
	}
	else{
		window.open('','_self').close();
	}
}
function closingLicense(){
	if(confirmLiceForm.confirmLic.value == "1"){
		opener.checkedLicense();
		window.open('','_self').close();
	}
	else{
		window.open('','_self').close();
	}
}

function loginCheck(){
	if(!loginForm.id.value){
		alert(idError);
		loginForm.id.focus();
		return false;
	}
	else if(!loginForm.passwd.value){
		alert(passwdError);
		loginForm.passwd.focus();
		return false;
	}
}

function infoCheck(){
	
	var idValue = registForm.id.value;
	var idSearch = idValue.search(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/);
	var passwdValue = registForm.passwd.value;
	var passwdSearch = passwdValue.search(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/);
	
	if (idSearch != -1){
		alert(idKrError);
		registForm.id.focus();
		return false;
	}
	if(passwdSearch != -1){
		alert(passwdKrError);
		registForm.passwd.focus();
		return false;
	}
	if(!registForm.name.value){
		alert(nameError);
		registForm.name.focus();
		return false;
	}
	
	if(!registForm.id.value){
		alert(idError);
		registForm.id.focus();
		return false;
	}
	else if(!registForm.passwd.value){
		alert(passwdError);
		registForm.passwd.focus();
		return false;
	}
	else if(registForm.passwd.value != registForm.repasswd.value){
		alert(notEqualPasswd);
		registForm.passwd.focus();
		return false;
	}
	else if(!registForm.license.value){
		alert(licenseError);
		registForm.license.focus();
		return false;
	}
	else if(!registForm.tel1.value || !registForm.tel2.value || !registForm.tel3.value){
		alert(telError);
		registForm.tel1.focus();
		return false;
	}
	else if(!registForm.email1.value){
		alert(emailError);
		registForm.email1.focus();
		return false;
	}
	else if(registForm.checkId.value != 1){
		alert(confirmError);
		return false;
	}
	else if(registForm.checkLicense.value != 1){
		alert(confirmError);
		return false;
	}
	else if(registForm.email2.value == -1){
		if(registForm.email1.value){
			console.log("emailInputError");
			alert(emailCheckError);
			registForm.email1.focus();
			return false;
		}
	}
	else if(registForm.email2.value != -1){
		if(registForm.email2.value == 0 && registForm.email1.value.indexOf("@") == -1){
			console.log("emailInputError");
			alert(emailFullInputError);
			registForm.email1.focus();
			return false;
		}
		else if(registForm.email2.value != 0 && registForm.email1.value.indexOf("@") != -1){
			console.log("emailInputError");
			alert(emailChooseError);
			return false;
		}
	}
}

function modifyCheck(){
	var passwdValue = myInfo.passwd.value;
	var passwdSearch = passwdValue.search(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/);
	
	if(passwdSearch != -1){
		alert(passwdKrError);
		myInfo.passwd.focus();
		return false;
	}
	else if(!myInfo.passwd.value){
		alert(passwdError);
		myInfo.passwd.focus();
		
		return false;
	}
	else if(myInfo.passwd.value != myInfo.repasswd.value){
		alert(notEqualPasswd);
		myInfo.passwd.focus();
		return false;
	}
	else if(!myInfo.tel1.value || !myInfo.tel2.value || !myInfo.tel3.value){
		alert(telError);
		if(!myInfo.tel1.value){
			myInfo.tel1.focus();
		}
		else if(!myInfo.tel2.value){
			myInfo.tel2.focus();
		}
		else if(!myInfo.tel3.value){
			myInfo.tel3.focus();
		}
		return false;
	}
	else if(!myInfo.email1.value){
		alert(emailError);
		myInfo.email1.focus();
		return false;
	}
	else if(myInfo.email2.value == "-1"){
		console.log("modifying");
		console.log("emailInputError");
		alert(emailCheckError);
		myInfo.email1.focus();
		return false;
	
	}
	else if(myInfo.email2.value != "-1"){
		if(myInfo.email2.value == 0 && myInfo.email1.value.indexOf("@") == -1){
			console.log("emailInputError");
			alert(emailFullInputError);
			myInfo.email1.focus();
			return false;
		}
		else if(myInfo.email2.value != "0" && myInfo.email1.value.indexOf("@") != -1){
			console.log("emailInputError");
			alert(emailChooseError);
			return false;
		}
	}
	
}


function multiCheck(){
	if(!registForm.id.value){
		alert(idError);
		registForm.id.focus();
		return false;
	}
	else{
		url="confirmid.net?id=" + registForm.id.value; //get 방식으로 데이터를 보냄 (페이지?파라미터 이름=파라미터)
		open(url, "confirm", "scrollbar=no, statusbar=no, titlebar=no, menubar=no, width=400px, height=250px");
	}
}

function multiLicenseCheck(){
	if(!registForm.license.value){
		alert(licenseError);
		registForm.license.focus();
		return false;
	}
	else{
		url="confirmlicense.net?license=" + registForm.license.value; //get 방식으로 데이터를 보냄 (페이지?파라미터 이름=파라미터)
		open(url, "confirmlicense", "scrollbar=no, statusbar=no, titlebar=no, menubar=no, width=400px, height=250px");
	}
}
