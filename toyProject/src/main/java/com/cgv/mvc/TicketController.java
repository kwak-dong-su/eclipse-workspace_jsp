package com.cgv.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicketController {

	@Autowired
	TicketDAO dao;
	
	@Autowired
	MovieDAO dao2;
	
	@RequestMapping("tInsert")
	public void insert(TicketVO vo) {
		dao.create(vo);
	}
	
	@RequestMapping("tUpdate")
	public void update(TicketVO vo, Model model) {
		TicketVO vo2=dao.one(vo);
		model.addAttribute("one", vo2);
	}
	
	
	@RequestMapping("tDelete")
	public void delete(TicketVO vo) {
		System.out.println(vo);
		dao.delete(vo);
	}
	
	
	@RequestMapping("tOne")
	public void one(TicketVO vo, Model model) {
		TicketVO vo2=dao.one(vo);
		model.addAttribute("one", vo2);
		
	}
	
	@RequestMapping("tList")
	public void list(TicketVO vo, Model model) {
		System.out.println("컨트롤러 테스트");
		System.out.println(vo);
		List<TicketVO> list= dao.all(vo);
		model.addAttribute("list", list);
	}
	
	@RequestMapping("tTime")
	public void time(MovieVO vo, Model model) {
		System.out.println(vo);
		MovieVO vo2= new MovieVO();
		vo2=dao2.one(vo);
		
		String[] time=vo2.getMvTime().split(",");
		
		String json="{";
		for(int i=0;i<time.length;i++)
		{
			json=json+"\"time"+i+"\":\""+time[i]+"\"";
			if((i+1)!=time.length)
			{
				json=json+",";		
			}
		}
		json=json+"}";
		System.out.println(json);
		model.addAttribute("times",json);
	}
	
	@RequestMapping("tSeat")
	public void seat(TicketVO vo, Model model) {
		System.out.println(vo);
		
		List<TicketVO> list= dao.seatAll(vo);
		
		String seat="";
		
		for(int i=0;i<list.size();i++)
		{
			seat=seat+list.get(i).gettSeat();
			if((i+1)!=list.size())
			{
				seat=seat+",";	
			}
		}
		
		String[] seats=seat.split(",");
		
		String json="{";
		for(int i=0;i<seats.length;i++)
		{
			json=json+"\"seat"+i+"\":\""+seats[i]+"\"";
			if((i+1)!=seats.length)
			{
				json=json+",";		
			}
		}
		json=json+"}";
		System.out.println(json);
		model.addAttribute("seats", json);
	}
	
}
