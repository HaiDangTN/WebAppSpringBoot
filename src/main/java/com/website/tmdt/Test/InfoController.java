package com.website.tmdt.Test;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/images") 
public class InfoController {
	@PostMapping("upload")
	public String save(@RequestParam("photo") MultipartFile photo) {
		
		Path path = Paths.get("src/main/resources/static/uploads");
		try {
			InputStream inputStream = photo.getInputStream();
			Files.copy(inputStream, path.resolve(photo.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "resource"+photo.getResource();
	}
	  
}
