package com.care.root.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public void fileProcess(MultipartFile file) {
		if(file.getSize() != 0) { //파일 사이즈가 0이 아니면(파일 선택)
			
			SimpleDateFormat sim = new SimpleDateFormat("yyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();//시간얻어오기
			String sysFileName = sim.format(calendar.getTime())+file.getOriginalFilename();
			
			File saveFile = new File(IMAGE_REPO+"\\"+sysFileName);
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
