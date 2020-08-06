<!-- 
1. 라이브러리 추가....standard.jar | jstl.jar
2. tagLib 속성을 지정
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- c:set :: 변수?를 지정 -->
<!-- num1이라는 변수를 선언. 여기에 7이라는 값을 할당 -->
<c:set var="num1" value="7"/>
<c:set var="num2" value="9"/>

<!-- multiple 변수선언 num*num2를 곱한 값을 할당 -->
<c:set var="multiple" value="${num1*num2}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>${num1}과 ${num2}의 곱은 ${multiple} 입니다.</b>
</body>
</html>