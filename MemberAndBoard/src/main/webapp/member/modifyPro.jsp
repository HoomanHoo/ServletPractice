<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ include file="textSet.jsp"%>
<script src="<%=project%>script.js"></script>
<%
	int result = (Integer)request.getAttribute("result");
	if(result == 1){
		//회원정보 변경 성공
		%>
		<script type="text/javascript">
		alert(changeSusseccInfo);
		</script>
		<meta http-equiv="refresh" content="0; url='mypage.net'">
		<%
	}
	else{
		//회원정보 변경 실패
		%>
		<script type="text/javascript">
		alert(changeFailInfo);
		</script>
		<meta http-equiv="refresh" content="0; url='mypage.net'">
		<%
	}
%>