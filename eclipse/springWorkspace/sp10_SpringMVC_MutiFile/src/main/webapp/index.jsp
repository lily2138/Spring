<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Multi File Upload Test</h2>
<form action="multiupload.do" method="post" enctype="multipart/form-data">
	사용자정보 :: <input type="text" name="userName"><p>
	<input type="file" name="file[0]"><p>
	<input type="file" name="file[1]"><p>
	<input type="file" name="file[2]"><p>
	
	<input type="submit" value="멀티파일전송">
</form>
</body>
</html>