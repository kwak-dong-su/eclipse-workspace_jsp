package com.hi.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@Autowired
	MemberDAO dao;
	
	@RequestMapping("createMember")
	public void createMember(MemberVO vo)
	{
		System.out.println(vo);
		dao.create(vo);
	}
}
