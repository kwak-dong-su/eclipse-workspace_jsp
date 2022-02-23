package com.hi.mvcProject;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BbsDAO {

	@Autowired
	SqlSessionTemplate my;
	
	public void create(BbsVO vo) {
		my.insert("bbs.write", vo);
	}
	
	public void update(BbsVO vo) {
		my.update("bbs.update", vo);
	}
	
	public void delete(BbsVO vo) {
		my.delete("bbs.delete", vo);
	}
	
	public BbsVO one(BbsVO vo) {
		return my.selectOne("bbs.one", vo);
	}
	
	public List<BbsVO> all() {
		return my.selectList("bbs.list");
	}
}
