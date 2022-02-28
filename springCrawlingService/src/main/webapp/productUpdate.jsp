<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>제품수정</h3>
<form action="update">
<input type="hidden" name="id" value="${param.id}"><br>
이름 : <input type="text" name="name" value="${param.name}"><br>
제품설명 : <input type="text" name="content" value="${param.content}"><br>
가격 : <input type="text" name="price" value="${param.price}"><br>
<button type="submit">서버로 전송</button>
</form>
</body>
</html>