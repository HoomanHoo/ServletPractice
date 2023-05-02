<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fnc" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="project" value="/MemberAndBoard/board/"/>


<c:set var="strContentNum" value="글번호"/>
<c:set var="strSubject" value="제목"/>
<c:set var="strName" value="작성자"/>
<c:set var="strWriteDate" value="작성일"/>
<c:set var="strReadCount" value="조회수"/>
<c:set var="strWrite" value="글쓰기"/>



<c:set var="btnWrite" value="작성"/>
<c:set var="btnOk" value="확인"/>
<c:set var="btnCancel" value="취소"/>
<c:set var="btnLogin" value="로그인"/>
<c:set var="btnLogout" value="로그아웃"/>
<c:set var="btnBack" value="뒤로가기"/>
<c:set var="btnModify" value="수정"/>
<c:set var="btnDelete" value="삭제"/>
<c:set var="btnList" value="글목록으로"/>