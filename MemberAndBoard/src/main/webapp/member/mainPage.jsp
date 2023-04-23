<%@page import="bean.MabDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="textSet.jsp"%>
<script src="script.js"></script>
<%
	String id = (String)session.getAttribute("id");
	String passwd = (String)session.getAttribute("passwd");
	MabDBBean dao = MabDBBean.getInstance();
	int result = dao.checkLogin(id, passwd);
	
	if(result == 1){
		//로그인 상태 검증 성공
%>

<form name="mainPageForm" >
	<table>
		<tr>
			<td>
				<input type="button" value="마이 페이지" onclick="myPage.jsp">
				<input type="button" value="재고수량관리" onclick="stockManage.jsp">
				<input type="button" value="문의사항" onclick="qnaBoard.jsp">
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
		<meta http-equiv="refresh" content="1; url='loginPage.jsp'">
		<%
		
	}
%>
