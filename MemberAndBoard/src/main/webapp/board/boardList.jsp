<%@page import="java.util.ArrayList"%>
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
		<c:forEach var="dto" items="${dtos}">
			<tr>
			<td><c:out value="${dto.postNum}"/></td>
			<td><c:out value="${dto.postSubject}"/></td>
			<td><c:out value="${dto.postId}"/></td>
			<td><c:out value="${dto.postWriteDate}"/></td>
			<td><c:out value="${dto.postReadCount}"/></td>
			</tr>
		</c:forEach>
		<%
			ArrayList<Integer> arr = new ArrayList<Integer>();
			arr.add(1);
			arr.add(2);
			arr.add(3);
			request.setAttribute("arr", arr);
		%>
		<c:forEach var="value" items="${arr}">
			<tr>
			<td>${value}</td>
			</tr>
		</c:forEach>
	</table>
</form>

