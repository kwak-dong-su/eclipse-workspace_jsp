<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h3>회원가입</h3>
	<form action="createMember">
		아이디: <input type="text" name="id"><br>
		비밀번호: <input type="text" name="pw"><br>
		이름: <input type="text" name="name"><br>
		전화번호: <input type="text" name="tel"><br>
		<button type="submit">가입</button>
	</form>
</body>
</html>