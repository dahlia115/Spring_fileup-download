<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 업로드</h1>
	<form action="${contextPath }/upload" enctype="multipart/form-data" method="post"><!-- 무조건 post방식으로 넘긴다 -->
		<input type="text" name="id" placeholder="input id"><br>
		<input type="text" name="name" placeholder="input name"><br>
		<input type="file" name="file"><br>
		<input type="submit" value="업로드">
	</form>	
	<hr>
	<a href="${contextPath }/views">파일보기</a>
</body>
</html>






