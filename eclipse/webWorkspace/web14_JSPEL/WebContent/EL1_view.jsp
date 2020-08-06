<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
EL ::
Attribute에 바인딩된 값을 찾아오는 로직을 태그로 바꾼기술. 
변수명이 아니라 객체를 바인딩한 ${이름}이 사용된다
${이름} == attribute.getAttribute("이름")
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Attribute에 바인딩된 값을 받아오겠습니다....</h2>
<b>1~50까지의 합산 결과 1) :: </b>
<%= request.getAttribute("RESULT") %>
<hr>


<b>1~50까지의 합산ㄴ 결과값 2) EL::</b>
${requestScope.RESULT}<br>
${sessionScope.RESULT}<br>
${RESULT}<br>    <!--처음값으로 받음 (request) 없으면 (session)  -->
${RESULT+1000000}<br>
${NAME}<br>
</body>
</html>