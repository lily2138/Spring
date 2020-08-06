<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Form 값을 EL로 받아오기</h2>
<form method = "post" action="EL2_view.jsp">
ID <input type="text" name="userId"><br><br>

<strong>좋아하는 메뉴....</strong>
<input type="checkbox" name="menu" value="pasta">pasta
<input type="checkbox" name="menu" value="egg-bread">egg-bread
<input type="checkbox" name="menu" value="pizza">pizza
<input type="checkbox" name="menu" value="kimbab">kimbab
<br><br>
<input type="submit" value="DataSend">
</form>
</body>
</html>