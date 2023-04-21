let nameError = "이름을 입력하세요";
let idError = "ID를 입력하세요";
let passwdError = "패스워드를 입력하세요";
let notEqualPasswd = "패스워드가 다릅니다"
let licenseError = "약사면허번호를 입력하세요";
let telError = "전화번호를 입력하세요";
let emailError = "이메일을 입력하세요";
let idKrError = "아이디는 알파벳과 숫자로 조합해야 합니다";
let passwdKrError = "비밀번호는 알파벳과 숫자로 조합해야 합니다"
let confirmError = "중복확인을 해주세요";
var confirmId = 0;
var confirmLicense = 0;

function closingId(){
	if(confirmIdForm.confirm.value === 1){
		confirmId = 1;
		window.open('','_self').close();
	}
	else{
		confirmId = 0;
		window.open('','_self').close();
	}
}
function closingLicense(){
	if(confirmLiceForm.confirm.value === 1){
		confirmLicense = 1;
		window.open('','_self').close();
	}
	else{
		confirmLicense = 0;
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
	
	var idValue = loginForm.id.value;
	var idSearch = idValue.search(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/);
	var passwdValue = loginForm.passwd.value;
	var passwdSearch = passwdValue.search(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/);
	
	if (idSearch != -1){
		alert(idKrError);
		loginForm.id.focus();
		return false;
	}
	if(passwdSearch != -1){
		alert(passwdKrError);
		loginForm.passwd.focus();
		return false;
	}
	if(!loginForm.name.value){
		alert(nameError);
		loginForm.name.focus();
		return false;
	}
	
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
	else if(!(loginForm.passwd.value === loginForm.repasswd.value)){
		alert(notEqualPasswd);
		loginForm.passwd.focus();
		return false;
	}
	else if(!loginForm.license.value){
		alert(licenseError);
		loginForm.license.focus();
		return false;
	}
	else if(!loginForm.tel1.value || !loginForm.tel2.value || !loginForm.tel3.value){
		alert(telError);
		loginForm.tel1.focus();
		return false;
	}
	else if(!loginForm.email1.value){
		alert(emailError);
		loginForm.email1.focus();
		return false;
	}
	else if(!confirmId === 1){
		alert(confirmIdError);
		return false;
	}
	else if(!confirmLicense === 1){
		alert(confirmLicenseError);
		return false;
	}
	else if(loginForm.email2.value == -1){
		if(loginForm.email1.value){
			alert("이메일 서비스를 선택해주세요");
			loginForm.email1.focus();
			return false;
		}
	}
}

function multiCheck(){
	if(!loginForm.id.value){
		alert(idError);
		loginForm.id.focus();
		return false;
	}
	else{
		url="confirmid.jsp?id=" + loginForm.id.value; //get 방식으로 데이터를 보냄 (페이지?파라미터 이름=파라미터)
		open(url, "confirm", "scrollbar=no, statusbar=no, titlebar=no, menubar=no, width=400px, height=250px");
	}
}

function multiLicenseCheck(){
	if(!loginForm.license.value){
		alert(licenseError);
		loginForm.license.focus();
		return false;
	}
	else{
		url="confirmlicense.jsp?id=" + loginForm.id.value; //get 방식으로 데이터를 보냄 (페이지?파라미터 이름=파라미터)
		open(url, "confirmlicense", "scrollbar=no, statusbar=no, titlebar=no, menubar=no, width=400px, height=250px");
	}
}
