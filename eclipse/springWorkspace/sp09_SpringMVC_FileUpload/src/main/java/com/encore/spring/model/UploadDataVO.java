package com.encore.spring.model;

import org.springframework.web.multipart.MultipartFile;

public class UploadDataVO {
	private String userName;
	private MultipartFile uploadFile;        //변수명은 폼의 이름으로 지정해야한다.    짱중요
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	
}
