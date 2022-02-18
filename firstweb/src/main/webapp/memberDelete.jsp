<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="firstweb.DataBase" %>

<%

Connection con=null;
PreparedStatement st=null;
ResultSet rs=null;
String query="delete from member where m_idx=?";

DataBase dataBase=new DataBase();
con=dataBase.getConnection();


request.setCharacterEncoding("utf-8");

//---데이터를 얻어오는 쿼리
query="select m_name from member where m_idx=?";
st=con.prepareStatement(query);
st.setInt(1,Integer.parseInt(request.getParameter("m_idx")));
rs=st.executeQuery();

if(rs.next())
{
	rs.getString("m_name");
}

st.close();
rs.close();

//---데이터 삭제 쿼리
query="delete from member where m_idx=?";
st=con.prepareStatement(query);
st.setInt(1,Integer.parseInt(request.getParameter("m_idx")));

if(st.executeUpdate()>0)
{
	%>
	<script>
		alert("<%=request.getParameter("m_name")%> 회원이 삭제되었습니다.");
		location="memberList.jsp";
	</script>
	<%
}
else
{
	%>
	<script>
		alert("삭제 실패");
		location="memberList.jsp";
	</script>
	<%
}


con.close();
st.close();

%>