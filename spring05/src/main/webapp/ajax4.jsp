<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){ //dom(document object model) tree
		//body dom tree로 ram에 읽어들인 후 function을 실행하라. 익명함수
		//var a = 100
		//let a = 100
		//table-tr-td
		// body -- 주소 : table : 주소 -- tr
		$('#b1').click(function(){
			$.ajax({
				url: "resources/file/MOCK_DATA.json",
				//url: " https://api.rss2json.com/v1/api.json?rss_url=https%3A%2F%2Fwww.chosun.com%2Farc%2Foutboundfeeds%2Frss%2Fcategory%2Fentertainments%2F%3FoutputType%3Dxml&api_key=xs2xpqzagvpagqouevlvhnhgwuocsbvxtljzmao2" ,
				//url: "https://rss.hankooki.com/sports/sp_entv.xml",	
				/* data: {
					url: "https://www.chosun.com/arc/outboundfeeds/rss/category/entertainments/?outputType=xml",
					api_key: "xs2xpqzagvpagqouevlvhnhgwuocsbvxtljzmao2",
					count : 20
								
				}, */
				success: function(result){
					$(result).each(function(i, one){
						console.log(one.id)
						//div안에 1000명의 성과 이름/이메일을 프린트
						$('#d1').append("이름: "+one.first_name+" / 성: "+one.last_name+" / 주소: "+one.addr+"<br>")
					})
					
					
					
					/* //alert("신문사 연결 성공.@@")
					list = result.items // [{}, {}, {}, ...]
					//alert(list.length)
					$(list).each(function(index, news){
						//console.log(index+"   "+news.author)
						img=news.thumbnail
						console.log(img)
						$('#d1').append("<img src='"+img+"' width='200' height='200'>")
						//title
						title=news.title
						link=news.link
						//title을 클릭했을 때, link연결
						pubDate=news.pubDate
						//날짜를 title옆에 보이도록 해주세요.
						$('#d1').append("<a href='"+link+"'>"+title+"</a> "+pubDate+"<br>")
					})*/
				} ,
				error: function(){
					alert('ajax 실패.@@')
				}
				
			})
		})
		
	})
</script>
</head>
<body>
	<button id="b1">MOCK_DATA(JSON)</button>
	<hr color="red">
	<div id="d1"></div>
</body>
</html>