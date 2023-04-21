<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="textSet.jsp"%>
<script src="script.js"></script>

<form method="post" name="loginForm" action="registerPro.jsp" onsubmit="return infoCheck()">
	<table border="1">
		<tr>
			<th colspan="2" align="center"><%=strRegist %></th>
		</tr>
		<tr>
			<th><%=strName %></th>
			<td>
				<input type="text" name="name" maxlength="15" autofocus style="width:80px">
			</td>
		</tr>
		<tr>
			<th><%=strId %></th>
			<td>
				<input type="text" name="id" maxlength="15" style="width:80px">
				<input type="button" name="multipleCheck" value="<%=btnMultiple %>" onclick="multiCheck()">
			</td>
		</tr>
		<tr>
			<th><%=strPasswd %></th>
			<td>
				<input type="password" name="passwd" maxlength="30" style="width:100px" >
				<input type="password" name="repasswd" maxlength="30" style="width:100px">
			</td>
		</tr>
		<tr>
			<th><%=strLicence %></th>
			<td>
				<input type="text" name="licence" maxlength="15" style="width:80px">
				<input type="button" name="multipleIdentifyCheck" value="<%=btnMultiple %>" onclick="multiIdentifyCheck()">
			</td>
		</tr>
		<tr>
			<th><%=strTel %></th>
			<td align="center">
				<input type="text" name="tel1" maxlength="3" style="width:30px">
				- <input type="text" name="tel2" maxlength="4" style="width:40px">
				- <input type="text" name="tel3" maxlength="4" style="width:40px">
			</td>
		</tr>
		<tr>
			<th><%=strEmail %></th>
			<td>
				<input type="text" name="email1" maxlength="30" style="width:100px">
				@ <select name="email2">
					<option value="-1">선택</option>
					<option value="0">직접 입력 </option>	
					<option value="1">다음 </option>
					<option value="2">네이버 </option>
					<option value="3">구글 </option>
					<option value="4">네이트 </option>
				</select>
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="submit" value="<%=btnRegist %>">
				<input type="reset" value="<%=btnCancel %>">
			</th>
		</tr>
	</table>

</form>