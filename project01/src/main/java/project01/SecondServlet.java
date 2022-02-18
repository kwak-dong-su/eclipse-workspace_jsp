package project01;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet
{
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
