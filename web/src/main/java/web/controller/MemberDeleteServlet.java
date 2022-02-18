package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.MemberDAO;


@WebServlet("/memberDelete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8;");
		
		HttpSession session=request.getSession();
		
		MemberDAO memberDAO=new MemberDAO();
		memberDAO.member_delete(Integer.parseInt(request.getParameter("m_idx")));	
		
		if(session.getAttribute("user_name").equals(request.getParameter("m_name")))
		{
			session.invalidate();
		}
		
		PrintWriter out=response.getWriter();

		out.println("<script>");
		out.println("alert('ȸ���� �����Ǿ����ϴ�.')");
		out.println("location='"+request.getContextPath()+"/memberList'");
		out.println("</script>");
		
		
	}

}
