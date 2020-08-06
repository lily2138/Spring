<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>${param.name} 님의 정보를 수정하셨습니다</h3>

<h2>Update Information....</h2>
ID : <B>${vo.id}</B><br/>
NAME : <B>${vo.name}</B><br/>
ADDRESS : <B>${vo.address}</B><br/>
JSESSION  ID VALUE :: <B><%= session.getId() %></B><br/>
<hr>
<a href="index.jsp">INDEX</a>
</body>
</html>