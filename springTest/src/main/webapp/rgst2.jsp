<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
</script>
<link rel="stylesheet" type="text/css" href="resources/css/project.css">
</head>
<script>
$(function() {
	$("#btn1").click(function(){
		console.log('네이버 로그인 API 요청1')
		$.ajax({
			type: "POST",
			dataType : "json",
			url : "https://nid.naver.com/oauth2.0/token",
			data : {
				grant_type : "authorization_code",
				client_id : "클라이언트아이디",
				client_secret : "클라이언트시크릿",
				code : "${param.code}",
				state : "${param.state}"
			},
			success : function(result) {
				for (key in result) {
					console.log(result[key])
				}
			},
			error : function() {
				alert('실패.@@@')
			}
		})
	});
	
	$("#btn2").click(function(){
		console.log('네이버 로그인 API 요청2')
		$.ajax({
			type: "GET",
			dataType : "json",
			url : "https://openapi.naver.com/v1/nid/me",
			headers: {},
			data : {
				grant_type : "authorization_code",
				client_id : "클라이언트아이디",
				client_secret : "클라이언트시크릿",
				code : "${param.code}",
				state : "${param.state}"
			},
			success : function(result) {
				for (key in result) {
					console.log(result[key])
				}
			},
			error : function() {
				alert('실패.@@@')
			}
		})
	});
})
</script>
<body>
네이버 회원가입 페이지
<button id="btn1">호출1</button>
<button id="btn2">호출2</button>
</body>
</html>