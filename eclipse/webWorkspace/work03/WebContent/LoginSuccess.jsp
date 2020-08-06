<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b><%= request.getParameter("userId") %>님이 로그인하셨습니다.</b>
<br><br>
<h2>id : <%= request.getParameter("userId") %></h2>
<h2>pass : <%= request.getParameter("userPass") %></h2>
<br>
<a href="book.html">도서등록</a>
<a href="">로그아웃</a>

</body>
</html>