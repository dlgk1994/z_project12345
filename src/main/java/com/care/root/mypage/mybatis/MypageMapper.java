package com.care.root.mypage.mybatis;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.care.root.mypage.dto.CartDTO;

public interface MypageMapper {
	//장바구니 목록
	public ArrayList<CartDTO> myCart(@Param("s") int start, @Param("e") int end);
	//장바구니 전체 목록 수 카운트
	public int mycartCount();
	//장바구니 내역 삭제
	public int deleteCart(int write_no);
	//주문 내역 전체 목록
	public ArrayList myRental(@Param("s") int start, @Param("e") int end);
	//주문 내역 전체 목록 수 
	public int myrentalCount();
	//내 리뷰 목록
	
	//내 리뷰 페이징
	
	//내 리뷰 저장
		
	//내 질문 목록
	
	//내 질문 페이징
		
	//내 질문 저장
}
