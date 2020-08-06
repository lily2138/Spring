<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Spring Form MVC</h2>
<form action="form.do" method="post">
	NAME <input type="text" name="name"><br><br>
	ADDR <input type="text" name="addr"><br><br>
	<input type="submit" value="보내기">
</form>
<hr>
<a href="anno.do">Annotation Controller 연결하기</a>
</body>
</html>