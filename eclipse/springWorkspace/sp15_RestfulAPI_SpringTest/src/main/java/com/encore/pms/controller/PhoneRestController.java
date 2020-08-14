package com.encore.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.encore.pms.dto.Phone;
import com.encore.pms.service.IPhoneService;

@RestController
public class PhoneRestController {

	@Autowired
	private IPhoneService service;
	
	@GetMapping("/phone/{num}")
	public ResponseEntity select(@PathVariable String num) {
		try {
			Phone phone = new Phone();
			phone.setNum(num);
			Phone selected = service.select(phone);
			return new ResponseEntity(selected, HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/phone")
	public ResponseEntity select() {
		try {
			List<Phone> list = service.select();
			System.out.println("list ::" + list);
			return new ResponseEntity(list,HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/phone")
	public ResponseEntity insert(@RequestBody Phone phone) {
		try {
			int result = service.insert(phone);
			return new ResponseEntity(result, HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
}
