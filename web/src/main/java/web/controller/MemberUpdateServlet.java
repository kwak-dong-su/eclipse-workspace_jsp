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
import web.vo.MemberVO;


@WebServlet("/memberUpdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8;");
		
		
		
		
		MemberDAO memberDAO=new MemberDAO();
		MemberVO memberVo=new MemberVO();
		memberVo.setM_idx(Integer.parseInt(request.getParameter("m_idx")));
		memberVo.setM_name(request.getParameter("m_name"));
		memberVo.setM_pw(request.getParameter("m_pw"));
		memberVo.setM_email(request.getParameter("m_email"));
		memberVo.setM_phone(request.getParameter("m_phone"));
		
		memberDAO.member_update(memberVo);
		
		if(session.getAttribute("user_idx").equals(memberVo.getM_idx()))
		{
			session.setAttribute("user_name", memberVo.getM_name());
		}
				
		PrintWriter out=response.getWriter();

		out.println("<script>");
		out.println("alert('"+memberVo.getM_name()+"님의 정보가 수정되었습니다.')");
		out.println("location='"+request.getContextPath()+"/memberView?m_idx="+request.getParameter("m_idx")+"';");
		out.println("</script>");
	}

}
