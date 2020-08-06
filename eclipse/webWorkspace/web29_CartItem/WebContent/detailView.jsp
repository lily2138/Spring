<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){	
	$('[name=cartInsert]').click(function() {
		//var itemArray = ['${item.url}', '${item.name}', '${item.price}'];
		//alert(itemArray)
		localStorage.setItem($(this).attr("id"), $(this).val());
		//localStorage.setItem($(this).attr("id"), itemArray);
	});//click	
});
</script>
</head>
<body>
<h1 align="center">${item.name}의 정보</h1>
<table align="center" width="600">
	<tr>
		<td align="right">조회수 : ${item.count} &nbsp;&nbsp;&nbsp;
		<button name="cartInsert" id="${item.itemNumber}" value="${item.url}, ${item.name}, ${item.price}, 1" >장바구니 담기</button>
		<button name="cartList" onclick="location.href='cartView.jsp'">장바구니 확인</button>
		</td>
	</tr>
</table>
<table align="center" width="600">
	<tr>
		<td rowspan="3"><img alt="" src="${item.url}" width="150" height="150" border="2"></td>
		<td>상품명 : ${item.name}</td>
	</tr>
	<tr>
		<td>가격 : ${item.price} 원</td>
	</tr>
	<tr>
		<td>설명 : ${item.description}</td>
	</tr>
	<tr>
		<td rowspan="2" align="center"><a href="itemList.do">상품목록보기</a></td>
	</tr>
</table>

		
		
</body>
</html>