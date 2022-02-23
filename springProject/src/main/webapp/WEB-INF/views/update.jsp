<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<h3>글 수정</h3>
			<form action="update2">
			<input type="hidden" name="id" value="${one.id}">
			<input type="hidden" name="writer" value="${one.writer}">
				<table>
					<tr>
						<td class='left'>제목</td>
						<td><input class='right form-control' type="text" name="title" value="${one.title}"></td>
					</tr>
					<tr>
						<td class='left'>내용</td>
						<td><textarea rows="10" class='right form-control' name="content">${one.content}</textarea></td>
					</tr>
				</table>
				<button class='btn-success' type="submit">수정완료</button>
			</form>
		</div>
	</div>
</body>
</html>