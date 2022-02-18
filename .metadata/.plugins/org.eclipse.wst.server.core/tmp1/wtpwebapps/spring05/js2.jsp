<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	//아이디가 b1인 것을 클릭했을 때 가로안에 넣은 이름없는 함수를
	//실행해주렴.
$(function(){ 
	//body를 먼저 읽고 와서 메모리에 dom tree로 읽어들이면 
	//함수의 내용대로 처리해주렴.
	$('#b1').click(function(){
		//alert('b1 클릭되었음.')
		idValue = $('#id').val()
		if(idValue.length<5){
			$('#result').append('유효하지 않음.<br>')
			//append(): 댓글처럼 계속 끝에 붙임
			//html(): 태그가 있는 조각 html코드 일부분으로 대체
			//text(): 태그가 없는 텍스트만. 
			$('#id').val('')
		}else{
			$('#result').append('유효함.<br>')
		}
	})
	
	$("#b2").click(function(){
		pwValue1 = $('#pw1').val()
		pwValue2 = $('#pw2').val()
		
		if(pwValue1==pwValue2){
			$('#result').html('패스워드가 일치함')
		}else{
			$('#result').html('패스워드가 일치하지 않음')
			$('#pw1').val('')
			$('#pw2').val('')
		}
	})
	
})
</script>
</head>
<body>
<h3>자바 스크립트 테스트</h3>
<hr>
아이디 : <input name="id" id="id" value="test"><br>
<button id="b1">입력 글자수 확인</button>
패스워드1 : <input name="pw1" id="pw1" value="1234"><br>
패스워드2 : <input name="pw2" id="pw2" value="1234"><br>
<button id="b2">입력 패스워드 일치 확인</button>
<hr>
<div id="result"></div>
<div id="result2"></div>
</body>
</html>