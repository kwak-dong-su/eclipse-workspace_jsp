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

/**
 * @author hi
 *
 * ȸ������ ������ �����ϴ� Action
 */
@WebServlet("/memberSave")
public class MemberSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8;");
		
		HttpSession session=request.getSession();
		
		//---Parameter �Ѿ�� ȸ������ ������ MemberVO Ŭ������ ����
		MemberDAO memberDAO=new MemberDAO();
		MemberVO memberVo=new MemberVO();
		memberVo.setM_name(request.getParameter("m_name"));
		memberVo.setM_id(request.getParameter("m_id"));
		memberVo.setM_pw(request.getParameter("m_pw"));
		memberVo.setM_email(request.getParameter("m_email"));
		memberVo.setM_phone(request.getParameter("m_phone"));
		memberVo.setM_file(request.getParameter("m_file"));
		
		//--- ȸ������ ������ DB�� ����
		memberDAO.member_save(memberVo);
		
		session.setAttribute("user_id", memberVo.getM_id());
		session.setAttribute("user_name", memberVo.getM_name());
		session.setAttribute("user_idx", memberVo.getM_idx());
		
		PrintWriter out=response.getWriter();

		out.println("<script>");
		out.println("alert('"+memberVo.getM_name()+"���� ȸ������ �Ǿ����ϴ�.')");
		out.println("location='"+request.getContextPath()+"/memberList'");
		out.println("</script>");
		
	}

}
