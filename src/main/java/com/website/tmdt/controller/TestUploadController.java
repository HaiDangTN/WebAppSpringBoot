package com.website.tmdt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.website.tmdt.services.StoreageService;

@Controller
@RequestMapping("/upload")
public class TestUploadController {
	@Autowired
	private StoreageService service;
	@PostMapping("")
	public String saveData(@RequestParam("file") MultipartFile file) {
		this.service.store(file);
		return "success";
	}
}
