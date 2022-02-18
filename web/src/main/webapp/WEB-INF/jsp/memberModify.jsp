<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 수정</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css">
<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
<script>
	//---초기화
	$(function(){
		$("#btn_modify").click(function(){
			if($("#m_name").val()=='')
			{
				alert("이름을 입력해주세요.");
				$("#m_name").focus();
				return;
			}
			
			if($("#m_id").val()=='')
			{
				alert("아이디를 입력해주세요.");
				$("#m_id").focus();
				return;
			}
			
			if($("#m_pw").val()=='')
			{
				alert("비밀번호를 입력해주세요.");
				$("#m_pw").focus();
				return;
			}
			
			if($("#m_pwconfirm").val()=='')
			{
				alert("비밀번호 확인을 입력해주세요.");
				$("#m_pwconfirm").focus();
				return;
			}
			
			if($("#m_pw").val()!=$("#m_pwconfirm").val())
			{
				alert("비밀번호가 같지 않습니다.");
				return;
			}
			
			if($("#m_email").val()=='')
			{
				alert("이메일을 입력해주세요.");
				$("#m_email").focus();
				return;
			}
			
			if($("#m_phone").val()=='')
			{
				alert("휴대폰번호를 입력해주세요.");
				$("#m_phone").focus();
				return;
			}
				
			if(confirm("수정하시겠습니까?"))
			{
				$("#frmMember").submit();
			}
		});
		
		$("#btn_back").click(function(){
			location="${contextPath}/memberView?m_idx=${member.m_idx}";
		});

	});
</script>
</head>
<body>
<div class="container">
<div class="section">
	<h2>회원정보 수정</h2>
	<form action="${contextPath}/memberUpdate" method="post" id="frmMember">
	<input type="hidden" name="m_idx" id="m_idx" value="${member.m_idx}">
	<table class="bluetop">
		<tr>
			<th>이름</th>
			<td><input type="text" name="m_name" id="m_name" value="${member.m_name}"></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${member.m_id}</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="m_pw" id="m_pw" value="${member.m_pw}"></td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td><input type="password" name="m_pwconfirm" id="m_pwconfirm" value="${member.m_pw}"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="m_email" id="m_email" value="${member.m_email}"></td>
		</tr>
		<tr>
			<th>휴대폰번호</th>
			<td><input type="text" name="m_phone" id="m_phone" value="${member.m_phone}"></td>
		</tr>
	</table>
	<div class="btns">
		<button type="button" class="btn_style_submit" id="btn_modify">수정</button>
		<button type="button" class="btn_style_submit" id="btn_back">취소</button>
	</div>
	</form>
</div>
</div>

</body>
</html>