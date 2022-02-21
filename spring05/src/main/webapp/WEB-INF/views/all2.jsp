<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- JSTL(JavaStandard Tag Library -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td{
		width: 150px;
		height: 50px;
		text-align: center;
		
	}
	.left{
		background: skyblue;
	}
	.right{
		background: lightblue;
	}
	
</style>
</head>
<body>
	<table border="1">
	<tr>
		<td class="left">아이디</td>
		<td class="left">이름</td>
		<td class="left">img</td>
	</tr>
	<c:forEach items="${list}" var="one">
	<tr>
		<td class="right">${one.id}</td> <!-- one.getId() -->
		<td class="right">${one.name}</td> 
		<td class="right"><a href="one2?id=${one.id}"><img src="resources/img/${one.img}" width="100px" height="50px"></a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>