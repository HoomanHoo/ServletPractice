<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="textSet.jsp"%>
<script src="${project}boardScript.js"></script>
<form name="contentForm">
	<table>
		<tr>
			<td><input type="text" value="${dto.postSubject}" readonly></td>
		</tr>
		<tr>
			<td><textarea readonly>${dto.postContent}</textarea></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="${btnModify }">
				<input type="button" value="${btnDelete }">
				<input type="button" value="${btnList }">
			</td>
		</tr>
	</table>
</form>
<form>
	<table>
		<c:forEach var="reDto" items="${reDtos }">
			<tr>
				<td>
					<input type="text" value="${reDto.reContent}" readonly>
					<input type="button" value="${btnDelete }">
				</td>
			</tr>
		</c:forEach>
	</table>
</form>
<form name="replyForm" method="post" action="replyPro.net">
<input type="hidden" name="postNum" value="${param.postNum }">
	<table>
		<tr>
			<td>
				<input type="text" name="reply">
				<input type="submit" value="${btnWrite }">
			</td>
		</tr>
	</table>
</form>

<form>
	<table>
		<c:forEach var="dto" items="${dtos}">
			<tr>
				<td><c:out value="${dto.postNum}"/></td>
				<td><a href="content.net?postNum=${dto.postNum}"><c:out value="${dto.postSubject}"/></a></td>
				<td><c:out value="${dto.postId}"/></td>
				<td><c:out value="${dto.postWriteDate}"/></td>
				<td><c:out value="${dto.postReadCount}"/></td>
			</tr>
		</c:forEach>	
	</table>
</form>
