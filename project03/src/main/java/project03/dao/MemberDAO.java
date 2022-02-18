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
	 * generic ǥ���
	 * ���� ���ϴ� ��ü�� ����Ʈ�� �������� Ȯ���� ���� ���� ���
	 * ȸ���� ����� �������� �Լ�
	 * @return
	 */
	public List<MemberVO> member_list()
	{
		
		List<MemberVO> list=new ArrayList<MemberVO>();
		con=database.getConnection();
		//----member�� select�ؼ� MemberVO ��ü�� �����͸� ���� �� List�� �ϳ��� �߰��Ѵ�.
		
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
