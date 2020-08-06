<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)request.getAttribute("id");   //object로 받기 때문에 (String)해주야한다

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>조회한 id님의 정보입니다....</h2>
이름 : 하경이 <br>
아이디 : <%= id %><br>
주소 : 강서<br>
</body>
</html>