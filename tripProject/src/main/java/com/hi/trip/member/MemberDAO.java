package com.hi.trip.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDAO {

	@Autowired
	SqlSessionTemplate my;
	
	public void create(MemberVO vo) 
	{
		my.insert("member.create", vo);
	}
}