<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="resources/img/naver.png">
<form action="insert.do">
아이디 : <input type="text" name="id"><br>
이름 : <input type="text" name="name"><br>
주소 : <input type="text" name="url"><br>
이미지명 : <input type="text" name="img"><br>
<button type="submit">서버로 전송</button>
</form>
<hr>
<form action="one2">
검색할 아이디 : <input type="text" name="id"><br>
<button type="submit">북마크 검색</button>
</form>
<a href="">
<button>전체 북마크 조회</button>
</a>
</form>
</body>
</html>