<%@page import="bean.MabDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="textSet.jsp"%>
<script src="script.js"></script>
<%	
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String license = request.getParameter("license");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String email1 = request.getParameter("email1");
	int email2 = Integer.parseInt(request.getParameter("email2"));
	String email = null;
	String tel = tel1 + "-" + tel2 + "-" + tel3;
	
	if(email2 == 0){
		email = email1;
	}
	else if(email2 == 1){
		email = email1 + "@daum.net";
	}
	else if(email2 == 2){
		email = email1 + "@naver.com";
	}
	else if(email2 == 3){
		email = email1 + "@gmail.com";
	}
	else if(email2 == 4){
		email = email1 + "@nate.com";
	}
	
	MabDBBean dao = MabDBBean.getInstance();
	int result = 0;
	
	result = dao.insertInfo(id, passwd, name, tel, email, license);
	if(result == 1){
	%>
	<script type="text/javascript">
	//<!--
	alert("회원가입에 성공하였습니다");
	-->
	</script>
	<% 
	response.sendRedirect("mainPage.jsp");
	}
	else{
	%>
	<script type="text/javascript">
	//<!--
	alert("회원가입에 실패하였습니다\n 잠시 후 다시 시도해주세요");
	-->
	</script>
	<%
	response.sendRedirect("register.jsp");
	
	}
	%>