<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="textSet.jsp"%>
<script src="${project}script.js"></script>
<form method="post" name="deleteForm" action="deletepro.net" onsubmit="return checkPasswd()">
	<table>
		<tr>
			<th>${strInputPw}</th>
		</tr>
		<tr>
			<td><input type="password" name="passwd" width="70px"></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="${btnOk}">
				<input type="button" value="${btnCancel}" onclick="location='mypage.net'">
			</td>
		</tr>
	</table>
</form>