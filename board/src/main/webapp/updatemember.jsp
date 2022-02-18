<%@page import="web.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <!-- 1. 클라이언트가 입력해서 서버로 보낸 데이터를 받아주어야 함. 
    	2. vo 만들어서 데이터들을 넣어준다. 
    	3. vo주면서 dao에게 create해달라고 요청한다. 
    	4. 결과화면을 만들어서 클라이언트에게 보내준다. 
     -->
     <%
     
     	//1.클라이언트가 전송해서 데이터를 받아주자. 
     	/*
     		HttpRequest request = new HttpRequest(); 
     	*/
     	
     	String id = request.getParameter("id"); 
     	String tel = request.getParameter("tel"); 
     	
     	//ctrl+shift+m 
     	MemberVO vo = new MemberVO(); //패키지가 달라서 안 찾아질때는 일부 지우고 찾기 
     	vo.setId(id);
     	vo.setTel(tel);
     	
     	MemberDAO dao = new MemberDAO(); 
     	dao.update(vo);
     	
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	업데이트가 실행되었습니다. 
</body>
</html>