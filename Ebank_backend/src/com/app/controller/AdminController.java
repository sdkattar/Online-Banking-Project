package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.News;
import com.app.pojos.Users;
import com.app.service.AdminService;
import com.app.service.UserService;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/admin")

public class AdminController {

	
	

	public AdminController() {
		System.out.println("in ADMIN controller");

	}
	
	News news;

	@Autowired
	private AdminService serv;
	
//	
//	@GetMapping("/getNewsbyid")
//	public ResponseEntity<?> getNewsById(@RequestParam Integer id) {
//		System.out.println("in getNewsbyid controller");
//
//		return new ResponseEntity<Users>(serv.getData(id), HttpStatus.OK);
//	}

	
}