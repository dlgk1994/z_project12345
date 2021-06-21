package com.care.root.board.service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {
	
	
	//공지사항 목록
	public void notice(Model model, int num);
	
	
	//Q&A 전체 목록
	public void qna(Model model, int num);
	//Q&A 글 저장
	public void qnaSave(MultipartHttpServletRequest mul);
	//Q&A 제목 클릭 시 상세보기
	public void selectQna(Model model, int enquiry_no);
	//Q&A 검색
	public void searchQna(Model model, String search_option, String keyword);
	//Q&A 수정 내용 저장
	public void modifySave(Model model, int enquiry_no, MultipartHttpServletRequest mul);
	//Q&A 삭제
	public void deleteQna(int enquiry_no);
}
