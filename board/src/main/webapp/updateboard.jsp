<%@page import="web.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%
  		int b_idx = Integer.parseInt(request.getParameter("b_idx")); 
        String b_title = request.getParameter("b_title"); 
        String b_content = request.getParameter("b_content");
        
        //ctrl+shift+m 
        BoardVO boardVo = new BoardVO(); //패키지가 달라서 안 찾아질때는 일부 지우고 찾기 

        boardVo.setB_title(b_title);
        boardVo.setB_content(b_content);
        boardVo.setB_idx(b_idx);
        
        BoardDAO dao= new BoardDAO();
        dao.update(boardVo);
           
     %>
      <script>
      alert('수정이 이루어졌습니다.')
      location.href = "/board/boardlist.jsp"
     </script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>

   
</body>
</html>