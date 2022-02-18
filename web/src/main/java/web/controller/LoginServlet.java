package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dao.LoginDAO;
import web.dao.MemberDAO;
import web.vo.MemberVO;

/**
 * ȸ�� ������ Ȯ���ؼ� ���̵�� ��й�ȣ�� ����ϴ� ȸ���� ã��
 * �α��� ������ �ִ� Action
 * �α��� ���� session�� ���̵�� �̸��� �����ϴ� ȸ������ �Ѵ�.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//session ������ �����´�.
		HttpSession session=request.getSession();
		
		request.setCharacterEncoding("utf-8");
		
		//login.html ���Ͽ��� �Ѿ�� �Ķ���͸� ����
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
		
		//�α��� ó���� �ϴ� �Լ� ����
		LoginDAO loginDAO=new LoginDAO();
		
		//�α��� Ȯ��
		int m_idx=loginDAO.login(user_id, user_pw);
		
		//�������� ȸ�������� ����
		if(m_idx>0)
		{
			MemberDAO memberDAO=new MemberDAO();
			
			//-- ȸ�������� ������
			MemberVO memberVo=memberDAO.member_view(m_idx);
			
			//-- session�� �α����� ȸ������ ǥ��
			session.setAttribute("user_id", memberVo.getM_id());
			session.setAttribute("user_name", memberVo.getM_name());
			session.setAttribute("user_idx", memberVo.getM_idx());
			response.sendRedirect("memberList");
		}
		else //���̵�� ��й�ȣ�� ���� ȸ���� ����
		{
			response.sendRedirect("login.html");
		}
		
	}

}
