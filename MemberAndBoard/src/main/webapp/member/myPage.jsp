<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="textSet.jsp"%>
<script src="${project}script.js"></script>

<c:if test="${result eq 1}">
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
					<input type="text" value="${tel1}" readonly>
					- <input type="text" value="${tel2}" readonly>
					- <input type="text" value="${tel3}" readonly>
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
					<input type="button" value="${btnBack}" onclick="back()">
				</th>
			</tr>
		</table>
</form>
</c:if>
<c:if test="${result ne 1}">
	<script type="text/javascript">
	//<!--
	alert(invalidUserError);
	-->	
	</script>
	<meta http-equiv="refresh" content="1; url='loginpage.net'">
</c:if>

