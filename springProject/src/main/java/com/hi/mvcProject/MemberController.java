package com.hi.mvcProject;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //스프링 프레임워크에 컨트롤러 역할의 클래스로 등록
public class MemberController {
	
	@Autowired
	MemberDAO dao; //주소 주입
	//회원과 관련된 여러가지 제어를 담당하는 클래스
	//회원가입, 검색, 수정, 탈퇴, 로그인 기능을 제어함.
	
	@RequestMapping("check")
	public String login(MemberVO vo, HttpSession session) throws Exception 
	{
		System.out.println(vo);
		MemberVO vo2 = dao.login(vo);
		System.out.println(vo2);
		//vo2가 로그인에 실패한 경우 null
		//vo2가 로그인에 성공한 경우 주소가 들어있음.
		if(vo2!=null)
		{
			//세션을 잡자!
			session.setAttribute("userId", vo2.getId());
			session.setAttribute("userName", vo2.getName());
			return "redirect:member.jsp";
		}
		else //로그인에 실패했을 때
		{
			return "check";
		}
		
	}
	
	@RequestMapping("create")
	public void create(MemberVO vo) throws Exception
	{
		System.out.println("회원가입 제어 요청됨.");
		//1. 입력한 값 받아오기
		//2. vo만들어서 넣기
		System.out.println(vo);
		//3. dao한테 vo주면서 create호출
		dao.create(vo);
		
	}
	//create라고 요청이 들어오면 회원가입 기능을 처리해주세요.

}
