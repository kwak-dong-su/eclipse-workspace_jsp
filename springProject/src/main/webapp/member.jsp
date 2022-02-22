<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/project.css">
</head>
<body>
	<div id='total'>
		<div id='top'>
			<jsp:include page="top.jsp"></jsp:include>
		</div>
		<div id='top2'>
			<jsp:include page="top2.jsp"></jsp:include>
		</div>
		<div id='center'>
		<% if(session.getAttribute("userId")==null){ %>
			<h3>회원가입</h3>
			<form action="create">
				<table>
					<tr>
						<td class='left'>아이디</td>
						<td><input class='right form-control' type="text" name="id"></td>
					</tr>
					<tr>
						<td class='left'>패스워드</td>
						<td><input class='right form-control' type="text" name="pw"></td>
					</tr>
					<tr>
						<td class='left'>이름</td>
						<td><input class='right form-control' type="text" name="name"></td>
					</tr>
					<tr>
						<td class='left'>전화번호</td>
						<td><input class='right form-control' type="text" name="tel"></td>
					</tr>
				</table>
				<button class='btn-success' type="submit">서버로 전송</button>
			</form>
			<hr>
			<h3>로그인</h3>
			<form action="check">
				<table>
					<tr>
						<td class='left'><i class="glyphicon glyphicon-user"></i>아이디</td>
						<td><input class='right form-control' type="text" name="id"></td>
					</tr>
					<tr>
						<td class='left'><i class="glyphicon glyphicon-lock"></i>패스워드</td>
						<td><input class='right form-control' type="text" name="pw"></td>
					</tr>
				</table>
				<button class='btn-danger' type="submit">로그인</button>
			</form>
			<%}else{ %>
				<span style="color: blue;">${userName}님!! 환영합니다. 아이디가 ${userId}로 로그인되었습니다.</span>
				<a href="logout">
				<button style="width:200px; height:50px;" class="btn btn-success" >로그아웃</button>
				</a>
			<%} %>
		</div>
	</div>
</body>
</html>