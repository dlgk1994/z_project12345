package com.care.root.mypage.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.mypage.service.MypageFileService;

@RequestMapping("file")
@Controller
public class MypageFileController {
	@Autowired MypageFileService fs;
	
	@RequestMapping("reviewSave")
	public void reviewSave(MultipartHttpServletRequest mul) {
		String review_content = mul.getParameter("review_content");
		
		MultipartFile file1 = mul.getFile("review_file1");
		MultipartFile file2 = mul.getFile("review_file2");
		MultipartFile file3 = mul.getFile("review_file3");
		String originalName = file1.getOriginalFilename();
		System.out.println("내용 : " + review_content);
		System.out.println("원본파일이름 : " + originalName);
		
		//fs.reviewSave(mul);
		
	}
	@PostMapping(value="star_rating", produces="application/json; charset=utf-8")
	public @ResponseBody void star_rating(@RequestParam Map<String, Object> param) {
		System.out.println(param.get("star_rating"));
		//fs.reviewSave(param);
	}
	/*
	@GetMapping("download")
	public void download(@RequestParam("file") String fileName,
						HttpServletResponse response) throws Exception {
		//Content-disposition : 파일 다운로드할 때 http 헤더에 추가해야함, 명시해줘야 다운로드 가능
		//attachment : 파일을 다운로드하여 브라우저로 표현하는 의미
		response.addHeader("Content-disposition", "attachment; fileName=" + fileName); //어떤 파일을 보낼지
		//IMAGE_REPO : 이미지 저장 경로의 값을 불러오는 코드
		File file = new File(MypageFileService.IMAGE_REPO + "\\" + fileName);
		//저장되어 있는 이미지를 inputStream 으로 불러옴, 해당 파일을 읽어옴
		FileInputStream in = new FileInputStream(file); 
		//in : 왼쪽의 값(이미지 불러온 값)을, out : 오른쪽(response(응답).output 하겠다)
		FileCopyUtils.copy(in, response.getOutputStream()); //읽어온 파일을 응답
		in.close();
	}*/
}
