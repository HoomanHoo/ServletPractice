<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="textSet.jsp"%>
<script src="${project}boardScript.js"></script>
<form method="post" name="writeForm" action="writepro.net" onsubmit="checkContent()">
<input type="hidden" name="writerName" value="${requestScope.id}">
	<table>
		<tr>
			<td><input type="text" name="inputSub" style="width:520px"></td>
		</tr>
		<tr>
			<td></td>
		</tr>
		<tr>
			<td></td>
		</tr>
		<tr>
			<td>
				<textarea name="inputContent" style="width:520px; height:320px"></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="${btnWrite}">
				<input type="button" value="${btnCancel}">
			</td>
		</tr>
	</table>
</form>