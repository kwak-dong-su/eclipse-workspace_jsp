package com.hi.mvc04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	
	
	@RequestMapping("create2")
	public void create(BookVO vo, BookDAO dao) throws Exception
	{
		System.out.println("사이트 등록 제어 요청됨.");
		//1. 입력한 값 받아오기
		//2. vo만들어서 넣기
		System.out.println(vo);
		//3. dao한테 vo주면서 create호출
		dao.create(vo);
		
	}
	//create라고 요청이 들어오면 회원가입 기능을 처리해주세요.
	
	@RequestMapping("delete2") // 핑크화면
	public void del(BookVO vo, BookDAO dao) throws Exception
	{
		System.out.println("사이트 삭제 제어 요청됨.");
		System.out.println(vo);
		dao.delete(vo);
	}
	
	@RequestMapping("update2") //초록화면
	public void up(BookVO vo, BookDAO dao) throws Exception
	{
		System.out.println("사이트 수정 제어 요청됨.");
		System.out.println(vo);
		dao.update(vo);
	}
	
	@RequestMapping("list2") //초록화면
	public void list(BookVO vo, BookDAO dao) throws Exception
	{
		System.out.println("사이트 목록 불러오기 요청됨.");
		System.out.println(vo);
		dao.readAll();
	}
}
