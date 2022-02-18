<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(function(){
		var key;
		$('#b1').click(function(){
			$.ajax({
				url : "money.do",
				data : {
					money : $('#money').val(),
					choice : $('#choice').val()
				},
				success: function(x){
					$('#result').html('최종 결제 금액은 '+x+'원입니다.')
				},
				error: function(){
					alert('실패!!')
				}, //error
			}) //ajax
		})
		
		$('#b2').click(function(){
			$.ajax({
				url : "ajax1",
				data : {
					phone : $('#tel').val()
				},
				success: function(x){
					alert('성공!!')
					key=x
					
				},
				error: function(){
					alert('실패!!')
				}, //error
			}) //ajax
		})
		
		$('#b3').click(function(){
			
			if($('#insertkey').val()==key)
			{
				$('#result2').html('인증되었습니다.')
			}
			else
			{
				$('#result2').html('인증 실패')
			}
		})
	}) //$
</script>
</head>
<body>
결제금액:
<input type="text" id="money"><br>
결제수단:(1.계좌이체 2.신용카드 3.휴대폰결제)
<input type="text" id="choice"><br>
<button id="b1">결제하기</button><br>
<div id="result"></div>
<hr color="red">
인증받을 전화번호 : 
<input type="text" id="tel">
<button id="b2">인증번호 받기</button><br>
인증번호 입력 : 
<input type="text" id="insertkey">
<button id="b3">인증</button><br>

<hr color="red">
<div id="result2"></div>

</body>
</html>