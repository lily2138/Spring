<%@page import="servlet.model.BookVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<script type="text/javascript">
$(function() {
	$("#bTitle").hover(function() {
		$.ajax({
			type:'post',
			url:'front.do',
			data:"command=bookDetail&&title="+$('#bTitle').text(),
			success:function(result){
				$('#bookDetail').html(result)

			}//callback
		})//ajax
	});//hover
})
</script>
</head>
<body>
<hr>
<h2> 도서전체목록 </h2>

<form action = "front.do" method="post">
<input type="hidden" name="command" value="searchBook">
	<select name="findKey">
	    <option value="all">전체</option>
	    <option value="title">도서명</option>
	    <option value="publisher">출판사</option>
	    <option value="price">가격</option>
	</select>
	<input type="text" name="findValue" >
	<input type="submit" value="검색"><br><br>
</form>


<table border = "1">
<%
	//List<BookVO> list = (List<BookVO>)application.getAttribute("list");
	List<BookVO> list = (List<BookVO>)request.getAttribute("list");
	
%>
	<thead>
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>도서분류</th>
			<th>저자</th>
		</tr>
	</thead>
	<% 
	for(int i=0; i<list.size(); i++){
		%>
	<tbody>
		<tr>
			<td><%= list.get(i).getIsbn() %></td>
			<td id="bTitle"><%= list.get(i).getTitle() %></td>
			<td><%= list.get(i).getCatalogue() %></td>
			<td><%= list.get(i).getAuthor() %></td>
		</tr>
	</tbody>
<%		
	}
%>
</table><br><br>

<span id="bookDetail">  </span>
</body>
</html>