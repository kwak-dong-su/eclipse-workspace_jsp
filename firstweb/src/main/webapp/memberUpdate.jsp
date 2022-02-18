<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="firstweb.DataBase" %>

<%
Connection con=null;
PreparedStatement pstmt=null;
String query="update member set m_name=?, m_id=?, m_pw=?, m_email=?, m_phone=?, m_mdfydate=now() where m_idx=?";

DataBase dataBase=new DataBase();

con=dataBase.getConnection();
pstmt=con.prepareStatement(query);

request.setCharacterEncoding("utf-8");

pstmt.setString(1, request.getParameter("m_name"));
pstmt.setString(2, request.getParameter("m_id"));
pstmt.setString(3, request.getParameter("m_pw"));
pstmt.setString(4, request.getParameter("m_email"));
pstmt.setString(5, request.getParameter("m_phone"));
pstmt.setInt(6, Integer.parseInt(request.getParameter("m_idx")));

if(pstmt.executeUpdate()>0)
{
	%>
	<script>
	alert("정보가 수정되었습니다.");
	location="memberView.jsp?m_idx="+<%=request.getParameter("m_idx")%>;
	</script>
	<%
}
else
{
	%>
	<script>
	alert("수정 에러");
	location="memberView.jsp?m_idx="+<%=request.getParameter("m_idx")%>;
	</script>
	<%
}

con.close();
pstmt.close();

%>



