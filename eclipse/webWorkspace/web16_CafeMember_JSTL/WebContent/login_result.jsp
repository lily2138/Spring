<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${vo!=null}">
		<b>${vo.name}님 로그인 성공!!!</b>
	</c:when>
	<c:otherwise>
		<script>
			alert("로그인부터 해주세요 !!!");
			location.href="login.html";
		</script>
	</c:otherwise>
</c:choose>
<%-- <%
	MemberVO vo = (MemberVO)session.getAttribute("vo");
	if(vo==null){		//로그인결과페이지부터 치고들어오는 사람때문에 이조건문을 달아놓는다.
%>
	<h3>로그인부터 시작하세요....</h3>
	<a href="login.html">Login.html</a>
<%
	}
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Login Information....</h2>
Login ID : <b>${vo.id}</b>
Login NAME : <b>${vo.name}%></b>
Login ADDRESS : <b>${vo.address}%></b>
JSESSION ID VALUE : <b><%= session.getId() %></b><br>
<hr>
<a href="logout.jsp">LOG OUT</a> &nbsp;&nbsp;&nbsp;<a href="index.html">INDEX</a>
</body>
</html>