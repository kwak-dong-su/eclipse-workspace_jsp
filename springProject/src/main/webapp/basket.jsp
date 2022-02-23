<%@page import="com.hi.mvcProject.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
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
			<h3>장바구니 현재 목록</h3>
			<hr>
			<%
			if(session.getAttribute("basket")!=null)
			{
				ArrayList<ProductVO> list = (ArrayList<ProductVO>) session.getAttribute("basket");
			%>
			<%=list.size()%>개가 장바구니에 들어있습니다.
			<table border="1">
				<tr>
					<td class="left">상품번호</td>
					<td class="left">상품이름</td>
					<td class="left">상품가격</td>
					<td class="left">주문</td>
					<td class="left">삭제</td>
				</tr>
				<%for(ProductVO one: list) {%>
					<tr>
						<td class="right"><%=one.getId() %></td>
						<td class="right"><%=one.getName() %></td>
						<td class="right"><%=one.getPrice() %></td>
						<td class="right" ><button class="btn btn-info">주문하기</button></td>
						<td class="right" ><button class="btn btn-info">삭제하기</button></td>
					</tr>
				<%} %>
			</table>
			<%} %>
		</div>
	</div>
</body>
</html>