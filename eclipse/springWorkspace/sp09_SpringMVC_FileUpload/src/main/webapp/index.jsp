<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 
File Upload 폼 작성시 주의사항
1) form tag를 이용하자... a 태그는 사용 못함
2) 전송방식은 반드시 post로 한다... | 단순한 스트링값을 넘기는 것이 아니라 MultipartFile 객체를 넘기는 것이다.
3) form 의 속성으로 action, method 말고도 enctype="multipart/form-data"이 부분은 반드시 추가한다.
4) MutipartFile   ---  파일업로드 핵심라이브러리...이걸 빈설정문서에 등록한다...
 -->
</head>
<body>
<h2 align = "center">Single Fie Upload Test...</h2>
<form action="fileUpload.do" method="post" enctype="multipart/form-data">
사용자명 :: <input type="text" name="userName"><p>
<input type="file" name="uploadFile"> <p>     <!-- 파일선택 -->
<input type="submit" value="파일 업로드">
</form>
<!-- 
보통은 여기까지 작성한 다음에 바로 Controller 작성으로 넘어가는게 일반적이다...
하지만 파일업로드 로직은 Controller 작성으로 넘어가기 전에 VO작성을 먼저 하고 넘어간다...

VO작성?
VO가 뭔지 정확한 이해를 해야한다.
 -->
<hr>
<!-- <a href="fileUpload.do"></a> -->
</body>
</html>