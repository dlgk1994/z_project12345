package com.care.root.mypage.service;

import java.io.File;

import org.springframework.stereotype.Service;
@Service
public class MypageFileServiceImpl implements MypageFileService {

	
	//파일 삭제
	@Override
	public void deleteImage(String originalFileName) {
		File deleteFile = new File(IMAGE_REPO + "/" + originalFileName);
		deleteFile.delete();
	}

}
