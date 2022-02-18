package project03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project03.db.DataBase;
import project03.vo.MemberVO;

/**
 * 
 * @author hi
 *
 * Member Database Access Object
 */
public class MemberDAO 
{
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private DataBase database=null;
	public MemberDAO()
	{
		database=new DataBase();
		
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
		con=database.getConnection();
		//----member를 select해서 MemberVO 객체에 데이터를 담은 후 List에 하나씩 추가한다.
		
		String query="select * from member";
		try {
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
	
	
}
