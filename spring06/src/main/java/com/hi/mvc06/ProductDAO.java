package com.hi.mvc06;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDAO {

	@Autowired
	SqlSessionTemplate my;
	
	public void create(ProductVO vo) throws Exception {
		my.insert("product.create", vo);
	}
	
	public ProductVO read(ProductVO vo) {
		return my.selectOne("product.one", vo);
	}
	
	public List<ProductVO> all() {
		return my.selectList("product.all");
	}
	
	public void delete(ProductVO vo) {
		my.delete("product.del", vo);
	}
	
	public void update(ProductVO vo) {
		my.update("product.up", vo);
	}
}

