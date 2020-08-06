<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${vo !=null}">
		<b>${vo.name}님 로그인 성공!!</b>
	</c:when>
	<c:otherwise>
		<script>
			alert("로그인부터 해주세요!!");
			location.href="login.jsp";
		</script>
	</c:otherwise>
</c:choose>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Login Information....</h2>
Login  ID : <B>${vo.id}</B><br/>
Login  NAME : <B>${vo.name}</B><br/>
Login  ADDRESS : <B>${vo.address}</B><br/>
<hr>
<a href="logout.do">LOG OUT</a>&nbsp;&nbsp;&nbsp;<a href="index.jsp">INDEX</a>
</body>
</html>










