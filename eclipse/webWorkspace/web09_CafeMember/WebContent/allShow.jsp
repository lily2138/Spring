<%@page import="servlet.model.MemberVO"%>
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

<b><% if(request.getParameter("name") !=null){
	out.println(request.getParameter("name") +"님 회원 가입 되셨습니다.");
}
%>
</b>

<hr>
<h2> 전체 cafe 명단 리스트 </h2>
<table border = "2">
<%
	
	List<MemberVO> list = (List<MemberVO>)application.getAttribute("list");
	//List<MemberVO> list = (List<MemberVO>)request.getAttribute("list");
	for(int i=0; i<list.size(); i++){
%>
	<tr>
	<td><%= i+1 %></td>
	<td><%= list.get(i).getId() %></td>
	<td><%= list.get(i).getPassword() %></td>
	<td><%= list.get(i).getName() %></td>
	<td><%= list.get(i).getAddress() %></td>
	</tr>
<%		
	}
%>
</table>

</body>
</html>