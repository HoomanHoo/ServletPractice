<%@page import="bean.MabDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="textSet.jsp"%>
<script src="${project}script.js"></script>

<c:if test="${result eq 1}">
	<script type="text/javascript">
	//<!--
	alert("회원가입에 성공하였습니다");
	-->
	</script>
	<meta http-equiv="refresh" content="0; url='loginpage.net'">
</c:if>
<c:if test="${result ne 1}">
	<script type="text/javascript">
	//<!--
	alert("회원가입에 실패하였습니다\n 잠시 후 다시 시도해주세요");
	-->
	</script>
	<meta http-equiv="refresh" content="0; url='register.net'">
</c:if>