<%@page import="bean.MabDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="textSet.jsp"%>
<script src="<%=project%>script.js"></script>
<%
	int result = (Integer)request.getAttribute("result");
	if(result == 1){
		//로그인 상태 검증 성공
%>

<form name="mainPageForm" >
	<table>
		<tr>
			<td>
				<input type="button" value="마이 페이지" onclick="location='mypage.net'">
				<input type="button" value="재고수량관리" onclick="location='stockmanage.net'">
				<input type="button" value="문의사항" onclick="location='qnaboard.net'">
			</td>
		</tr>
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
