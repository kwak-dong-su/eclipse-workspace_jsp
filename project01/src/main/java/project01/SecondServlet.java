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
		System.out.println("init 메소드 호출 "+now);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		LocalDateTime now=LocalDateTime.now();
		System.out.println("doGet 메소드 호출 "+now);
	}
	
	public void destroy()
	{
		LocalDateTime now=LocalDateTime.now();
		System.out.println("destroy 메소드 호출 "+now);
	}

}
