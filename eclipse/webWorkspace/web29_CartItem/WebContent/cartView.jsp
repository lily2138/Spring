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

/* 	for(var i=0; i<localStorage.length; i++){
		var k=localStorage.key(i);
		alert(k+":"+localStorage[k]);	
	} */
	
	refreshPage();
});

	function amountAdd(){
		for(var key in localStorage) {
			if(key=='length') break;
			if(key==$(this).attr("id")){
				var data = localStorage.getItem(key).split(',');
				data[3] = parseInt(data[3])+1;
				var value = data[0]+","+data[2]+","+data[3]+","+data[4]+","+data[5];
				localStorage.setItem($(this).attr("id"), value);
			}
			
		}
	}
	function refreshPage() {
		var html='';
		var index = 0;
		totalPrice = 0;
		for(var key in localStorage) {
			if(key=='length') break;
			var data = localStorage.getItem(key).split(',');
			html += '<tr>'+
				'<td>'+ ++index +'</td>'+
				'<td><img src=' + data[0] + ' width=150 height=150></td>'+
				'<td>' + data[1] + '</td>'+
				'<td>' + data[2] + '</td>'+
				'<td><img onclick="amountAdd();" id="'+key+'"src=img/up.jpg width=10 height=10 style=cursor:pointer; name=up><div>' + data[3] + '</div><img name=down src=img/down.jpg width=10 height=10 style=cursor:pointer;></td>'+
				'<td><input value='+key+' type=checkbox name=deleteItem></td>'+
				'</tr>';
			totalPrice += parseInt(data[2])*parseInt(data[3]);;
		}
		$('tbody').append(html);
		$('tfoot tr td span').html(totalPrice);
	}
	function deleteStorage() {
		var check = document.getElementsByName("deleteItem");
		for(var i=0; i < check.length; i++) {
			if(check[i].checked==true) {
				//var price = check[i].parentNode.previousSibling.previousSibling.innerHTML;
				//var mount = check[i].parentNode.previousSibling.childNodes[1].innerHTML;
				//totalPrice -= eval(price)*eval(mount);
				
				localStorage.removeItem(check[i].value);
				location.reload();
				//$('tbody').html("");
				
				//refreshPage();
				//$('tfoot tr td span').html(totalPrice);
			}
		}
		
	}
	 

</script>
</head>
<body>
<h1>장바구니</h1>
	<a href="itemList.do">쇼핑 계속하기</a>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>상품이미지</th>
				<th>상품명</th>
				<th>상품가격</th>
				<th>수량</th>
				<th><button onclick="deleteStorage()">삭제</button></th>
			</tr>
		</thead>
		<tbody></tbody>
		<tfoot>
			<tr>
				<td colspan="6">총 결제금액 : <span id="resultTotal"></span></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>