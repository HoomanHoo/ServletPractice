<%@page import="bean.MabDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="textSet.jsp"%>
<script src="script.js"></script>

<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	MabDBBean dao = MabDBBean.getInstance();
	int result = dao.checkLogin(id, passwd);
	
	if(result == 1){
		//id 비번 일치
		session.setAttribute("id", id);
		session.setAttribute("passwd", passwd);
	%>
		<script type="text/javascript">
		alert(loginSuccessMsg);
		
		</script>
		<meta http-equiv="refresh" content="0; url='mainPage.jsp'">
	<%

	}
	else{
		//id 비번 불일치
		%>
		<script type="text/javascript">
		alert("아이디 비밀번호가 다릅니다");
		
		</script>
		<meta http-equiv="refresh" content="0; url='loginPage.jsp'">
		<%
	
	}
%>