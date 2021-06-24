package com.care.root.mypage.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.dto.MessageDTO;
import com.care.root.mypage.dto.ReviewDTO;
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
	//내 리뷰 전체 목록
	@Override
	public void myReview(Model model, int num) {
		int pageLetter = 3; //한페이지에 3개의 글
		int allCount = mapper.myreviewCount(); //총 글 개수 불러오기
		
		int repeat = allCount / pageLetter;
		if(allCount % pageLetter != 0) { 
			repeat += 1; //한페이지 추가 
		}
		int end = num * pageLetter;
		int start = end + 1 - pageLetter;
		model.addAttribute("repeat", repeat); //총 페이지 수 
		
		model.addAttribute("reviewList", mapper.myReview(start, end));
	}
	//내 리뷰 저장
	@Override
	public void reviewSave(MultipartHttpServletRequest mul, HttpServletRequest request) {
		ReviewDTO dto = new ReviewDTO();
		dto.setReview_content(mul.getParameter("review_content"));
		dto.setReview_score(Integer.parseInt(mul.getParameter("review_score")));
		//dto.setReview_id(mul.getParameter("review_id"));
		dto.setReview_id("A");
		dto.setProduct_name(mul.getParameter(""));
		dto.setProduct_photo(mul.getParameter(""));
		
		MypageFileService mfs = new MypageFileServiceImpl();
		
		MultipartFile file1 = mul.getFile("review_file1"); 
		MultipartFile file2 = mul.getFile("review_file2"); 
		MultipartFile file3 = mul.getFile("review_file3"); 
		if(file1.getSize() != 0) {
			dto.setReview_file1(mfs.saveFile(file1));				
		} else {
			dto.setReview_file1("nan");
		}
		if(file2.getSize() != 0) {
			dto.setReview_file2(mfs.saveFile(file2));				
		} else {
			dto.setReview_file2("nan");
		}
		if(file3.getSize() != 0) {
			dto.setReview_file3(mfs.saveFile(file3));				
		} else {
			dto.setReview_file3("nan");
		}	
		
		mapper.reviewSave(dto);
	}
	//내 리뷰 클릭 시 상세보기
	@Override
	public void selectReview(Model model, int review_no) {
		model.addAttribute("selectReview", mapper.selectReview(review_no));
	}
	//내 리뷰 수정
	@Override
	public void modifyReviewSave(Model model, int review_no, MultipartHttpServletRequest mul) {
		ReviewDTO dto = new ReviewDTO();
		dto.setReview_no(Integer.parseInt(mul.getParameter("review_no")));
		dto.setReview_content(mul.getParameter("review_content"));
		//dto.setReview_score(Integer.parseInt(mul.getParameter("review_score")));
		//dto.setReview_id(mul.getParameter("review_id"));
		
		MypageFileService mfs = new MypageFileServiceImpl();
		
		MultipartFile file1 = mul.getFile("review_file1"); 
		MultipartFile file2 = mul.getFile("review_file2"); 
		MultipartFile file3 = mul.getFile("review_file3"); 
		if(file1.getSize() != 0) {
			dto.setReview_file1(mfs.saveFile(file1));
			mfs.deleteImage(mul.getParameter("org_file_name1"));
		} else {
			dto.setReview_file1("nan");
		}
		if(file2.getSize() != 0) {
			dto.setReview_file2(mfs.saveFile(file2));
			mfs.deleteImage(mul.getParameter("org_file_name2"));
		} else {
			dto.setReview_file2("nan");
		}
		if(file3.getSize() != 0) {
			dto.setReview_file3(mfs.saveFile(file3));	
			mfs.deleteImage(mul.getParameter("org_file_name3"));
		} else {
			dto.setReview_file3("nan");
		}
		mapper.modifyReviewSave(dto);
	}
	@Override
	public void deleteReview(int review_no, String review_file1, String review_file2, String review_file3) {
		MypageFileService mfs = new MypageFileServiceImpl();
		
		int result = mapper.deleteReview(review_no);
		if(result == 1) {
			mfs.deleteImage(review_file1);
			mfs.deleteImage(review_file2);
			mfs.deleteImage(review_file3);
		}
	}
	
	
	
}
