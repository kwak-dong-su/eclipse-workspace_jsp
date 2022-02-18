<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="java.sql.*" %>
<%@ page import="firstweb.DataBase" %>
<%

Connection con=null;
PreparedStatement st=null;
ResultSet rs=null;
String query="select m_id from member where m_id=?";
String m_id=request.getParameter("m_id");
int checked=0;

DataBase dataBase=new DataBase();
con=dataBase.getConnection();

st=con.prepareStatement(query);
st.setString(1, m_id);
rs=st.executeQuery();


if(rs.next())
{
	System.out.println("중복된 아이디 확인됨");
    checked=1;
}


if(checked==1)
    out.print("true");
if(checked==0)
    out.print("false");
    
    
con.close();
st.close();
rs.close();
%>
