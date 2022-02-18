<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="web.MemberDAO"%>
<%@page import="web.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String user_id = ""; 
    String user_pw = ""; 
    
       if(request.getParameter("user_id")==""){%>
          <script>
             alert('아이디를 입력하세요.'); 
             location.href = "/addmember.html"
          </script>
       <% }
       else if(request.getParameter("user_pw")==""){%>
          <script>
             alert("비밀번호를 입력하세요"); 
             location.ref = "/addmember.html"
          </script>
       <% }
       else{
          user_id = request.getParameter("user_id"); //id값 가져오기. 
          user_pw = request.getParameter("user_pw"); //pw값 가져오기.
       
          // 1. connector 라이브러리 설정
          Connection conn = null; 
           Class.forName("com.mysql.jdbc.Driver");
           System.out.println("1. 드라이버 커넥터 설정 성공");
           // 2. db 연결 : 1) ip+port 2) user+pw 3)db명(big)
           String url = "jdbc:mysql://localhost:3366/big";
           String user = "root";
           String pass = "1234";
   
           conn = DriverManager.getConnection(url, user, pass);
           System.out.println("2. db연결 성공");
          PreparedStatement pstmt = conn.prepareStatement("select * from member where id ='"+user_id+"' and pw = '"+user_pw+"'");
          System.out.println("3. SQL문 객체 생성 성공");
          ResultSet rs = pstmt.executeQuery();
          
       System.out.println("4. SQL문 전송 성공");

       Boolean check = false; //로그인 체크 
      while(rs.next()){
         String id = rs.getString("id"); //DB에 있는 ID 가져옴. 
         session.setAttribute("user_id", id); //DB값을 세션에 넣음.
         check = true; 
      }
          if(check){//id와 pw가 db에 존재하는 경우 게시판으로 이동하는 코드 
             %>
             <script>
             location.href = "boardlist.jsp"
             </script>
             <% 
             rs.close(); 
             conn.close(); 
                }else{
             %>
             <script>
              alert("ID 또는 PW를 잘못 입력했습니다."); 
              location.href = "addmember.html"
              </script>
              <% 
          }
          
       }
       %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>