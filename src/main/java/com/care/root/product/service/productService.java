package com.care.root.product.service;

import org.springframework.ui.Model;

public interface productService {
	public void ProductList(String productNum, Model model);
	public void ProductView(String productNum,Model model);
	public void ProductSearch(Model model, String productSearch_option, String keyword);
}