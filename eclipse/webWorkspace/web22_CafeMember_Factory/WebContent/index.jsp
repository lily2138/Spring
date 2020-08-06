<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>MemberCafe MODEL2 회원관리 :: JSP 기본 Element 사용</h1><p>
<%--
	로그인하지 않은 사용자는 단순한 회원검색, 로그인, 회원 가입 기능만 할수 있도록 한다
	로그인 한 사용자는 단순한 회원검색, 전체회원보기,회원정보수정, 로그아웃 기능을 할수 있도록 한다
	c:choose
		c:when test
		c:otherwise
 --%>
 <a href="find.jsp" >회원 검색</a><br> 
 
 <c:choose>
 	<c:when test="${vo!=null}">   <!-- ${empty vo} -->
 		<a href="logout.do" >로그아웃</a>
 		<a href="allMember.do" >전체회원보기</a>
 		<a href="update.jsp" >회원정보수정</a>
 	</c:when>
 	<c:otherwise>
 		 <a href="login.jsp" >로그인 </a><br>
 		 <a href="register.jsp" >회원 가입</a><br>
 	</c:otherwise>
 </c:choose>
 


</body>
</html>




















