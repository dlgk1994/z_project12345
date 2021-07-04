package com.care.root.product.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.care.root.product.mybatis.productMapper;

public class productServiceImpl implements productService{
	@Autowired productMapper mapper;
	
	@Override
	public void ProductList(String productNum, Model model) {
		model.addAttribute("productList",mapper.ProductList(productNum));
	}

	@Override
	public void ProductView(String productNum, Model model) {
		model.addAttribute("productView",mapper.ProductView(productNum));
	}

	@Override
	public void ProductSearch(Model model, String productSearch_option, String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("productSearch_option", productSearch_option);
		map.put("keyword", keyword);
		
		model.addAttribute("productSearch", mapper.ProductSearch(map));
	}

	

}
