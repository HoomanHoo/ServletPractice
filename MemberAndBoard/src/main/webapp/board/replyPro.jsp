<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="textSet.jsp"%>
<script src="${project}boardScript.js"></script>
<script type="text/javascript">
//<!--
	alert("댓글이 등록되었습니다");
//-->
</script>
<c:redirect url="content.net?postNum=${postNum}"/>