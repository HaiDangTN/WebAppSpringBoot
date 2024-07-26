package com.website.tmdt.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.website.tmdt.model.ProductImage;
import com.website.tmdt.repository.ProductImageRepository;
//
import com.website.tmdt.services.ITF.FileUploadITF;

@Service
public class StoreageService implements FileUploadITF {
	@Autowired
	private ProductImageRepository productImageRepository;
	
	private final Path rootLocation ;
	
	public StoreageService() {
		this.rootLocation = Paths.get("src/main/resources/static/uploads");
	}


	@Override
	public void store(MultipartFile file) {
		try {
			Path destinationFile = this.rootLocation.resolve(
					Paths.get(file.getOriginalFilename()))
					.normalize().toAbsolutePath();
			
			try (InputStream inputStream = file.getInputStream()){
				Files.copy(inputStream, destinationFile,StandardCopyOption.REPLACE_EXISTING);
			}
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}


	@Override
	public void init() {
		try {
			Files.createDirectories(rootLocation);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
