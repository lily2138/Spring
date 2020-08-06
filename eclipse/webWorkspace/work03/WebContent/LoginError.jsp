<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>로그인실패</b>
<br><br>
<h2>id : <%= request.getParameter("userId") %></h2>
<h2>pass : <%= request.getParameter("userPass") %></h2>
<br>

</body>
</html>