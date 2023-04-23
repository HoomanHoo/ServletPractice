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
let invalidUserError = "회원만 이용할 수 있습니다";
let loginSuccessMsg = "로그인 되었습니다";
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
	else if(!(registForm.passwd.value === registForm.repasswd.value)){
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
	else if(!confirmId === 1){
		alert(confirmIdError);
		return false;
	}
	else if(!confirmLicense === 1){
		alert(confirmLicenseError);
		return false;
	}
	else if(registForm.email2.value == -1){
		if(registForm.email1.value){
			alert("이메일 서비스를 선택해주세요");
			registForm.email1.focus();
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
		url="confirmid.jsp?id=" + registForm.id.value; //get 방식으로 데이터를 보냄 (페이지?파라미터 이름=파라미터)
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
		url="confirmlicense.jsp?id=" + registForm.license.value; //get 방식으로 데이터를 보냄 (페이지?파라미터 이름=파라미터)
		open(url, "confirmlicense", "scrollbar=no, statusbar=no, titlebar=no, menubar=no, width=400px, height=250px");
	}
}
