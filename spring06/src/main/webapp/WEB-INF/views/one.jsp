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
	}
	img{
		width: 150px;
		height: 100px;
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
		<td class="left">제품번호</td>
		<td class="right">${one.id}</td> <!-- one.getId() -->
	</tr>
	<tr>
		<td class="left">제품이름</td>
		<td class="right">${one.name}</td> 
	</tr>
	<tr>
		<td class="left">제품설명</td>
		<td class="right">${one.content}</td>
	</tr>
	<tr>
		<td class="left">제품가격</td>
		<td class="right">${one.price}</td>
	</tr>
	<tr>
		<td class="left">제품이미지</td>
		<td class="right"><img src="resources/img/${one.img}"></td> <!-- 이미지가 보이게 -->
	</tr>
</table>
<a href="productUpdate.jsp?id=${one.id}&name=${one.name}&content=${one.content}&price=${one.price}"><button>수정</button></a>
<a href="delete?id=${one.id}"><button>삭제</button></a>
</body>
</html>