<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css">
<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
<script>
	//---초기화
	$(function(){
		
		//---파일 업로드
		$('.upload').on('change', function(){
			if($(this)[0].files[0]!=null)
			{
				var formData=new FormData();
				formData.append("file", $(this)[0].files[0]); //파일정보를 formData 객체에 저장
				
				$.ajax({
					url : "${contextPath}/fileUpload",
					type : "post",
					data : formData,
					dataType : "json",
					processData : false,
					contentType : false,
					beforeSend : function(){
						
					},
					success : function(json){
						$("#m_file").val(json.filename);
					}
				})
			}
		});
		//---파일 업로드
		
		
		$("#btn_save").click(function(){
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
			
			if($("#btn_idcheck").val()==0)
			{
				alert("아이디를 중복 확인해주세요.");
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
					
			$("#frmMember").submit();
		});
		
		$("#btn_idcheck").click(function(){
			if($("#m_id").val()!="")
		    {
			$.ajax({
				url: "${contextPath}/idCheck",
				data:{'check_id': $("#m_id").val()},
				method:"get",
				success:function(data)
				{
					var result=$.trim(data);
					
		            if(result=="true")
		                {
		                    alert("중복된 아이디입니다.");	       
		                }
		            if(result=="false")
		                {
		                    if(confirm("이 아이디를 사용하시겠습니까?"))
		                        {
		                            $("#btn_idcheck").attr('value', 1);
		                            $("#m_id").attr('readonly', 'true');
		                            $("#m_id").attr('style', 'background-color:palegreen;');
		                        }
		                }
		               
		        }
			});
		    }
		    else
		    {
		        alert("아이디를 입력해주세요.");
		    }
		});
	});
</script>
</head>
<body>
<div class="container">
<div class="section">
	<h2>회원가입</h2>
	<form action="${contextPath}/memberSave" method="post" id="frmMember">
	<input type="hidden" name="m_file" id="m_file">
	<table class="bluetop">
		<tr>
			<th>이름</th>
			<td><input type="text" name="m_name" id="m_name"></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="m_id" id="m_id"> <button type="button" class="btn_style_edit" id="btn_idcheck" value="0">중복가입확인</button></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="m_pw" id="m_pw"></td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td><input type="password" name="m_pwconfirm" id="m_pwconfirm"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="m_email" id="m_email"></td>
		</tr>
		<tr>
			<th>휴대폰번호</th>
			<td><input type="text" name="m_phone" id="m_phone"></td>
		</tr>
		<tr>
			<th>사진</th>
			<td><input type="file" class="upload"></td>
		</tr>
			
	</table>
	<div class="btns">
		<button type="button" class="btn_style_submit" id="btn_save">가입</button>
	</div>
	</form>
</div>
</div>

</body>
</html>