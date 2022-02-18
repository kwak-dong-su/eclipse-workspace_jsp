<%@ page import="java.sql.*" %>
<%@ page import="firstweb.DataBase" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberList</title>
<script>
	function search()
	{
		var form=document.form;
		
		if(form.searchValue.value=='')
			{
				alert("검색어를 입력해주세요.");
				return;
			}	
		if(confirm("검색하시겠습니까?"))
			{
				form.submit();
			}
	}
	
	function insert()
	{
		location="member.html";
	}
</script>
<style>
	table
	{
		width: 100%;
		border-top: 1px solid #444444;
		border-collapse: collapse;
	}
	th, td
	{
		border-bottom: 1px solid #444444;
		padding: 10px;
	}
</style>
</head>
<body>
<h2>멤버 리스트</h2>

<%!
 //전역변수
%>
<%

Connection con=null;
PreparedStatement pstmt  = null;
ResultSet rs   = null;

/* String connurl="jdbc:mariadb://localhost:3306/mars";
//String connurl="jdbc:postgresql://localhost:5432/mars";
String user="mars";
String pwd="123123"; */
//String query  = "select * from member";
String query  = "select * from member where m_name like ? order by m_idx desc";
String searchValue="";

try{
	
	/* //Class.forName("org.postgresql.Driver");
	Class.forName("org.mariadb.jdbc.Driver");
	out.println("Mariadb 드라이버 로딩"); */
	
	DataBase dataBase=new DataBase();
	con=dataBase.getConnection();
	//System.out.println("Mariadb Connection 성공");
	
	
	
	pstmt = con.prepareStatement(query);
	
	if(request.getParameter("searchValue")!=null)
	{	
		searchValue=request.getParameter("searchValue");
		pstmt.setString(1, "%"+searchValue+"%");
	}
	else
	{
		pstmt.setString(1, "%");
	}
	
	rs = pstmt.executeQuery();

%>
<form action="memberList.jsp" name="form">
	<input type="text" name="searchValue" value=<%=searchValue%>>
	<input type="button" onclick="search()" value="검색">
	<input type="button" onclick="insert()" value="회원가입">
</form>
<table>
	<tr>
		<td>시퀀스</td>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>이메일</td>
		<td>휴대폰번호</td>
		<td>수정일</td>
		<td>등록일</td>
	</tr>
	<%
		while(rs.next())
		{
			out.println("<tr>");
			out.println("<td>"+rs.getInt("m_idx")+"</td>");
			out.println("<td>"+rs.getString("m_id")+"</td>");
			out.println("<td>"+rs.getString("m_pw")+"</td>");
			out.println("<td><a href='memberView.jsp?m_idx="+rs.getInt("m_idx")+"'>"+rs.getString("m_name")+"</a></td>");
			out.println("<td>"+rs.getString("m_email")+"</td>");
			out.println("<td>"+rs.getString("m_phone")+"</td>");
			out.println("<td>"+rs.getString("m_mdfydate")+"</td>");
			out.println("<td>"+rs.getString("m_rgstdate")+"</td>");
			out.println("</tr>");
			
		}
		System.out.println("rs값 출력");
	%>
</table>
<%
}
finally
{
	con.close();
	pstmt.close();
	rs.close();
	System.out.println("연결 종료");
}
%>
</body>
</html>