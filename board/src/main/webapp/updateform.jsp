<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	int b_idx = Integer.parseInt(request.getParameter("b_idx")); 
    	System.out.println(b_idx); 
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action = "updateboard.jsp" method="get">
   <input type = "hidden" name = "b_idx" value="<%=request.getParameter("b_idx")%>"/>
   제목:<input type = "text" name = "b_title"/><br> 
   내용:<input type = "text" name = "b_content"/>
   <button type = "submit">수정버튼</button>
   </form>
</body>
</html>