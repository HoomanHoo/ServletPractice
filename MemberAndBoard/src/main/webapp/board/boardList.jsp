<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="textSet.jsp"%>
<script src="${project}boardScript.js"></script>

<h2>QnA게시판</h2>

<form method="post" name="listForm">
	<table border="1">
		<tr>
			<td><a href="writeform.net">${strWrite}</a>
		<tr>
			<td>${strContentNum}</td>
			<td>${strSubject}</td>
			<td>${strName}</td>
			<td>${strWriteDate}</td>
			<td>${strReadCount}</td>
		</tr>
	</table>
</form>

