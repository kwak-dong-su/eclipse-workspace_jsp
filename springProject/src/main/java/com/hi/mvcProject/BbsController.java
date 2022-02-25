package com.hi.mvcProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BbsController {

	@Autowired
	BbsDAO dao;
	
	@Autowired
	ReplyDAO dao2;
	
	@RequestMapping("write")
	public void write(BbsVO vo) {
		dao.create(vo);
	}
	
	@RequestMapping("update")
	public void update(BbsVO vo, Model model) {
		BbsVO vo2=dao.one(vo);
		model.addAttribute("one", vo2);
	}
	
	@RequestMapping("update2")
	public void update2(BbsVO vo) {
		dao.update(vo);
	}
	
	@RequestMapping("delete")
	public void delete(BbsVO vo) {
		System.out.println(vo);
		dao.delete(vo);
	}
	
	
	@RequestMapping("bookone")
	public void one(BbsVO vo, Model model) {
		//게시물 1개짜리 vo2
		//replylist
		BbsVO vo2=dao.one(vo);
		model.addAttribute("one", vo2);
		
		List<ReplyVO> list= dao2.list(vo);
		model.addAttribute("list", list);
		System.out.println(list);
	}
	
	@RequestMapping("booklist")
	public void list(BbsDAO vo, Model model) {
		List<BbsVO> list= dao.all();
		model.addAttribute("list", list);
	}
}
