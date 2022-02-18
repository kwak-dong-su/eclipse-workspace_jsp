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
 *�α��� �����ؼ� ó���ϴ� Class
 */
public class LoginDAO 
{
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private DataSource dataFactory;
	//DB Connection Pool���� connection ������(JNDI)
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
	 * ���̵� �н������ �ش� ȸ���� �ִ��� ã�� �Լ�
	 * �������� ��ȯ�ؼ� ȸ�������� ó��
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
			//������ �Է°� �߰�
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pw);
			rs=pstmt.executeQuery(); //������ �����ϰ� ������� ResultSet�� ����
			
			if(rs.next()) //�˻��� ���� �ִ��� Ȯ��
			{
				m_idx=rs.getInt("m_idx"); //�˻��� ������ ����
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
