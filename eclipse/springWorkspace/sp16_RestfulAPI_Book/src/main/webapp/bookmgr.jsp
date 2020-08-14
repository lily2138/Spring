<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	font-family: d2Coding;
	width: 800px;
	margin: 0 auto;
}

table {
	border: 1px gray;
}
.t {
	background-color: gray;
}
</style>
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<script>
$(function() {
	$("#allBooks").click(function() {
		allBook();
	});
});

function allBook() {
	$.ajax({
		url : "api/book",
		type : "get",
		contentType: "application/json; charset=utf-8",
		
		error : function(xhr, status, message) {
			alert("error:" + message);
		},
		success : function(data) {
			$('#book-list').empty();
			$('#book-list').append("<ul>");
			for(var i = 0; i < data.length; i++) {
				$('#book-list').append("<li onclick='bookInfo(\""+ data[i].isbn +"\")'>" + data[i].isbn + "</li>");
			}
			$('#book-list').append("</ul>");
		}
	});
}

function bookInfo(isbn) {
	$.ajax({
		url : "api/book/"+isbn,
		type : "get",
		contentType: "application/json; charset=utf-8",
		
		error : function(xhr, status, message) {
			alert("error:" + message);
		},
		success : function(data) {
			$('#book-info').empty();
			
			var temp = "";
			temp += "<input type='button' value='추가' onclick='bookInsert()'> ";
			temp += "<input type='button' value='수정' onclick='bookUpdate()'> ";
			temp += "<input type='button' value='삭제' onclick='bookDelete(\""+ data.isbn +"\")'><br><br>";
			temp += "<table>";
			temp += "<tr><td class='t' width='100px'>ISBN</td><td width='200px'><input type='text' name='isbn' value='" + data.isbn + "'></td></tr>";
			temp += "<tr><td class='t'>제목</td><td><input type='text' name='title' value='" + data.title + "'></td></tr>";
			temp += "<tr><td class='t'>저자</td><td><input type='text' name='author' value='" + data.author + "'></td></tr>";
			temp += "<tr><td class='t'>출판사</td><td><input type='text' name='publisher' value='" + data.publisher + "'></td></tr>";
			temp += "<tr><td colspan='2'><textarea name='description'>" + data.description + "</textarea></td></tr>";
		
			$('#book-info').append(temp);
		}
	});
	
}

function bookInsert() {		
	$.ajax({
		url : "api/book",
		type : "post",
		dataType : "json",
		data:JSON.stringify({
			"isbn" : $('input[name=isbn]').val(),
			"title" : $('input[name=title]').val(),
			"author" : $('input[name=author]').val(),
			"publisher" : $('input[name=publisher]').val(),
			"description" : $('textarea[name=description]').val()
		}),
		contentType: "application/json; charset=utf-8",
		
		error : function(xhr) {
			if(xhr.status == 200) {
				alert("INSERT 성공");
				allBook();
			} 
			else alert("error:" + xhr.status); 
			alert("error:" + xhr.status);
		},
		success : function(data) {
			alert("INSERT 성공");
			allBook();
		}
	});
}

function bookUpdate() {
	$.ajax({
		url : "api/book",
		type : "update",
		dataType : "json",
		data:JSON.stringify({
			"isbn" : $('input[name=isbn]').val(),
			"title" : $('input[name=title]').val(),
			"author" : $('input[name=author]').val(),
			"publisher" : $('input[name=publisher]').val(),
			"description" : $('textarea[name=description]').val()
		}),
		contentType: "application/json; charset=utf-8",
		
		error : function(xhr) {
			if(xhr.status == 200) {
				alert("UPDATE 성공");
				allBook();
			}
			else alert("error:" + xhr.status);
		},
		success : function(data) {
			alert("UPDATE 성공");
			allBook();
		}
	});
}

function bookDelete(delIsbn) {
	$.ajax({
		url : "api/book/"+delIsbn,
		type : "delete",
		
		error : function(xhr) {
			alert("error:" + xhr.status);
		},
		success : function(data) {
			alert("DELETE 성공");
			allBook();
			$('#book-info').empty();
		}
	});

}


</script>
</head>
<body>
	<div align="center"><h1>Welcome To PlayData</h1></div>
	<div style="text-align: right;">
		<a href="#">아이디</a>
		<a href="#">로그아웃</a>
	</div>
	<hr>
	<h2>도서관리</h2>
	<input type="button" id="allBooks" value="목록조회"> (상세 내용을 조회하기 위해서 목록의 아이템을 클릭하세요.)
	<div id="book-list"></div>
	<br>
	<div id="book-info"></div>
</body>
</html>