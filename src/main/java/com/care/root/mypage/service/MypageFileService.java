package com.care.root.mypage.service;

public interface MypageFileService {
	public static final String IMAGE_REPO = "c:\\spring\\final_project"; //이미지가 저장될 폴더
	
	//파일 업로드
	
	//파일 삭제
	public void deleteImage(String originalFileName);
}
