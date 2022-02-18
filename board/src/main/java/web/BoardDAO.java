package web;

import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;

public class BoardDAO {

	public void create(BoardVO boardVo) throws Exception {
		System.out.println("boardVo:"+boardVo);
		
//		int m_idx = vo.getM_idx();
//		String id = vo.getId();
//		String pw = vo.getPw();
//		String name = vo.getName();
//		String tel = vo.getTel();

		String b_title = boardVo.getB_title();
		String b_content = boardVo.getB_content();
		String b_name = boardVo.getB_name();

		// db프로그램 순서
		// 1. connector 라이브러리 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. 드라이버 커넥터 설정 성공");
		// 2. db 연결 : 1) ip+port 2) user+pw 3)db명(big)
		String url = "jdbc:mysql://localhost:3366/big";
		String user = "root";
		String pass = "1234";

		Connection con = DriverManager.getConnection(url, user, pass);

		System.out.println("2. db연결 성공");
		// 3. sql문을 생성

		String sql = "insert into board(b_title,b_content, b_name, b_rgstdate) values (?,?,?,now())";

		// 쿼리를 객체 만들어줘야 함.(부품으로 그래야 서버에서 sql문 인식)
		// String ip = "210.125.88.9";
		// InetAddress i = Inet4Address.getByName(ip);
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL문 객체 생성 성공");
		ps.setString(1, b_title);
		ps.setString(2, b_content);
		ps.setString(3, b_name);

		// 4. 생성한 sql문을 mysql로 보낸다.
		ps.executeUpdate(); // 성공하면 1 실패하면 0
		System.out.println("4. SQL문 전송 성공");
		
	}
	
	public ResultSet board_list() throws Exception
	{
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String url = "jdbc:mysql://localhost:3366/big";
		String user = "root";
		String pass = "1234";
		String query="select * from board order by b_idx desc";

		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, user, pass);

		pstmt = con.prepareStatement(query);
		rs=pstmt.executeQuery();
		

		return rs;
	}
	
	public ResultSet board_view(int idx) throws Exception
	{
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String url = "jdbc:mysql://localhost:3366/big";
		String user = "root";
		String pass = "1234";
		String query="select * from board where b_idx=?";

		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, user, pass);

		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, idx);
		rs=pstmt.executeQuery();
		
		return rs;
	}
	
	public void update(BoardVO boardVo) throws Exception {
	      System.out.println("boardVo:"+boardVo);
	      int b_idx = boardVo.getB_idx();
	      String b_title = boardVo.getB_title();
	      String b_content = boardVo.getB_content();
	      
	      System.out.println("전달받은 b_idx는"+b_idx);
	      System.out.println("전달받은 b_title는" + b_title);
	      System.out.println("전달받은 b_content" + b_content);

	      System.out.println("회원가입 수정 요청됨.");

	      // db프로그램 순서
	      // 1. connector 라이브러리 설정
	      Class.forName("com.mysql.jdbc.Driver");
	      System.out.println("1. 드라이버 커넥터 설정 성공");
	      // 2. db 연결 : 1) ip+port 2) user+pw 3)db명(big)
	      String url = "jdbc:mysql://localhost:3366/big";
	      String user = "root";
	      String pass = "1234";

	      Connection con = DriverManager.getConnection(url, user, pass);

	      System.out.println("2. db연결 성공");
	      // 3. sql문을 생성

	      String sql = "update board set b_title = ?, b_content = ? where b_idx = ?";

	      // 쿼리를 객체 만들어줘야 함.(부품으로 그래야 서버에서 sql문 인식)
	      // String ip = "210.125.88.9";
	      // InetAddress i = Inet4Address.getByName(ip);
	      PreparedStatement ps = con.prepareStatement(sql);
	      System.out.println("3. SQL문 객체 생성 성공");
	      
	      ps.setString(1, b_title);
	      ps.setString(2, b_content);
	      ps.setInt(3, b_idx);

	      // 4. 생성한 sql문을 mysql로 보낸다.
	      ps.executeUpdate(); // 성공하면 1 실패하면 0
	      System.out.println("4. SQL문 전송 성공");

	      
	   }
	
		
	public void delete(int b_idx) throws Exception {
		      System.out.println("b_idx:"+b_idx);
		      
		      // 1. connector 라이브러리 설정
		      Class.forName("com.mysql.jdbc.Driver");
		      System.out.println("1. 드라이버 커넥터 설정 성공");
		      // 2. db 연결 : 1) ip+port 2) user+pw 3)db명(big)
		      String url = "jdbc:mysql://localhost:3366/big";
		      String user = "root";
		      String pass = "1234";

		      Connection con = DriverManager.getConnection(url, user, pass);

		      System.out.println("2. db연결 성공");
		      // 3. sql문을 생성

		      String sql = "delete from board where b_idx = ?";

		      PreparedStatement ps = con.prepareStatement(sql);
		      System.out.println("3. SQL문 객체 생성 성공");
		      ps.setInt(1, b_idx);

		      // 4. 생성한 sql문을 mysql로 보낸다.
		      ps.executeUpdate(); // 성공하면 1 실패하면 0
		      System.out.println("4. SQL문 전송 성공");

		   }	
}
