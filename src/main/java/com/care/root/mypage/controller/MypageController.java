package com.care.root.mypage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.care.root.mypage.service.MypageService;

@Controller
@RequestMapping("mypage")
public class MypageController {
	@Autowired MypageService ms;
	
	//장바구니 전체 목록
	@RequestMapping("myCart")
	public String myCart(Model model, @RequestParam(value="num", required=false, defaultValue="1") int num) {
		ms.myCart(model, num); //리스트 -> model에 저장
		return "mypage/myCart";
	}
	/*
	@RequestMapping(value="/totalPay", method=RequestMethod.POST, produces="application/json; charset=utf-8") 
	@ResponseBody
	public int totalpay(@RequestParam(value = "checkArr[]") List<String> chArr) {
		System.out.println("연결");
		int sum=0;
		
		for(String s : chArr) {
			sum += Integer.parseInt(s);
		}
		return sum;
	}*/
	//장바구니 내역 삭제
	@RequestMapping("deleteCart")
	public String deleteCart(@RequestParam int write_no, @RequestParam String cart_photo) {
		ms.deleteCart(write_no, cart_photo);
		return "mypage/myCart";
	}
	//주문 내역 전체 목록
	@RequestMapping("myRental")
	public String myRental(Model model, @RequestParam(value="num", required=false, defaultValue="1") int num) {
		//ms.myRental(model, num);
		return "mypage/myRental";
	}
	
	//내 리뷰
	@RequestMapping("myReview")
	public String myReview() {
		return "mypage/myReview";
	}
	//리뷰 작성 페이지
	@RequestMapping("reviewForm")
	public String reviewForm() {
		return "mypage/reviewForm";
	}
	//리뷰 내용 저장 -> MypageFileService에서 구현
	//리뷰 별점 관리 -> MypageFileService에서 구현
	
	
	//내 질문 
	@RequestMapping("myEnquiry")
	public String myEnquiry() {
		return "mypage/myEnquiry";
	}
}
