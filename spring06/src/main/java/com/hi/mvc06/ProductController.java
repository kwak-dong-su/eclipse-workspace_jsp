package com.hi.mvc06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ProductController {

	@Autowired
	ProductDAO dao;
	
	@RequestMapping("create")
	public void create(ProductVO vo) throws Exception
	{
		System.out.println("제품 추가 제어 요청됨.");
		//1. 입력한 값 받아오기
		//2. vo만들어서 넣기
		System.out.println(vo);
		//3. dao한테 vo주면서 create호출
		dao.create(vo);
		
	}
	//create라고 요청이 들어오면 회원가입 기능을 처리해주세요.
	
	@RequestMapping("delete") // 핑크화면
	public void del(ProductVO vo) throws Exception
	{
		System.out.println("회원탈퇴 제어 요청됨.");
		System.out.println(vo);
		dao.delete(vo);
	}
	
	@RequestMapping("update") //초록화면
	public void up(ProductVO vo) throws Exception
	{
		System.out.println("회원수정 제어 요청됨.");
		System.out.println(vo);
		dao.update(vo);
	}
	
	@RequestMapping("all")
	public void all(Model model) {
		List<ProductVO> list = dao.all();
		System.out.println(list.size());
		model.addAttribute("list", list);
		
	}
	
	@RequestMapping("one")
	public void one(ProductVO vo, Model model) {
		ProductVO one = dao.read(vo);
		model.addAttribute("one", one);
	}
}
