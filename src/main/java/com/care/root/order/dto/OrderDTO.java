package com.care.root.order.dto;

public class OrderDTO {
	private int order_seq_num;
	private String member_id;	//주문자 아이디
	private int order_id;
	private int goods_id;
	private String order_title;	//상품명
	private int goods_total;	//총 금액
	private int cart_goods_qty;	//카트 상품 수량
	private int order_goods_qty;	//주문자 상품 수량
	
	private String orderer_name;
	private String receiver_name;
	private String receiver_tel;
	private String receiver_addr1;
	private String receiver_addr2;
	private String receiver_addr3;
	
	private String delivery_address;
	private String delivery_message;
	
	private String final_total_price;
	private int goods_qty;
	private String goods_fileName;
	private String orderer_tel;
	
	
}
