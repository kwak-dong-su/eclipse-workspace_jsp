<%@page import="web.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="vo" class="web.MemberVO">
	<jsp:setProperty name="vo" property="*">
</jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MemberDAO dao=new MemberDAO();
		boolean result=dao.login(vo);
		String text="로그인 실패";
		if(result)
		{
			session.setAttribute("user",vo.getId());
			text="로그인 성공";
			
		}
	%>
로그인 결과는 >> <%=text%>
세션 user값은 >> <%=session.getAttribute("user") %>, ${user}
</body>
</html>