<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="web.*"%>
     <%
     int b_idx = Integer.parseInt(request.getParameter("b_idx")); 
 	 System.out.println(b_idx); 
     
     BoardDAO dao = new BoardDAO(); 
   	 dao.delete(b_idx);
   	 
     %>
     <script>
      alert('삭제가 이루어졌습니다.')
      location.href = "/board/boardlist.jsp"
     </script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>