<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="textSet.jsp"%>
<script src="${project}script.js"></script>    
    
    
    <!-- result = -1 -> sql 오류 -->
<c:if test="${result eq -1}">
<script type="text/javascript">
//<!--
alert("오류가 발생했습니다. 잠시 후 다시 시도해주세요");

history.go(-2);
//-->
</script>
</c:if>


<!-- result = 0 -> sql에 해당하는 요청이 없음  -->
<c:if test="${result eq 0}">
<script type="text/javascript">
//<!--
alert("요청하신 작업이 실패했습니다\n 잠시 후 다시 시도해주세요");

history.go(-2);
//-->
</script>
</c:if>


<!-- result = -4 -> 비밀번호 오류  -->
<c:if test="${result eq -4}">
	<script type="text/javascript">
	//<!--
	alert(notEqualPasswd);
	
	history.go(-1);
	//-->
	</script>
</c:if>





  <!-- result = -5 -> 비로그인 상태로 로그인 필요 페이지 접근  -->
<c:if test="${result eq -5}">
	<script type="text/javascript">
	//<!--
	alert(missMatchInfo);
	//-->
	</script>
	<meta http-equiv="refresh" content="0; url='loginpage.net'">
</c:if>
  