<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function idCheck() 
{
	//id에 입력한 값을 가지고 와서
	//글자수가 5 미만이면 다시 작성하세요. 메세지 프린트
	//Document document = new Document(); //body
	//미리 객체를 생성해놨음.==>내장된 객체
	//window: 브라우저 전체
	//document: body태그 부분
	//console: 개발할 때 확인하는 창(f12)
	//location: 주소부분, location.href = ""
	//history: 탐색 리스트
	idValue = document.getElementById("id").value //
	text = ""
	if(idValue.length<5){
		console.log("5 미만입니다. 다시 입력해주세요.")
		text = "5 미만입니다. 다시 입력해주세요."
		document.getElementById("id").value=""
		
	}else{
		console.log("5 이상입니다. 확인완료.")
		text = "5 이상입니다. 확인완료."
	}
	document.getElementById("result").innerHTML=text
}
function pwCheck() 
{
	pwValue1 = document.getElementById("pw1").value
	pwValue2 = document.getElementById("pw2").value
	text=""
	img=""
	if(pwValue1==""||pwValue2==""){
		console.log("패스워드를 입력해주세요.")
		text = "패스워드를 입력해주세요."
	}
	else{
		if(pwValue1==pwValue2){
			console.log("패스워드가 일치합니다.") //파란색으로
			text = "<span style='color:blue'>패스워드가 일치합니다.</span>"
			img = "<img src='resources/img/ok.jpg' style='width:100px'>"
		}else
		{
			console.log("패스워드가 다릅니다.") //빨간색으로
			document.getElementById("pw1").value=""
			document.getElementById("pw2").value=""
			text = "<span style='color:red'>패스워드가 다릅니다.</span>"
			img = "<img src='resources/img/no.png' style='width:100px'>"
			
		}
	}
	document.getElementById("result").innerHTML=text
	document.getElementById("result2").innerHTML=img
	
}
</script>
</head>
<body>
<h3>자바 스크립트 테스트</h3>
<hr>
아이디 : <input name="id" id="id" value="test"><br>
<button onclick="idCheck()">입력 글자수 확인</button>
패스워드1 : <input name="pw1" id="pw1" value="1234"><br>
패스워드2 : <input name="pw2" id="pw2" value="1234"><br>
<button onclick="pwCheck()">입력 패스워드 일치 확인</button>
<hr>
<div id="result"></div>
<div id="result2"></div>
</body>
</html>