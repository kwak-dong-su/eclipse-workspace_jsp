<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="web.*"%>
<%@ page import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css">
<script>
	
</script>
</head>
<body>
<div class="container">
<div class="section">
	<table class="bluetop">
		<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
	</tr>
		<%
			String user_id = (String)session.getAttribute("user_id"); 
			System.out.println(user_id);
			BoardDAO boardDAO=new BoardDAO();
			ResultSet rs = boardDAO.board_list();
			
			MemberDAO memberDAO=new MemberDAO();
			
			while(rs.next())
			{
				out.println("<tr>");
				out.println("<td>"+rs.getInt("b_idx")+"</td>");
				out.println("<td><a href='boardview.jsp?b_idx="+rs.getInt("b_idx")+"'>"+rs.getString("b_title")+"</a></td>");
				out.println("<td>"+rs.getString("b_name")+"</td>");
				out.println("<td>"+rs.getString("b_rgstdate")+"</td>");
				out.println("</tr>");
			}	
		%>	
	</table>
	<input type="button" onclick="location='${contextPath}/addboard.html'" value="새 글">
</div>
</div>
</body>
</html>