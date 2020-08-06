<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<script type="text/javascript">
	$(function(){
		$('input[type=button]').click(function(){
			//window.open("IdcheckServlet?id="+$('input[name=id]').val());
			window.open("IdcheckServlet?id="+$('#id').val(),"", "width=300,height=200, top=100,left=400");
		});//click
	});
</script>
</head>
<body>
<h3>회원가입</h3>
<!-- register_action에서 하고있는 기능이  RegisterServletd으로 이동
	 register_result.jsp로 결과를 보낸다.
-->
	<form action="RGS" name="registerForm" >
ID : <input type="text" name="id" id="id" required="required"><br><br>
<input type="button" value="중복확인"><br><br>
PASSWORD : <input type="password" name="password" required="required"><br><br>
NAME : <input type="text" name="name" required="required"><br><br>
ADDRESS : <input type="text" name="address" required="required"><br><br>

<input type="submit" value="member register">
	</form>
</body>
</html>























