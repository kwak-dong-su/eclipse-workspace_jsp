package com.cgv.mvc;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class MovieDAO {

	@Autowired
	SqlSessionTemplate my;
	
	public MovieVO one(MovieVO vo) {
		return my.selectOne("movie.one", vo);
	}
}
