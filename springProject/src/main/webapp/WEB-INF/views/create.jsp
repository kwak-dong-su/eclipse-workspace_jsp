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
		<jsp:include page="../../top.jsp"></jsp:include>
	</div>
	<div id='top2'>
		<jsp:include page="../../top2.jsp"></jsp:include>
	</div>
	<div id='center'>
		<h3>회원가입에 문제가 생겼습니다. 다시 시도해주세요.</h3>
		<hr>
		<span class="glyphicon glyphicon-search"></span>
		<a href="member.jsp"><button class="btn btn-info" >로그인 페이지로</button></a>
	</div>
</div>
</body>
</html>