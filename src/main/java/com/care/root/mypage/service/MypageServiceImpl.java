package com.care.root.mypage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.mypage.mybatis.MypageMapper;

@Service
public class MypageServiceImpl implements MypageService {
	@Autowired MypageMapper mapper;
	
	//장바구니 전체 목록
	@Override
	public void myCart(Model model, int num) {
		int pageLetter = 3; //한페이지에 3개의 글
		int allCount = mapper.mycartCount(); //총 글 개수 불러오기
		
		int repeat = allCount / pageLetter;
		if(allCount % pageLetter != 0) { 
			repeat += 1; //한페이지 추가 
		}
		int end = num * pageLetter;
		int start = end + 1 - pageLetter;
		model.addAttribute("repeat", repeat); //총 페이지 수 
		
		model.addAttribute("cartList", mapper.myCart(start, end));
	}
	//장바구니 내역 삭제
	@Override
	public void deleteCart(int write_no, String cart_photo) {
		MypageFileService mfs = new MypageFileServiceImpl();
		int result = mapper.deleteCart(write_no); //성공 시 1 반환
		
		if(result == 1) {
			mfs.deleteImage(cart_photo);
		}
		
	}
	//주문 내역 전체 목록
	@Override
	public void myRental(Model model, int num) {
		int pageLetter = 3; //한페이지에 3개의 글
		int allCount = mapper.myrentalCount(); //총 글 개수 불러오기
		
		int repeat = allCount / pageLetter;
		if(allCount % pageLetter != 0) { 
			repeat += 1; //한페이지 추가 
		}
		int end = num * pageLetter;
		int start = end + 1 - pageLetter;
		model.addAttribute("repeat", repeat); //총 페이지 수 
		
		model.addAttribute("rentalList", mapper.myRental(start, end)); 
		
	}
}
