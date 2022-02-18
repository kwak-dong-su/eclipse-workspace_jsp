package web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.MemberDAO;
import web.vo.MemberVO;

@WebServlet("/memberModify")
public class MemberModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8;");
		
		HttpSession session=request.getSession();
		
		if(session.getAttribute("user_id")==null)
		{
			response.sendRedirect("login.html");
		}
		else
		{
			MemberDAO memberDAO=new MemberDAO();
			MemberVO memberVo=new MemberVO();
			memberVo=memberDAO.member_view(Integer.parseInt(request.getParameter("m_idx")));
			
			request.setAttribute("member", memberVo);
			
			RequestDispatcher dispatch=request.getRequestDispatcher("/WEB-INF/jsp/memberModify.jsp");
			dispatch.forward(request, response);
		}
		
	}

}
