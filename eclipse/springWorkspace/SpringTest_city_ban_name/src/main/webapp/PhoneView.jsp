<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>
<h1 align="center">핸드폰목록조회 </h1>
<table align="center">
	<tr>
		<c:forEach items="${phoneList}"   var="phone">
			<td>
			<a href="phoneView.do?num=${phone.num}">${phone.num}</a>
				상품명 : ${phone.model}
				가  격 : ${phone.price}원
			</td>
		</c:forEach>
	</tr>
</table>	
</body>
</html>