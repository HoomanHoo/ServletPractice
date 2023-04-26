<%@page import="bean.MabDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="textSet.jsp"%>
<script src="${project}script.js"></script>

<form method="post" name="confirmLiceForm" >
	<c:if test="${result eq 0}">	
		<table>
			<tr>
				<th>면허번호가 확인되었습니다</th>
			</tr>
			<tr>
				<th>
					<input type="hidden" name="confirmLic" value="1">
					<input type="button" value="${btnOk}" onclick="closingLicense()">
				</th>
			</tr>
		</table>
	</c:if>
	<c:if test="${result eq -1}">
		<table>
			<tr>
				<th>유효하지 않거나 이미 등록된 면허번호 입니다</th>
			</tr>
			<tr>
				<th>
					<input type="hidden" name="confirm" value="0">
					<input type="button" value="${btnOk}" onclick="closingLicense()">
				</th>
			</tr>	
		</table>
	</c:if>
</form>