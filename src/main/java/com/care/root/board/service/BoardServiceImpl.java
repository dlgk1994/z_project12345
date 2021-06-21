package com.care.root.board.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.dto.EnquiryDTO;
import com.care.root.board.mybatis.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired BoardMapper mapper;

	@Override
	public void notice(Model model, int num) {
		int pageLetter = 10; //한페이지에 3개의 글
		int allCount = mapper.noticeCount(); 
		
		int repeat = allCount / pageLetter;
		if(allCount % pageLetter != 0) { 
			repeat += 1; //한페이지 추가 
		}
		int end = num * pageLetter;
		int start = end + 1 - pageLetter;
		model.addAttribute("repeat", repeat);  
		
		model.addAttribute("noticeList", mapper.notice(start, end));
	}
	//Q&A 전체 목록
	@Override
	public void qna(Model model, int num) {
		int pageLetter = 10; //한페이지에 3개의 글
		int allCount = mapper.qnaCount(); 
		
		int repeat = allCount / pageLetter;
		if(allCount % pageLetter != 0) { 
			repeat += 1; //한페이지 추가 
		}
		int end = num * pageLetter;
		int start = end + 1 - pageLetter;
		model.addAttribute("repeat", repeat);  
		
		model.addAttribute("qnaList", mapper.qna(start, end));	
	}
	//Q&A 글 저장
	@Override
	public void qnaSave(MultipartHttpServletRequest mul) {
		EnquiryDTO dto = new EnquiryDTO();
		
		dto.setMember_id("A");
		dto.setEnquiry_subject(mul.getParameter("enquiry_subject"));
		dto.setEnquiry_content(mul.getParameter("enquiry_content"));
		dto.setEnquiry_state("답변중");

		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		
		dto.setEnquiry_writedate(s.format(calendar.getTime()));

		mapper.qnaSave(dto);
	}
	//조회수 증가
	public void upHit(int enquiry_no) {
		mapper.upHit(enquiry_no);
	}
	//Q&A 제목 클릭 시 상세보기
	@Override
	public void selectQna(Model model, int enquiry_no) {
		model.addAttribute("selectQna", mapper.selectQna(enquiry_no));
	}
	//Q&A 검색
	@Override
	public void searchQna(Model model, String search_option, String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		
		model.addAttribute("searchQna", mapper.searchQna(map));
	}
	//Q&A 수정 내용 저장
	@Override
	public void modifySave(Model model, int enquiry_no, MultipartHttpServletRequest mul) {
		EnquiryDTO dto = new EnquiryDTO();
		
		dto.setEnquiry_no(Integer.parseInt(mul.getParameter("enquiry_no")));
		dto.setMember_id("A");
		dto.setEnquiry_subject(mul.getParameter("enquiry_subject"));
		dto.setEnquiry_content(mul.getParameter("enquiry_content"));
		dto.setEnquiry_state("답변완료");
		System.out.println(mul.getParameter("enquiry_subject"));

		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		
		dto.setEnquiry_writedate(s.format(calendar.getTime()));

		mapper.modifySave(dto);
	}
	//Q&A 삭제
	@Override
	public void deleteQna(int enquiry_no) {
		mapper.deleteQna(enquiry_no);
	}
	
	
	
}
