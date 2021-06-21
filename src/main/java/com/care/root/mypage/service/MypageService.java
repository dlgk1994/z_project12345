package com.care.root.mypage.service;

import org.springframework.ui.Model;

public interface MypageService {
	//장바구니 전체 목록
	public void myCart(Model model, int num);
	//장바구니 내역 삭제
	public void deleteCart(int write_no, String cart_photo);
	//주문 내역 전체 목록
	public void myRental(Model model, int num);
	//내 리뷰
	
	//내 질문
	
	//
}
