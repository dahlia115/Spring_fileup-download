<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
	<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:forEach var="dto" items="${list }">
		아이디 : ${dto.id }<br>
		이름 : ${dto.name }<br>
		이미지 : ${dto.imgName }<br>
		<img  alt="이미지가 없습니다" width="100px" height="100px" 
			src="${contextPath }/download?file=${dto.imgName}"><br>
		<a href="${contextPath }/download?file=${dto.imgName}">
			${dto.imgName}
		</a>
		<hr>
	</c:forEach>
	<a href="${contextPath }/form">다시 업로드 하기</a>
	
</body>
</html>