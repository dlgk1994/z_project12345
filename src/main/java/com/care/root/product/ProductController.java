package com.care.root.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Product")
public class ProductController {
	@RequestMapping("product")
	public String payment() {
		return "Product/product";
	}
}
