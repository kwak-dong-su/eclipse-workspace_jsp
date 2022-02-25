package com.cgv.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {

	@Autowired
	MovieDAO dao;
	
	@RequestMapping("mvOne")
	public void one(MovieVO vo, Model model) {
		MovieVO vo2=dao.one(vo);
		model.addAttribute("one", vo2);
	}
}
