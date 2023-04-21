<%@page import="bean.MabDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="textSet.jsp"%>
<script src="script.js"></script>
<%
	String license = request.getParameter("license");
	
	MabDBBean dao = MabDBBean.getInstance();
	int result = dao.checkMultipleLicence(license);
%>
<form method="post" name="confirmLiceForm" >
<% 
	if(result == -1){
%>
	<table>
		<tr>
			<th>면허번호가 확인되었습니다</th>
		</tr>
		<tr>
			<th>
				<input type="hidden" name="confirm" value="1">
				<input type="button" value="<%=btnOk %>" onclick="closingLicense()">
			</th>
		</tr>
	</table>
<%
	}
	else{
%>
	<table>
		<tr>
			<th>유효하지 않거나 이미 등록된 면허번호 입니다</th>
		</tr>
		<tr>
			<th>
				<input type="hidden" name="confirm" value="0">
				<input type="button" value="<%=btnOk %>" onclick="closingLicense()">
			</th>
		</tr>	
	
	</table>

<% 
	}
%>
</form>