<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MemberVO vo = (MemberVO)application.getAttribute("vo");
%>
<h2>회원님의 정보를 출력합니다.</h2>
<!-- %=   % :: 출력문 Expression Element -->
<li>당신의 아이디는 <%= vo.getId() %></li>
<li>당신의 비밀번호는<%=vo.getPassword() %></li>
<li>당신의 이름은 <%= vo.getName() %></li>
<li>당신의 주소는 <%= vo.getAddress() %></li>
</body>
</html>