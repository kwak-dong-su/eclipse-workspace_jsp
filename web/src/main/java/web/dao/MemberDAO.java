package web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.vo.*;

/**
 * 
 * @author hi
 *
 * Member Database Access Object
 * 
 * <Resource name="jdbc/mariadb"
    	      auth="Container"
    	      type="javax.sql.DataSource"
    	      driverClassName="org.mariadb.jdbc.Driver"
    	      url="jdbc:mariadb://localhost:3306/mars"
    	      username="mars"
    	      password="123123"
    	      maxActive="50"
    	      maxWait="-1"/>
    	      
     Servers폴더의 context.xml 하단에 작성
 */
public class MemberDAO 
{
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private DataSource dataFactory;
	
	public MemberDAO()
	{
		try 
		{
			Context ctx=new InitialContext();
			Context envContext=(Context)ctx.lookup("java:/comp/env");
			dataFactory=(DataSource)envContext.lookup("jdbc/mariadb");
			
		} catch (NamingException e)
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * generic 표기법
	 * 내가 원하는 객체를 리스트에 담으려고 확정을 짓기 위해 사용
	 * 회원의 목록을 가져오는 함수
	 * @return
	 */
	public List<MemberVO> member_list()
	{
		
		List<MemberVO> list=new ArrayList<MemberVO>();
		//----member를 select해서 MemberVO 객체에 데이터를 담은 후 List에 하나씩 추가한다.
		
		String query="select * from member";
		try {
			con=dataFactory.getConnection();
			pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				MemberVO memberVo=new MemberVO();
				memberVo.setM_idx(rs.getInt("m_idx"));
				memberVo.setM_id(rs.getString("m_id"));
				memberVo.setM_pw(rs.getString("m_pw"));
				memberVo.setM_name(rs.getString("m_name"));
				memberVo.setM_email(rs.getString("m_email"));
				memberVo.setM_phone(rs.getString("m_phone"));
				memberVo.setM_mdfydate(rs.getTimestamp("m_mdfydate"));
				memberVo.setM_rgstdate(rs.getTimestamp("m_rgstdate"));
				list.add(memberVo);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		
		return list;
	}
	
	/**
	 *  회원시퀀스에 해당하는 회원정보를 하나 가져오는 함수
	 *  @return
	 */
	public MemberVO member_view(int m_idx)
	{
		MemberVO memberVo=new MemberVO();
		
		//--사용할 쿼리
		String query="select * from member where m_idx=?";
		
		try {
			//-- connection 처리
			con=dataFactory.getConnection();
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, m_idx);
			rs=pstmt.executeQuery(); //쿼리를 수행하고 결과를 ResultSet에 저장
			
			if(rs.next())
			{
				memberVo.setM_idx(rs.getInt("m_idx"));
				memberVo.setM_id(rs.getString("m_id"));
				memberVo.setM_pw(rs.getString("m_pw"));
				memberVo.setM_name(rs.getString("m_name"));
				memberVo.setM_email(rs.getString("m_email"));
				memberVo.setM_phone(rs.getString("m_phone"));
				memberVo.setM_mdfydate(rs.getTimestamp("m_mdfydate"));
				memberVo.setM_rgstdate(rs.getTimestamp("m_rgstdate"));
				memberVo.setM_file(rs.getString("m_file"));
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
		
		
		return memberVo;
	}

	/**
	 * @param memberVo
	 * 
	 * 회원정보 저장
	 */
	public void member_save(MemberVO memberVo) {
		
		String query="insert into member(m_name, m_id, m_pw, m_email, m_phone, m_rgstdate, m_file) "
				+"values(?,?,?,?,?, now(), ?)";
		
		try {
			
			con=dataFactory.getConnection();
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, memberVo.getM_name());
			pstmt.setString(2, memberVo.getM_id());
			pstmt.setString(3, memberVo.getM_pw());
			pstmt.setString(4, memberVo.getM_email());
			pstmt.setString(5, memberVo.getM_phone());
			pstmt.setString(6, memberVo.getM_file());
			
			pstmt.executeUpdate();
			
			
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
		
	}
	
	/**
	 *  사용이 가능한 아이디인지 확인
	 * @param check_id
	 * @return
	 */
	public String check_id(String check_id)
	{
		String result="false";
		
		String query="select m_idx from member where m_id=?";	
		try {
			
			con=dataFactory.getConnection();
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, check_id);	
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				result="true";
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
		
		return result;
	}

	/**
	 *  회원정보 수정
	 * @param memberVo
	 */
	public void member_update(MemberVO memberVo) {
		
		String query="update member set m_name=?, m_pw=?, m_email=?, "
				+ "m_phone=?, m_mdfydate=now() where m_idx=?";
		
		try {
			
			con=dataFactory.getConnection();
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, memberVo.getM_name());
			pstmt.setString(2, memberVo.getM_pw());
			pstmt.setString(3, memberVo.getM_email());
			pstmt.setString(4, memberVo.getM_phone());
			pstmt.setInt(5, memberVo.getM_idx());
			
			pstmt.executeUpdate();
			
			
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
		
	}

	/**
	 * 회원정보 삭제
	 * @param m_idx
	 */
	public void member_delete(int m_idx) {
		
		String query="delete from member where m_idx=?";
		
		try {
			
			con=dataFactory.getConnection();
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, m_idx);
			
			pstmt.executeUpdate();
			
			
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
	}
}
