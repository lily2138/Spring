<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align = "center">Fruit Total List 1. </h1>
<table align = "center"> <!-- ${item.getUrl}에서 변경해서 쓴다  -->
	<tr>
		<c:forEach items="${list}" var="item">
			<td>
				<a href="detailView.do?itemnumber=${item.itemNumber}"><img alt="" src="${item.url}" width="150" height="150" border="2"></a><br>
				상품명 : ${item.name} <br>
				가격 : ${item.price} 원 <br>
			</td>
		</c:forEach>
	</tr> 
</table>

<!-- 오늘 본 상품정보를 이곳에다가 출력... -->
<c:if test="${!empty fruits}">
<h2 align = "center"><font color="purple">오늘본 상품들</font></h2>
<table align="center" bgcolor="lightgray">
	<tr>
		<c:forEach items="${fruits}" var="fruit">
			<td>
				<img alt="" src="${fruit}" width="150" height="150" border="2">
			</td>
		</c:forEach>
	</tr>
</table>
</c:if>
</body>
</html>