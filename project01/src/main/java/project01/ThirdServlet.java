package project01;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet
{
	//�ڹ� ��ü ����ȭ �ĺ���
	//private static final long serialVersionUID = 4203167342058536067L;

	
	public void init() throws ServletException 
	{ 
		LocalDateTime now=LocalDateTime.now(); 
		System.out.println("init �޼ҵ� ȣ�� "+now); 
	}
	 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doHandle(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		LocalDateTime now=LocalDateTime.now();
		System.out.println("doHandle �޼ҵ� ȣ�� "+now);
	}
	
	
	public void destroy() 
	{ 
		 LocalDateTime now=LocalDateTime.now();
		 System.out.println("destroy �޼ҵ� ȣ�� "+now); 
	}
	 

}
