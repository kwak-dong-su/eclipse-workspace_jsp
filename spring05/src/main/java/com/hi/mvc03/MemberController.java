package com.hi.mvc03;

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
	
	@RequestMapping("check.hi")
	public void login(MemberVO vo, HttpSession session) throws Exception 
	{
		/*
		 * System.out.println(vo); boolean result = dao.login(vo);
		 * 
		 * if(result) { //세션을 잡아두어라. session.setAttribute("user", vo.getId());
		 * session.setAttribute("name", "홍길동"); //name을 세션으로 잡아서, 브라우저 2곳에서 //홍길동님
		 * 환영합니다.
		 * 
		 * 
		 * }
		 */
		
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
	
	@RequestMapping("del") // 핑크화면
	public void del(MemberVO vo) throws Exception
	{
		System.out.println("회원탈퇴 제어 요청됨.");
		System.out.println(vo);
		int result = dao.delete(vo);
		if(result==0)
		{
			
		}
		else
		{
			
		}
	}
	
	@RequestMapping("up") //초록화면
	public String up(MemberVO vo) throws Exception
	{
		System.out.println("회원수정 제어 요청됨.");
		System.out.println(vo);
		int result = dao.update(vo);
		if(result==0)
		{
			// return "error"; //views 아래의 파일을 호출하는 경우
			return "redirect:member.jsp"; //webapp아래의 파일을 호출하는 경우
		}
		else
		{
			return "up";
		}
	}
	
	@RequestMapping("all")
	public void all(Model model) {
		List<MemberVO> list = dao.readAll();
		System.out.println(list.size());
		model.addAttribute("list", list);
		
	}
	
	@RequestMapping("one")
	public void one(MemberVO vo, Model model) {
		MemberVO one = dao.readOne(vo);
		model.addAttribute("one", one);
	}
}
