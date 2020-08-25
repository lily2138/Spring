<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form>label {
	display: inline-block;
	width: 100px;
}

form>:input {
	display: inline-block;
	width: 100px;
}
</style>
</head>

<body>
<h3>핸드폰 관리 - 핸드폰등록</h3>
	<form action="regPhone.do" name="registerForm" >
	모델번호 : <input type="text" name="num" id="num" required="required">
	모델명 : <input type="text" name="model"><br><br>
	가격 : <input type="text" name="price"><br><br>
	제조사 : <select name="vcode">
  			<option value="10">삼성</option>
  			<option value="20">엘지</option>
  			<option value="30">애플</option>
		</select>
	
	<input type="submit" value="핸드폰 등록">
	<input type="reset" value="취소">
	</form>	
</body>
</html>