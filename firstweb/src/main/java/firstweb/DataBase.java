package firstweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

	private Connection con;
	public DataBase()
	{
		try 
		{
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Mariadb 드라이버 로딩");
			
			String connurl="jdbc:mariadb://localhost:3306/mars";
			//String connurl="jdbc:mysql://13.124.207.246:55091/mars";
			String user="mars";
			String pwd="123123";
					
			con=DriverManager.getConnection(connurl, user, pwd);
			System.out.println("Mariadb Connection 성공");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public Connection getConnection()
	{
		return con;
	}
}
