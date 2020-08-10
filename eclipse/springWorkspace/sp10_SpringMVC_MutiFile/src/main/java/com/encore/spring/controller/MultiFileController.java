package com.encore.spring.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.model.MultiFileVO;

@Controller
public class MultiFileController {

	@RequestMapping("multiupload.do")
	public ModelAndView multiupload(HttpServletRequest request, MultiFileVO vo) throws Exception{
		/*
		 * 1. Upload된 파일을 받아온다.
		 * 2. Upload할 경로를 지정하고 해당경로에 파일의 복사본을 이동시킨다.
		 * 3. 업로드한 파일명(3개)이 출력되도록 결과 페이지를 지정한다.
		 * 	   결과페이지명은 multi_upload_result
		 * 
		 */
		
		List<MultipartFile> files = vo.getFile();
		String[] nameList = new String[files.size()];      //3칸짜리 배열 생성
		
//		String root = request.getSession().getServletContext().getRealPath("/");
//		String path = root + "\\upload\\";
		
		//위에 주석처리한거는 이거임.
		String path = "C:\\yhk\\eclipse\\springWorkspace\\sp10_SpringMVC_MutiFile\\src\\main\\webapp\\upload\\";
		
		int count = 0;
		for(MultipartFile file : files) {
			System.out.println("파일의 사이즈..." + file.getSize());
			String filename = file.getOriginalFilename();
			nameList[count++] = filename;
			
			file.transferTo(new File(path+filename));
		}
		
		return new ModelAndView("multi_upload_result", "uploadfile", nameList);
	}
	
	@RequestMapping("downloadFile.do")
	public ModelAndView downloadFile(String filename) {
		System.out.println("filename..." + filename);
		String path = "C:\\yhk\\eclipse\\springWorkspace\\sp10_SpringMVC_MutiFile\\src\\main\\webapp\\upload\\";
		HashMap map = new HashMap();
		map.put("path",path);
		return new ModelAndView("downloadView",map);
	}
}
