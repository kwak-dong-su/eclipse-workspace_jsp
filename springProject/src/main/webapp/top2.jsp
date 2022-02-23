<%@page import="com.hi.mvcProject.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<%
int total=0;
int size=0;
if(session.getAttribute("basket")!=null)
{
	ArrayList<ProductVO> list = (ArrayList<ProductVO>) session.getAttribute("basket");
	size=list.size();
	for(ProductVO one:list)
	{
		total=total+one.getPrice();
	}
}
%>
<!-- 1. 장바구니 개수를 예쁘게 넣어보세요. -->
<!-- 2. 장바구니에 넣은 물건들의 전체 금액을 계산해서 넣어보세요. -->
<div style="text-align: center;">
	장바구니<br>
	총 개수: <%=size%>개<br>
	총 금액: <%=total%>원
</div>

