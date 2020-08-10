<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function downloadFile(filename){
		if(confirm("파일을 다운로드 하시겠습니까?"))
			location.href="downloadFile.do?filename="+filename;
	}
</script>
</head>
<body>

<h2><b>Multi File Upload OK~~~~</b></h2>
<c:forEach items="${uploadfile}" var="fileName">
	<ul>
		<li>Upload File :: <a href="javascript:downloadFile('${fileName}')">${fileName}</a></li>
	</ul>
</c:forEach>


</body>
</html>