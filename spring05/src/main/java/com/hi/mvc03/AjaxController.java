package com.hi.mvc03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //1)컨트롤러로 등록, 2)싱글톤 객체 생성(주소)  이 둘 모두의 기능을 가지는 어노테이션
public class AjaxController {
	
	@RequestMapping("movie")
	public static void name(String title, int price, Model model) {
		System.out.println("ajax로 받은 데이터 " + title + " " + price);
		double price2 = price*0.8;
		//model : 결과를 담는 views아래까지만 데이터를 전달하고 ram에서 삭제!
		model.addAttribute("title", title);
		model.addAttribute("price2", (int)price2); //강제 타입변환
		//강제타입변환(강제형변환)==> 캐스팅(casting)
	}
	
	@RequestMapping("reply")
	public static void reply(String reply, Model model) {
		System.out.println("ajax로 받은 데이터 " + reply);
		//dao에 userid를 주면서 이미 있는지 아닌지 체크
		
		model.addAttribute("reply", reply);
	}
	
	@RequestMapping("user")
	public static void user(String user, Model model) {
		System.out.println("ajax로 받은 데이터 " + user);
		//dao에 userid를 주면서 이미 있는지 아닌지 체크
		
		//select * from member where id= 'user'
		String[] list = {"apple", "melon", "summer"};
		String result="사용가능한 id입니다.";
		for(String s : list)
		{
			if(s.equals(user))
			{
				result="사용불가능한 id입니다.";
			}
		}
		model.addAttribute("result", result);
	}
}
