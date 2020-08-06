<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>1. jsp 기본태그로 받아오기</b>
<%= request.getParameter("userId") %><br>
<b>2. EL로 받아오기</b>
${param.userId}<br>
<hr>
<b>1. jsp 기본태그로 받아오기 : </b><br>
<%
	String[] menus = request.getParameterValues("menu");
	for(String menu : menus){
%>		
	<%=menu %>
<%	
	}
%>
<br><br><br>
<B>2. EL로 받아오기 : </B><br>
선택한 메뉴 : 
${paramValues.menu[0]}
${paramValues.menu[1]}
${paramValues.menu[2]}
${paramValues.menu[3]}
</body>
</html>