package web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 
 * @author hi
 *
 *로그인 관련해서 처리하는 Class
 */
public class LoginDAO 
{
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private DataSource dataFactory;
	//DB Connection Pool에서 connection 얻어오기(JNDI)
	public LoginDAO()
	{
		try 
		{
			Context ctx=new InitialContext();
			Context envContext=(Context)ctx.lookup("java:/comp/env");
			dataFactory=(DataSource)envContext.lookup("jdbc/mariadb");
			
		} 
		catch (NamingException e)
		{
			e.printStackTrace();
		}
	
	}
	
	/**
	 * 아이디 패스워드로 해당 회원이 있는지 찾는 함수
	 * 시퀀스를 반환해서 회원정보를 처리
	 * @param user_id
	 * @param user_pw
	 * @return
	 */
	public int login(String user_id, String user_pw)
	{
		int m_idx=0;
		String query="select m_idx from member where m_id=? and m_pw=?";
		
		try {
			con=dataFactory.getConnection();
			pstmt=con.prepareStatement(query);
			//쿼리에 입력값 추가
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pw);
			rs=pstmt.executeQuery(); //쿼리를 수행하고 결과값을 ResultSet에 저장
			
			if(rs.next()) //검색된 값이 있는지 확인
			{
				m_idx=rs.getInt("m_idx"); //검색된 시퀀스 저장
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		finally
		{
			try {
				if(con!=null)
				{
					con.close();
				}
				
				if(pstmt!=null)
				{
					pstmt.close();
				}
				
				if(rs!=null)
				{
					rs.close();
				}
				
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return m_idx;
	}
}
