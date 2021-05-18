package com.care.root.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public void fileProcess(MultipartFile file) {
		if(file.getSize() != 0) { //파일 사이즈가 0이 아니면(파일 선택)
		
			File saveFile = new File(IMAGE_REPO+"\\"+file.getOriginalFilename());
			
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
