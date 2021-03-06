package com.hi.mvc03;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class BbsDAO {

	@Autowired
	SqlSessionTemplate my;
	
	public int create(BbsVO vo) {
		return my.insert("bbs.create", vo); // Read빼곤 모두 int값으로 리턴해줌
		//namespace.id
	}
	
	public BbsVO one(BbsVO vo) {
		return my.selectOne("bbs.one", vo);
	}
	
	public List<BbsVO> all(BbsVO vo) {
		return my.selectList("bbs.all");
	}
	
	public int update(BbsVO vo) {
		return my.update("bbs.up", vo);
	}
	
	public int delete(BbsVO vo) {
		return my.delete("bbs.del", vo);
	}
}
