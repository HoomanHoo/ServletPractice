<%@page import="bean.MabDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="textSet.jsp"%>
<script src="${project}script.js"></script>

<c:if test="${result eq 1}">
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
</c:if>
<c:if test="${result ne 1}">
	<script type="text/javascript">
	alert(invalidUserError);
	
	</script>
	<meta http-equiv="refresh" content="1; url='loginpage.net'">
</c:if>