<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="textSet.jsp"%>
<script src="<%=project%>script.js"></script>
<%
	int result = (Integer)request.getAttribute("result");
	if(result == 1){
		//로그인 정보 유지
%>
<form name="myInfo" method="post" action="modifypro.net">
	<table>
		<tr>
			<th><%=strName %></th>
			<td><input type="text" value=${name } readonly></td>
		</tr>
		<tr>
			<th><%=strId%></th>
			<td><input type="text" value=${id } maxlength="15" style="width:80px" readonly></td>
		</tr>
		<tr>
			<th><%=strPasswd %></th>
			<td><input type="password" name="passwd" maxlength="30" style="width:100px"></td>
			<td><input type="password" name="repasswd" maxlength="30" style="width:100px"></td>
		</tr>
		<tr>
			<th><%=strLicense %></th>
			<td><input type="text" value=${license } maxlength="15" style="width:80px" readonly></td>
		</tr>
		<tr>
			<th><%=strTel %></th>
			<td>
				<input type="text" name="tel1" maxlength="3" style="width:30px">
				- <input type="text" name="tel2" maxlength="4" style="width:40px">
				- <input type="text" name="tel3" maxlength="4" style="width:40px">
			</td>
		</tr>
		<tr>
			<th><%=strEmail %></th>
			<td>
				<input type="text" name="email1" maxlength="30" style="width:100px">
				@ <select name="email2" >
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
				<input type="submit" value="<%=btnModifyApply %>" >
				<input type="reset" value="<%=btnCancel %>" >
				<input type="button" value="<%=btnBack %>" onclick="back()">
	
	</table>

</form>
<%
	}
	else{
		//로그인 상태 검증 실패
		%>
		<script type="text/javascript">
		alert(invalidUserError);
				
		</script>
		<meta http-equiv="refresh" content="1; url='loginpage.net'">
		<%
				
		}
%>
