<%@ page import="java.sql.*" %>
<%@ page import="firstweb.DataBase" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<script>
	function back()
	{
		location="memberList.jsp";
	}
	
	function userDelete(m_idx, m_name)
	{
		if(confirm(m_name+" 회원을 정말로 삭제하시겠습니까?"))
		{
			location="memberDelete.jsp?m_idx="+m_idx+"&m_name="+m_name;
		}
	}
</script>
<style>
	td
	{
    	text-align: center;
    	border: 1px solid #444444;
    }
</style>
</head>
<body>
<%
Connection con=null;
PreparedStatement pstmt  = null;
ResultSet rs   = null;

/* String connurl="jdbc:mariadb://localhost:3306/mars";
String user="mars";
String pwd="123123"; */
String query  = "select * from member where m_idx=?";

String m_idx=request.getParameter("m_idx");
if(m_idx==null || m_idx.equals("")||m_idx.equals("0"))
{
	%><script>
	alert("값을 가져오지 못 했습니다");
	location="memberList.jsp";
	</script>
	<%
}
else
{
try{
	DataBase dataBase=new DataBase();
	con=dataBase.getConnection();
	//System.out.println("Mariadb Connection 성공");
	
	pstmt = con.prepareStatement(query);
	pstmt.setInt(1, Integer.parseInt(request.getParameter("m_idx")));
	
	rs = pstmt.executeQuery();
	
	if(rs.next())
	{
		out.println("<h2>회원정보 뷰</h2>");
		out.println("<table>");
		out.println("<tr><td>시퀀스</td>");
		out.println("<td>"+rs.getInt("m_idx")+"</td></tr>");
		out.println("<tr><td>이름</td>");
		out.println("<td>"+rs.getString("m_name")+"</td></tr>");
		out.println("<tr><td>아이디</td>");
		out.println("<td>"+rs.getString("m_id")+"</td></tr>");
		out.println("<tr><td>비밀번호</td>");
		out.println("<td>"+rs.getString("m_pw")+"</td></tr>");
		out.println("<tr><td>이메일</td>");
		out.println("<td>"+rs.getString("m_email")+"</td></tr>");
		out.println("<tr><td>휴대폰번호</td>");
		out.println("<td>"+rs.getString("m_phone")+"</td></tr>");
		out.println("<tr><td>수정일</td>");
		out.println("<td>"+rs.getString("m_mdfydate")+"</td></tr>");
		out.println("<tr><td>등록일</td>");
		out.println("<td>"+rs.getString("m_rgstdate")+"</td></tr>");
		out.println("</table>");	
		
	}
	
}
finally
{
	con.close();
	pstmt.close();
	rs.close();
	System.out.println("연결 종료");
}
}
%>
<input type="button" onclick="back()" value="목록">
<input type="button" onclick="location='memberModify.jsp?m_idx=<%=rs.getInt("m_idx")%>'" value="수정">
<input type="button" onclick="userDelete(<%=rs.getInt("m_idx")%>, '<%=rs.getString("m_name")%>')" value="삭제">

</body>
</html>