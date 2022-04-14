<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
function rgstWithNaver(){
	var clientID="클라이언트아이디";
	var clientSecret="클라이언트시크릿";
    var url = "https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id="+clientID+"&state="+clientSecret+"&redirect_uri=http://localhost:8080/mvc/rgst.jsp"; // 띄우고 싶은 url값을 입력해줍니다.
    var name = "네이버로 회원가입"; // 팝업의 이름을 입력해줍니다.
    var option = "width = 500, height = 700, top = 100, left = 200, location = no" // 팝업창의 크기 및 기타 css를 설정해줍니다.
    window.open(url, name, option); // 새로운 창이 뜨면서 팝업이 생성됩니다.
}

</script>
<link rel="stylesheet" type="text/css" href="resources/css/project.css">

<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id" content="인증키">
<script src="https://apis.google.com/js/platform.js" async defer></script>
</head>
<body>
	<button onclick="rgstWithNaver()" style='padding: 0; border: none; background: none;'><img src='resources/img/btnG_완성형.png' width="150px"></button>
	<div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
</body>
<script>
function onSignIn(googleUser) {
    // Useful data for your client-side scripts:
    var profile = googleUser.getBasicProfile();
    console.log("ID: " + profile.getId()); // Don't send this directly to your server!
    console.log('Full Name: ' + profile.getName());
    console.log('Given Name: ' + profile.getGivenName());
    console.log('Family Name: ' + profile.getFamilyName());
    console.log("Image URL: " + profile.getImageUrl());
    console.log("Email: " + profile.getEmail());

    // The ID token you need to pass to your backend:
    var id_token = googleUser.getAuthResponse().id_token;
    console.log("ID Token: " + id_token);
  }
</script>
</html>