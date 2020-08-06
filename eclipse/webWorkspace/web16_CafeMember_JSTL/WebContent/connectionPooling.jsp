<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
1. ResourceFactory를 was에 바인딩 : 제품을 이름으로 등록....META-INF/Context.xml
2. ResourceFactory(DataSource)를 하나 받아온다....
 -->
<%
	Connection conn = null;
	Context ic = new InitialContext();
	DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
	out.println("DataSource....Lookup");
	
	conn = ds.getConnection();
	out.println("Connection..... rent......okay");
%>
</body>
</html>