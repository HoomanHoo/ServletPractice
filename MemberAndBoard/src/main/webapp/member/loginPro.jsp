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
		
	}
%>