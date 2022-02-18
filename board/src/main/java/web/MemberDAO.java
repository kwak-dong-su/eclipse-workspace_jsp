package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

	// DAO:Data Access Object
	// CRUD(크루드)
	// 회원가입(Create)
	// 회원정보검색, 로그인(Read)
	// 회원정보수정 (Update)
	// 회원탈퇴 (Delete)

	public void create(MemberVO vo) throws Exception {
		System.out.println("vo에서 전달받은 값:" + vo);
		int m_idx = vo.getM_idx();
		String id = vo.getId();
		String pw = vo.getPw();
		String name = vo.getName();
		String tel = vo.getTel();

		
		System.out.println("전달받은 m_idx는"+m_idx);
		System.out.println("전달받은 id는" + id);
		System.out.println("전달받은 pw는" + pw);
		System.out.println("전달받은 name은" + name);
		System.out.println("전달받은 tel는" + tel);

		System.out.println("회원가입 처리 요청됨.");

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

		String sql = "insert into big.member(id,pw,name,tel) values (?,?,?,?)";

		// 쿼리를 객체 만들어줘야 함.(부품으로 그래야 서버에서 sql문 인식)
		// String ip = "210.125.88.9";
		// InetAddress i = Inet4Address.getByName(ip);
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL문 객체 생성 성공");
		ps.setString(1, id);
		ps.setString(2, pw);
		ps.setString(3, name);
		ps.setString(4, tel);

		// 4. 생성한 sql문을 mysql로 보낸다.
		ps.executeUpdate(); // 성공하면 1 실패하면 0
		System.out.println("4. SQL문 전송 성공");

	}

	public void login(MemberVO vo) {
		System.out.println("회원 로그인 처리 요청됨.");
	}

	public void read(MemberVO vo) {
		System.out.println("회원가입 검색 처리 요청됨.");
	}

	public void update(MemberVO vo) throws Exception {
		System.out.println("회원가입 업데이트 처리 요청됨.");

		System.out.println("vo에서 전달받은 값:" + vo);
		String id = vo.getId();
		String tel = vo.getTel();

		System.out.println("전달받은 id는" + id);
		System.out.println("전달받은 tel는" + tel);

		System.out.println("회원정보 업데이트 처리 요청됨.");

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

		String sql = "update member set tel=? where id=?";

		// 쿼리를 객체 만들어줘야 함.(부품으로 그래야 서버에서 sql문 인식)
		// String ip = "210.125.88.9";
		// InetAddress i = Inet4Address.getByName(ip);
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL문 객체 생성 성공");
		ps.setString(1, tel);
		ps.setString(2, id);

		// 4. 생성한 sql문을 mysql로 보낸다.
		ps.executeUpdate(); // 성공하면 1 실패하면 0
		System.out.println("4. SQL문 전송 성공");

	}

	public void delete(MemberVO vo) throws Exception {
		System.out.println("회원삭제 처리 요청됨.");

		System.out.println("vo에서 전달받은 값:" + vo);
		String id = vo.getId();

		System.out.println("전달받은 id는" + id);

		System.out.println("회원삭제 처리 요청됨.");

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

		String sql = "delete from member where id=?";

		// 쿼리를 객체 만들어줘야 함.(부품으로 그래야 서버에서 sql문 인식)
		// String ip = "210.125.88.9";
		// InetAddress i = Inet4Address.getByName(ip);
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL문 객체 생성 성공");
		ps.setString(1, id);

		// 4. 생성한 sql문을 mysql로 보낸다.
		ps.executeUpdate(); // 성공하면 1 실패하면 0
		System.out.println("4. SQL문 전송 성공");

	}
	
	public ResultSet memberList(int idx) throws Exception
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String url = "jdbc:mysql://localhost:3366/big";
		String user = "root";
		String pass = "1234";
		String query="select * from member where m_idx=?";

		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, user, pass);

		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, idx);
		rs=pstmt.executeQuery();
		
		return rs;
	}

}
