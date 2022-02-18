package project01;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Third2Servlet extends HttpServlet
{
	
	//private static final long serialVersionUID = 4203167342058536067L;

	public void init() throws ServletException
	{
		LocalDateTime now=LocalDateTime.now();
		System.out.println("init �޼ҵ� ȣ�� "+now);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		LocalDateTime now=LocalDateTime.now();
		System.out.println("doGet �޼ҵ� ȣ�� "+now);
	}
	
	public void destroy()
	{
		LocalDateTime now=LocalDateTime.now();
		System.out.println("destroy �޼ҵ� ȣ�� "+now);
	}

}
