<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<script type="text/javascript">
			alert("작성이 완료되었습니다.")
			location.href="bbs.jsp"
		</script>
	</div>
</div>
</body>
</html>