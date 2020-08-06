<%@page import="servlet.model.BookVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
<h2> 전체 Book 리스트 </h2>
<table border = "2">
<%
	
	List<BookVO> list = (List<BookVO>)application.getAttribute("list");
	//List<BookVO> list = (List<BookVO>)request.getAttribute("list");
	for(int i=0; i<list.size(); i++){
%>

	<tr>
	<td><%= i+1 %></td>
	<td><%= list.get(i).getIsbn() %></td>
	<td><%= list.get(i).getTitle() %></td>
	<td><%= list.get(i).getCatalogue() %></td>
	<td><%= list.get(i).getNation() %></td>
	<td><%= list.get(i).getPublishDate() %></td>
	<td><%= list.get(i).getPublisher() %></td>
	<td><%= list.get(i).getAuthor() %></td>
	<td><%= list.get(i).getPrice() %></td>
	<td><%= list.get(i).getCurrency() %></td>
	<td><%= list.get(i).getDescription() %></td>
	</tr>
<%		
	}
%>
</table>
</body>
</html>