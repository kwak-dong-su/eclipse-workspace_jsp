package com.hi.mvc03;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PayController {
	
	@RequestMapping("money.do")
	public void ajax1(String money, String choice, Model model) 
	{

		System.out.println(money+" "+choice);
		int money2=Integer.parseInt(money);
		
		if(choice.equals("1"))
		{
			money2=money2/100*70;
		}
		else if(choice.equals("2"))
		{
			money2=money2/100*90;
		}
		
		model.addAttribute("money", money2);
		
	}
	
	@RequestMapping("ajax3")
	public void ajax1(String phone, Model model) 
	{
		System.out.println("ajax1호출됨.");
		System.out.println("전달받은 전화번호 "+phone);
		String no="";
		//세글자 010 --> 111
		//     011 -->  222
		//    나머지  --> 333
		//랜덤한 값 3글자 만들어서 plus
		String pre=phone.substring(0, 3);
		if(pre.equals("010"))
		{
			no = no + "111";
		}
		else if(pre.equals("011"))
		{
			no = no + "222";
		}
		else
		{
			no = no + "333";
		}
		
		Random r = new Random();
		int no2 = r.nextInt(900) + 100; //0~99, 100~999
		no = no + no2;
		
		System.out.println("전송할 인증번호"+no);
		//views까지 no값을 전달하고 ram에서 제거하고자 하는 경우
		//model객체의 속성으로 지정
		model.addAttribute("no", no);
	}
}
