<%@page import="bean.MabDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="textSet.jsp"%>
<script src="${project}script.js"></script>

<c:if test="${result eq 1}">
	<script type="text/javascript">
	alert(loginSuccessMsg);
	
	</script>
	<meta http-equiv="refresh" content="0; url='mainpage.net'">
</c:if>

<c:if test="${result ne 1}">
	<script type="text/javascript">
	alert(missMatchInfo);
	
	</script>
	<meta http-equiv="refresh" content="0; url='loginpage.net'">
</c:if>