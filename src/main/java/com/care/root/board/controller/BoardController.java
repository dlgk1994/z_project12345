package com.care.root.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.board.service.BoardServiceImpl;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired BoardServiceImpl bs;
	
	//자주하는 질문 
	@RequestMapping("faq")
	public String faq() {
		return "board/faq";
	}
	//공지사항
	@RequestMapping("notice")
	public String notice(Model model, @RequestParam(value="num", required=false, defaultValue="1") int num) {
		bs.notice(model, num);
		return "board/notice";
	}
	//Q&A 전체 목록
	@RequestMapping("qna")
	public String qna(Model model, @RequestParam(value="num", required=false, defaultValue="1") int num) {
		bs.qna(model, num);
		return "board/qna";
	}
	//Q&A 글작성
	@RequestMapping("qnaForm")
	public String qnaForm() {
		return "board/qnaForm";
	}
	//Q&A 글 저장
	@PostMapping("qnaSave")
	public String qnaSave(MultipartHttpServletRequest mul) {
		bs.qnaSave(mul);
		return "redirect:/board/qna";
	}
	//Q&A 제목 클릭 시 상세보기
	@RequestMapping("selectQna")
	public String selectQna(Model model, @RequestParam int enquiry_no, RedirectAttributes ra) {
		bs.selectQna(model, enquiry_no);
		ra.addFlashAttribute("model", model);
		return "board/selectQna";
	}
	//Q&A 검색
	@PostMapping("searchQna")
	public String searchQna(Model model, @RequestParam(defaultValue="member_id") String search_option, @RequestParam(defaultValue="") String keyword) {
		bs.searchQna(model, search_option, keyword);
		model.addAttribute("search_option", search_option);
		model.addAttribute("keyword", keyword);
		return "board/searchQna";
	}
	//Q&A 수정
	@RequestMapping("modifyForm")
	public String modifyForm(Model model, @RequestParam int enquiry_no) {
		bs.selectQna(model, enquiry_no);
		return "board/modifyForm";
	}
	//Q&A 수정 내용 저장
	@PostMapping("modifySave")
	public String modifySave(Model model, @RequestParam int enquiry_no, MultipartHttpServletRequest mul) {
		bs.modifySave(model, enquiry_no, mul);
		return "redirect:/board/qna";
	}
	//Q&A 삭제
	@RequestMapping("deleteQna")
	public String deleteQna(@RequestParam int enquiry_no) {
		bs.deleteQna(enquiry_no);
		return "redirect:/board/qna";
	}
	
}
