package com.care.root.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.product.mybatis.productMapper;
import com.care.root.product.service.productService;

@Controller
public class ProductController {
	@Autowired productService service;
	@Autowired productMapper mapper;
	
	//상품 리스트
	@GetMapping("adminProduct/adminProductList")
	public String adminProductList(@RequestParam String productNum, Model model){
		service.ProductList(productNum,model);
		
		return "Product/adminProductList";
	}
		
	//상품 내용 확인
	@RequestMapping("adminProduct/adminProductView")
	public String adminProductView(@RequestParam String productNum,Model model) {
		service.ProductView(productNum,model);
			    
		return "Product/adminProductView";
	}
		
	//상품 검색
	@RequestMapping("adminProduct/adminProductSearch")
	public String adminProductSearch(Model model,@RequestParam(defaultValue="product_num") String ProductSearch_option,@RequestParam(defaultValue="") String keyword){
		service.ProductSearch(model,ProductSearch_option,keyword);
		model.addAttribute("productSearch_option", ProductSearch_option);
		model.addAttribute("keyword", keyword);
		
		return "Product/adminProductSearch";
	}
	
}
