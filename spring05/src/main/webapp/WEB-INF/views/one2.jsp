<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td{
		width: 150px;
		height: 50px;
		
	}
	button{
		background: black;
		color: white;
		font-weight: bold;
		border: 10px dotted yellow;
	}
	img{
		width: 150px;
		height: 100px;
	}
</style>
</head>
<body>
북마크 검색 결과입니다.
<br>${one}
<hr color="yellow">
<table border="1">
	<tr>
		<td>아이디</td>
		<td>${one.id}</td> <!-- one.getId() -->
	</tr>
	<tr>
		<td>이름</td>
		<td>${one.name}</td> 
	</tr>
	<tr>
		<td>링크</td>
		<td><a href="${one.url}">${one.url}</a></td> <!-- 버튼을 클릭하면 url로 링크 -->
	</tr>
	<tr>
		<td>img</td>
		<td><img src="resources/img/${one.img}"></td> <!-- 이미지가 보이게 -->
	</tr>
</table>
</body>
</html>