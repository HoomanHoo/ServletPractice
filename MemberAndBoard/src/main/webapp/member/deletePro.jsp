<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="textSet.jsp"%>
<script src="${project}script.js"></script>
<c:if test="${result eq 1}">
	<script type="text/javascript">
	//<!--
	alert("회원탈퇴가 완료되었습니다");
	//-->
	</script>
	<meta http-equiv="refresh" content="0; url='loginpage.net'">
</c:if>
<c:if test="${result eq -1}">
	<script type="text/javascript">
	//<!--
	alert("비밀번호가 다릅니다");
	//-->
	</script>
	<meta http-equiv="refresh" content="0; url='deleteform.net'">
</c:if>
	