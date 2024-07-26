package com.website.tmdt.services.ITF;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadITF {
	void init();
	void store(MultipartFile file);

}
