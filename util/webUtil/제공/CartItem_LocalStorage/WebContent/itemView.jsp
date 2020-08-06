<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        h1 {
            text-align: center;
        }
        #title {
            background: orange;
            width: 70%;
            margin: auto;
            text-align: right;
            padding: 5px;
            box-sizing: border-box;
        }
        #title button {
        	background: transparent;
		    border: none;
		    font-size: 1rem;
        }
        #title a {
        	text-decoration: none;
        	color: black;
        }
        #title button, a {
            margin-left: 40px;
        }
        #desc {
            width: 70%;
            margin: auto;
            background: papayawhip;
            box-sizing: border-box;
        }
        #left-image {
            float: left;
            width: 70%;
        }
        #left-image *{
            display: block;
        }
        #left-image img {
            width: 100%;
            height: 500px;
        }
        #left-image a {
            text-align: center;
        }
        #right-content {
            float: left;
            width: 30%;
        }
        #right-content p {
            margin: 40px;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
    	$(function() {
    		$('[name=cartinsert]').click(function() {
    			localStorage.setItem($(this).attr('id'), $(this).val());
    			alert("장바구니에 담겨졌습니다");
    		});
    	});
    </script>
</head>
<body>
	<h1>${item.name} 의 정보</h1>
	<p id="title">
       	 조회수 : ${item.count}
        <button name="cartinsert" id="${item.itemNumber}" value="${item.url}, ${item.name}, ${item.price}">장바구니 담기</button>
        <a href="cartList.jsp">장바구니 확인</a>
    </p>
    <div id="desc">
        <div id="left-image">
            <img src="${item.url}">
            <a href="itemList.do">상품 목록 보기</a>
        </div>
        <div id="right-content">
            <p>종 류 : ${item.name}</p>
            <p>가 격 : ${item.price}</p>
            <p style="margin-top: 100px;">설 명 : ${item.description}</p>
        </div>
    </div>
</body>
</html>