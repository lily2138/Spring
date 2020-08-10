package com.encore.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.model.UploadDataVO;

@Controller
public class FileController {
	
	@RequestMapping("fileUpload.do")
								// HttpServletSession session
	public ModelAndView fileUpload(HttpServletRequest request, UploadDataVO vo) throws IllegalStateException, IOException {
		
		//1. vo에서 MultipartFile을 받아온다....
		MultipartFile mFile = vo.getUploadFile();
		System.out.println("MultipartFile : " + mFile);
		
		/*
		 * 2. 업로드 된 파일이 있다면,
		 * 		파일의 사이즈
		 * 		업로드한 파일의이름
		 * 		업로드한 파일의 파라미터명?
		 * 		---> 파일을 서버에 올리고 싶다...
		 * 
		 * 	업로드된 파일이 없다면,
		 */
		
		if(mFile.isEmpty() != true) {	//업로드된 파일이 있다면....
			System.out.println("파일의 사이즈 :: " + mFile.getSize());
			System.out.println("업로드된 파일명 :: " + mFile.getOriginalFilename());
			System.out.println("파일의 파라미터명 ::" + mFile.getName());
		}
		//getRealPath() ....    
		String root = request.getSession().getServletContext().getRealPath("/");      //
		String path = root + "\\upload\\";
		
		//File은 디렉토리 + 파일명
		File copyFile = new File(path + mFile.getOriginalFilename());
		mFile.transferTo(copyFile);    //원래 업로드한 파일이 지정한 path위치로 이동.... 이때 카피본이 이동한다.
		System.out.println("path :: " + path);
		
		return new ModelAndView("upload_result", "uploadfile", mFile.getOriginalFilename());
	}
	
	//Download
	@RequestMapping("fileDown.do")
	public ModelAndView fileDown(HttpServletRequest request, String filename) throws IOException {
		
		System.out.println("filename :: " + filename);
		String root = request.getSession().getServletContext().getRealPath("/");      //
		String path = root + "\\upload\\";
		
		HashMap map = new HashMap();
		map.put("path",path); //upload한 파일을 특정한 경로에 이동....그걸 다운로드 할거다....
		
		return new ModelAndView("downloadView", map);
	}
	
}
