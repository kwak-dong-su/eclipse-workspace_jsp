<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="web.*"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글내용</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css">
<script>
	/* 
	function boardDelete(b_idx)
	{
		if(confirm("정말로 삭제하시겠습니까?"))
		{
			location="deleteboard.jsp?b_idx="b_idx;
		}
	} */
</script>
</head>
<body>

<div class="container">
<div class="section">
	<%
	BoardDAO boardDAO=new BoardDAO();
	ResultSet rs=boardDAO.board_view(Integer.parseInt(request.getParameter("b_idx")));
	
	if(rs.next())
	{
		out.println("<table>");
		out.println("<tr><td>제목</td>");
		out.println("<td>"+rs.getString("b_title")+"</td></tr>");
		out.println("<tr><td>작성자</td>");
		out.println("<td>"+rs.getString("b_name")+"</td></tr>");
		out.println("<tr><td>내용</td>");
		out.println("<td>"+rs.getString("b_content")+"</td></tr>");
		out.println("</table>");	
	}
	
	BoardVO vo = new BoardVO();
	int b_idx = Integer.parseInt(request.getParameter("b_idx"));
	System.out.println(b_idx); 
	vo.setB_idx(b_idx);
	
%>
<input type="button" onclick="location='${contextPath}/boardlist.jsp'" value="목록">
<input type="button" onclick="location='${contextPath}/updateform.jsp?b_idx=<%=request.getParameter("b_idx")%>'" value="수정">
<input type="button" onclick="location='${contextPath}/deleteboard.jsp?b_idx=<%=request.getParameter("b_idx")%>'" value="삭제">
</div>
</div>

</body>
</html>