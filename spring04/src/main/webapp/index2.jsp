<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/out.css">
<script type="text/javascript" src="resources/js/out.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
	<br>
	
	<form action="create2">
		아이디 : <input type="text" name="id"><br> 
		사이트이름 : <input type="text" name="name"><br>
		사이트주소 : <input type="text" name="url"><br>
		이미지주소 : <input type="text" name="img"><br>
		<button>사이트 등록 요청</button>
	</form>
	<br>
	
	<form action="update2">
		아이디 <input type="text" name="id"><br> 
		바꿀 이름 : <input type="text" name="name"><br>
		<button>사이트 이름 수정</button>
	</form>
	
	<br>
	<form action="delete2">
		아이디 : <input type="text" name="id"><br>
		<button>사이트 삭제</button>
	</form>
	<br>
	
	<a href="list2">
		<button style="color: yellow; background: red;">전체 목록 보기</button>
	</a>
</body>
</html>
