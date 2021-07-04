package com.care.root.product.mybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.care.root.admin.product.dto.productDTO;

public interface productMapper {
	public ArrayList<productDTO> ProductList(String productNum);
	public productDTO ProductView(String productNum);
	public List<String> ProductSearch(Map<String, String> map);
}
