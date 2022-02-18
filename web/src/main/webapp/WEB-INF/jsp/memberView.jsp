<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css">

<script>
	function userDelete()
	{
		if(confirm("${member.m_name} 회원을 정말로 삭제하시겠습니까?"))
		{
			location="${contextPath}/memberDelete?m_idx=${member.m_idx}&m_name=${member.m_name}";
		}
	}
</script>
</head>
<body>
<div class="container">
<div class="section">
	<h2>회원정보(${sessionScope.user_name}님 환영합니다.)<a href="logout">로그아웃</a></h2>
	<table class="bluetop">
		<tr>
			<th>이름</th>
			<td>${member.m_name}</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${member.m_id}</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${member.m_email}</td>
		</tr>
		<tr>
			<th>휴대폰번호</th>
			<td>${member.m_phone}</td>
		</tr>
		<tr>
			<th>사진</th>
			<td>${member.m_file}</td>
		</tr>
		<tr>
			<th>수정일</th>
			<td><fmt:formatDate value="${member.m_mdfydate}" pattern="yyyy.MM.dd"/></td>
		</tr>
		<tr>
			<th>등록일</th>
			<td><fmt:formatDate value="${member.m_rgstdate}" pattern="yyyy.MM.dd"/></td>
		</tr>	
	</table>
	<div class="btns">
		<button class="btn_style_edit" onclick="location.href='${contextPath}/memberModify?m_idx=${member.m_idx}'">수정</button>
		<button class="btn_style_delete" onclick="userDelete()">삭제</button>
		<button class="btn_style_submit" onclick="location.href='${contextPath}/memberList'">회원목록</button>
	</div>
</div>
</div>

</body>
</html>