package com.hi.mvc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {

	public void create(BookVO vo) throws Exception {
		System.out.println("dao에서 전달받은 값:" + vo);
		String id2 = vo.getId();
		String name2 = vo.getName();
		String url2 = vo.getUrl();
		String img2 = vo.getImg();
		
		
		System.out.println("사이트 등록 처리 요청됨.");
		
		//db프로그램 순서
		//1. connector라이브러리 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. 드라이버/커넥터 설정 성공@@@");
		
		//2. db 연결 : 1) ip+port, 2) user+pw, 3)db명(big)
		String url = "jdbc:mysql://localhost:3366/big";
		String user = "root";
		String pass = "1234";
		
		Connection con = DriverManager.getConnection(url, user, pass);
		
		System.out.println("2. db연결 성공@@@");
		
		//3. sql문을 생성
		String sql = "insert into book values (?, ?, ?, ?)";

		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL객체 생성 성공.@@@");
		ps.setString(1, id2);
		ps.setString(2, name2);
		ps.setString(3, url2);
		ps.setString(4, img2);
		
		//4. 생성한 sql문을 mysql로 보낸다.
		ps.executeUpdate();
		System.out.println("4. SQL문 전송 성공.@@@");
	}
	
	public void update(BookVO vo) throws Exception {
		
		String id2 = vo.getId();
		String name2 = vo.getName();
		String url2 = vo.getUrl();
		String img2 = vo.getImg();
		
		
		//db프로그램 순서
		//1. connector라이브러리 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. 드라이버/커넥터 설정 성공@@@");
		
		//2. db 연결 : 1) ip+port, 2) user+pw, 3)db명(big)
		String url = "jdbc:mysql://localhost:3366/big";
		String user = "root";
		String pass = "1234";
		
		Connection con = DriverManager.getConnection(url, user, pass);
		
		System.out.println("2. db연결 성공@@@");
		
		//3. sql문을 생성
		String sql = "update book set name = ? where id = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL객체 생성 성공.@@@");
		ps.setString(1, name2);
		ps.setString(2, id2);

		
		//4. 생성한 sql문을 mysql로 보낸다.
		ps.executeUpdate();
		System.out.println("4. SQL문 전송 성공.@@@");
	}
	
	public void delete(BookVO vo) throws Exception {
		System.out.println("회원탈퇴 처리 요청됨.");
		System.out.println("dao에서 전달받은 값:" + vo);
		String id2 = vo.getId();
		String name2 = vo.getName();
		String url2 = vo.getUrl();
		String img2 = vo.getImg();
		
		
		
		//db프로그램 순서
		//1. connector라이브러리 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. 드라이버/커넥터 설정 성공@@@");
		
		//2. db 연결 : 1) ip+port, 2) user+pw, 3)db명(big)
		String url = "jdbc:mysql://localhost:3366/big";
		String user = "root";
		String pass = "1234";
		
		Connection con = DriverManager.getConnection(url, user, pass);
		
		System.out.println("2. db연결 성공@@@");
		
		//3. sql문을 생성
		String sql = "delete from book where id = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL객체 생성 성공.@@@");
		ps.setString(1, id2);

		
		//4. 생성한 sql문을 mysql로 보낸다.
		ps.executeUpdate();
		System.out.println("4. SQL문 전송 성공.@@@");
	}
	
	public ArrayList<BookVO> readAll() throws Exception {
		System.out.println("회원전체 목록 검색 처리 요청됨.");
		
		//db프로그램 순서
		//1. connector라이브러리 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. 드라이버/커넥터 설정 성공@@@");
		
		//2. db 연결 : 1) ip+port, 2) user+pw, 3)db명(big)
		String url = "jdbc:mysql://localhost:3366/big";
		String user = "root";
		String pass = "1234";
		
		Connection con = DriverManager.getConnection(url, user, pass);
		
		System.out.println("2. db연결 성공@@@");
		
		//3. sql문을 생성
		String sql = "select * from book";

		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL객체 생성 성공.@@@");
		
		//4. 생성한 sql문을 mysql로 보낸다.
		ResultSet rs = ps.executeQuery();
		//System.out.println("결과값 있는지 체크 결과는 >>" + rs.next());
		System.out.println("4. SQL문 전송 성공.@@@");
		//가방들을 모을 저장공간을 만들어야 함.
		//배열은 적합하지 않음.
		//MemberVO[] list = new MemberVO[10]();
		//가변적인 저장공간이 필요.
		ArrayList<BookVO> list = new ArrayList<>();
		while(rs.next()) {
			BookVO vo2 = new BookVO();
			String id2 = rs.getString("id");
			String name2 = rs.getString("name");
			String url2 = rs.getString("url");
			String img2 = rs.getString("img");
			vo2.setId(id2);
			vo2.setName(name2);
			vo2.setUrl(url2);
			vo2.setImg(img2);
			list.add(vo2);
		}
		return list;
		
	}
}
