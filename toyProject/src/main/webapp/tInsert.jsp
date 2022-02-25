<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			dataType: "json",
			url: "tTime",
			data: {
				mvId : "1"  /* a태그 get으로 받아온 ${mvId} 들어가는 부분 */
			},
			success: function(result){
				for(key in result){
				    console.log(result[key])
				    $('#d1').append("<button class='tButton' id='"+key+"' value='"+result[key]+"'>"+(parseInt(result[key])+12)+":00</button> ")
				}
			},
			error: function(){
				alert('실패.@@@')
			}
		})
		
		
		$(document).on("click",".tButton",function(){
			$.ajax({
				url: "tSeat",
				data: {
					mvId : "2"  /* a태그 get으로 받아온 ${mvId} 들어가는 부분 */
				},
				success: function(result){
					for(key in result){
						$('#d2').html(result)
					}
				},
				error: function(){
					alert('실패.@@@')
				}
			})
		})
		
	})
</script>
<link rel="stylesheet" type="text/css" href="resources/css/project.css">
</head>
<body>
	<div id='total'>
		<div id='top'>
			<jsp:include page="top.jsp"></jsp:include>
		</div>
		<div id='top2'>
			<jsp:include page="top2.jsp"></jsp:include>
		</div>
		<div id='center'>
		<% if(session.getAttribute("userId")!=null){ %>
			<h3>먼저 로그인을 해주세요.</h3>
			<%}else{ %>
				<h3>시간 선택</h3>
				<div id=d1></div>
				<h3>좌석 선택</h3>
				<div id=d2></div>
			<%} %>
		</div>
	</div>
</body>
</html>