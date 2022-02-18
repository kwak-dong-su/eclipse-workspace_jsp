<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="firstweb.DataBase" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

Connection con=null;
PreparedStatement pstmt  = null;

DataBase dataBase=new DataBase();
String query="insert into member(m_name, m_id, m_pw,"+
		" m_email, m_phone) values(?,?,?,?,?)";

try{
	
	Class.forName("org.mariadb.jdbc.Driver");	
	con=dataBase.getConnection();
	System.out.println("Mariadb Connection 성공");
	
	request.setCharacterEncoding("utf-8");
	
	pstmt = con.prepareStatement(query);
	pstmt.setString(1, request.getParameter("m_name"));
	pstmt.setString(2, request.getParameter("m_id"));
	pstmt.setString(3, request.getParameter("m_pw"));
	pstmt.setString(4, request.getParameter("m_email"));
	pstmt.setString(5, request.getParameter("m_phone"));	
	pstmt.executeUpdate();
	
	out.println("등록 완료");

} catch (ClassNotFoundException e) {
	e.printStackTrace();
	System.out.println("연결 실패");
} catch (SQLException e) {
	e.printStackTrace();
	System.out.println("연결 실패");
}
finally
{
	con.close();
	pstmt.close();
	System.out.println("연결 종료");
}
%>
</body>
<script>
alert("회원가입 되었습니다.");
location="memberList.jsp";
</script>
</html>