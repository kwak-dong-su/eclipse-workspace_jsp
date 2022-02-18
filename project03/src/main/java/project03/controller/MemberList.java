package project03.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project03.dao.MemberDAO;
import project03.vo.MemberVO;

@WebServlet("/memberList")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		MemberDAO memberDAO=new MemberDAO();
		List<MemberVO> list=memberDAO.member_list();
		
		String data="<html>";
		data+="<style>";
		data+="table{";
		data+="width:100%;";
		data+="border-top: 1px solid #444444;";
		data+="border-collapse: collapse;";
		data+="}";
		data+="th, td {";
		data+="border-bottom: 1px solid #444444;";
		data+="padding: 10px;";
		data+="}";
		data+="</style>";
		
		data+="<body>";
		data+="<table>";
		data+="<tr>";
		data+="<td>������</td>";
		data+="<td>�̸�</td>";
		data+="<td>���̵�</td>";
		data+="<td>��й�ȣ</td>";
		data+="<td>�̸���</td>";
		data+="<td>�޴�����ȣ</td>";
		data+="<td>������</td>";
		data+="<td>�����</td>";	
		data+="</tr>";
		for(int i=0;i<list.size();i++)
		{
			MemberVO memberVO=(MemberVO)list.get(i);
			data+="<tr>";
			data+="<td>"+memberVO.getM_idx()+"</td><td>"+memberVO.getM_name()+"</td>";
			data+="<td>"+memberVO.getM_id()+"</td><td>"+memberVO.getM_pw()+"</td>";
			data+="<td>"+memberVO.getM_email()+"</td><td>"+memberVO.getM_phone()+"</td>";
			data+="<td>"+memberVO.getM_mdfydate()+"</td><td>"+memberVO.getM_rgstdate()+"</td>";
			data+="</tr>";
		}
		data+="</table>";
		data+="</body>";
		data+="</html>";
		out.print(data);
		
		
	}

}
