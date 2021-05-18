package com.care.root.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	public static final String IMAGE_REPO="C:\\LJW\\SPRING\\image_repo";
	public void fileProcess(MultipartFile file);
}
