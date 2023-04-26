<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="textSet.jsp"%>
<script src="${project}script.js"></script>


<form name="myInfo" method="post" action="modifyform.net" >
	<table>
		<tr>
			<th>${strId}</th>
			<td><input type="text" value="${id}" readonly></td>
		</tr>
		<tr>
			<th>${strPasswd}</th>
			<td><input type="password" value="${passwd}" readonly></td>
		</tr>
		<tr>
			<th>${strName}</th>
			<td><input type="text" value="${name}" readonly></td>
		</tr>
		<tr>
			<th>${strLicense}</th>
			<td><input type="text" value="${license}" readonly></td>
		</tr>
		<tr>
			<th>${strTel}</th>
			<td>
				<input type="text" value="${tel1}" style="width:30px" readonly>
				- <input type="text" value="${tel2}" style="width:40px" readonly>
				- <input type="text" value="${tel3}" style="width:40px" readonly>
			</td>
		</tr>
		<tr>
			<th>${strEmail}</th>
			<td>
				<input type="text" value="${email1}" readonly>
				@ <input type="text" value="${email2}" readonly>
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="submit" value="${btnModify}" >
				<input type="button" value="${btnDelete}" onclick="location='deleteform.net'">
				<input type="button" value="${btnBack}" onclick="location='mainpage.net'">
			</th>
		</tr>
	</table>
</form>


