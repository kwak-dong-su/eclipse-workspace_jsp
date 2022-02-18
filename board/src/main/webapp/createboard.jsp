<%@page import="web.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%
     	String user_id = (String)session.getAttribute("user_id"); 
     	
     	String b_title = request.getParameter("b_title"); 
     	String b_content = request.getParameter("b_content");
     	
     	//ctrl+shift+m 
     	BoardVO boardVo = new BoardVO(); //패키지가 달라서 안 찾아질때는 일부 지우고 찾기 
     	boardVo.setB_title(b_title);
     	boardVo.setB_content(b_content);
     	boardVo.setB_name(user_id);
     	
     	BoardDAO dao= new BoardDAO();
     	dao.create(boardVo);
     		
     %>
<!DOCTYPE html>
<html>
<head>
<script>
	alert('작성이 완료되었습니다.');
	location="boardlist.jsp";
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>