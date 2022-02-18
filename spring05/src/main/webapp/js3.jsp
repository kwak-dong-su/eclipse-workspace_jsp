<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Dialog - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
  <script>
  $( function() {	  
	 $('#b1').click(function(){
		 $( "#dialog2" ).css('visibility', 'visible');
		 $( "#dialog2" ).dialog();
	 })
	 
	 $('#b2').click(function(){
		 $( "#dialog" ).css('visibility', 'visible');
		 $( "#dialog" ).dialog();
	 })
    
  } );
  </script>
</head>
<body>
<button id="b1">오늘 일정은?</button>
<button id="b2">오늘 점심메뉴는?</button>
<div style="visibility:hidden;" id="dialog" title="오늘 점심메뉴는?">
  <p> 국밥을 먹을 예정. </p>
</div>
<div style="visibility:hidden;" id="dialog2" title="오늘 일정은?">
  <p> 수업!! 수업!! 집으로.!!! </p>
</div>
</body>
</html>