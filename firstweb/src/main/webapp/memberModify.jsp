<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="firstweb.DataBase" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<style>
	td
	{
    	text-align: center;
    	border: 1px solid #444444;
    }
</style>
<script>
	function update()
	{
		var form=document.form;
		
		if(form.m_name.value=='')
		{
			alert("이름을 입력해주세요.");
			return;
		}
		
		if(form.m_id.value=='')
		{
			alert("아이디를 입력해주세요.");
			return;
		}	
		
		if(form.m_pw.value=='')
		{
			alert("비밀번호를 입력해주세요.");
			return;
		}	
		
		if(form.m_email.value=='')
		{
			alert("이메일을 입력해주세요.");
			return;
		}	
		
		if(form.m_phone.value=='')
		{
			alert("휴대폰번호 입력해주세요.");
			return;
		}	
		
		if(confirm("수정하시겠습니까?"))
		{
			form.submit();
		}
	}

	function cancel()
	{
		//history.back();
		history.go(-1);
	}
</script>
</head>
<body>
<%
Connection con=null;
PreparedStatement pstmt  = null;
ResultSet rs   = null;

String query  = "select * from member where m_idx=?";

try{
	DataBase dataBase=new DataBase();
	con=dataBase.getConnection();
	//System.out.println("Mariadb Connection 성공");
	
	pstmt = con.prepareStatement(query);
	pstmt.setInt(1, Integer.parseInt(request.getParameter("m_idx")));
	
	rs = pstmt.executeQuery();
	
	if(rs.next())
	{	
%>
<form action="memberUpdate.jsp" method="post" name="form">
	<h2>회원정보 수정</h2>	
	<table>
		<tr>
			<td>시퀀스</td>
			<td><input type="text" name="m_idx" value=<%=rs.getInt("m_idx")%> readonly></td>
		</tr>	
		<tr>
			<td>이름</td>
			<td><input type="text" name="m_name" value=<%=rs.getString("m_name")%>></td>
		</tr>	
		<tr>
			<td>아이디</td>
			<td><input type="text" name="m_id" value=<%=rs.getString("m_id")%>></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="m_pw" value=<%=rs.getString("m_pw")%>></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="m_email" value=<%=rs.getString("m_email")%>></td>
		</tr>
		<tr>
			<td>휴대폰번호</td>
			<td><input type="text" name="m_phone" value=<%=rs.getString("m_phone")%>></td>
		</tr>
	</table>
	<input type="button" onclick="update()" value="확인">
	<input type="button" onclick="cancel()" value="취소">
	</form>
<%
	}
	
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