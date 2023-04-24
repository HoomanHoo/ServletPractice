<%@page import="bean.MabDataBean"%>
<%@page import="bean.MabDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="textSet.jsp"%>
<script src="<%=project%>script.js"></script>

<form method="post" name="confirmIdForm" >
<% 
	int result = (Integer)request.getAttribute("result");
	if(result == 0){
%>
	<table>
		<tr>
			<th>사용 가능한 ID입니다</th>
		</tr>
		<tr>
			<th>
				<input type="hidden" name="confirm" value="1">
				<input type="button" value="<%=btnOk %>" onclick="closingId()">
			</th>
		</tr>
	</table>
<%
	}
	else{
%>
	<table>
		<tr>
			<th>사용할 수 없는 ID입니다</th>
		</tr>
		<tr>
			<th>
				<input type="hidden" name="confirm" value="0">
				<input type="button" value="<%=btnOk %>" onclick="closingId()">
			</th>
		</tr>	
	
	</table>

<% 
	}
%>
</form>