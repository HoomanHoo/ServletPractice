<%@page import="bean.MabDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="textSet.jsp"%>
<script src="${project}script.js"></script>
<jsp:include page="/member/pageTop.jsp"/>


<form name="mainPageForm" >
	<table style="width:60%; margin: auto;">
		<tr>
			<td>
				<input type="button" value="마이 페이지" onclick="location='mypage.net'">
				<input type="button" value="재고수량관리" onclick="location='stockmanage.net'">
				<input type="button" value="문의사항" onclick="location='boardlist.net'">
			</td>
		</tr>
	</table>
</form>