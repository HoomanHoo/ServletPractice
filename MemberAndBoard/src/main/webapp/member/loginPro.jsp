<%@page import="bean.MabDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="textSet.jsp"%>
<script src="<%=project%>script.js"></script>

<%
	int result = (Integer)request.getAttribute("result");
	if(result == 1){
		//id 비번 일치
	%>
		<script type="text/javascript">
		alert(loginSuccessMsg);
		
		</script>
		<meta http-equiv="refresh" content="0; url='mainpage.net'">
	<%
	}
	else{
		//id 비번 불일치
		%>
		<script type="text/javascript">
		alert(missMatchInfo);
		
		</script>
		<meta http-equiv="refresh" content="0; url='loginpage.net'">
		<%
	}
%>