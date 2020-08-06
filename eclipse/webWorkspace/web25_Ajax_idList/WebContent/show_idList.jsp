<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- jstl쓸거면 꼭써야함 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var xhr;
	function startRequest(){
		var id = document.getElementById("memberId").value;
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback;
		xhr.open("get", "find.do?id="+id);
		xhr.send(null);
	}


	function callback() {
		if(xhr.readyState==4){
			if(xhr.status==200){
				document.getElementById("memberIdView").innerHTML
				="<font color=green size=4>"+ xhr.responseText+"</font>";
			}
		}
	}


</script>
</head>
<body>
<h3 align="center">id List....</h3><p>
<h4>리스트폼에서 특정한 아이디를 선택하세요</h4>
<select id="memberId" onchange="startRequest()">
	<option value="">=======id choice======</option>
	<c:forEach items="${list}" var="memberId">
		<option value="${memberId.id}">${memberId.id}</option>
	</c:forEach>
</select>
<span id="memberIdView"></span>
</body>
</html>