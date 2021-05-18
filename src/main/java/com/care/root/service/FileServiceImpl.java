package com.care.root.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.dto.ShoesDTO;
import com.care.root.mybatis.FileMapper;

@Service
public class FileServiceImpl implements FileService {
	@Autowired
	FileMapper mapper;

	@Override
	public void fileProcess(MultipartFile file) {
		if (file.getSize() != 0) { // 파일 사이즈가 0이 아니면(파일 선택)

			SimpleDateFormat sim = new SimpleDateFormat("yyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();// 시간얻어오기
			String sysFileName = sim.format(calendar.getTime()) + file.getOriginalFilename();

			File saveFile = new File(IMAGE_REPO + "\\" + sysFileName);
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void fileProcess(MultipartHttpServletRequest mul) {
		ShoesDTO dto = new ShoesDTO();
		dto.setId(mul.getParameter("id"));
		dto.setName(mul.getParameter("name"));
		MultipartFile file = mul.getFile("file");
		if (file.getSize() != 0) { // 파일 사이즈가 0이 아니면(파일 선택)
			SimpleDateFormat sim = new SimpleDateFormat("yyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();// 시간얻어오기
			String sysFileName = sim.format(calendar.getTime()) + file.getOriginalFilename();
			
			dto.setImgName(sysFileName);//dto에 파일 이름
			
			File saveFile = new File(IMAGE_REPO + "\\" + sysFileName);
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {//파일을 선택하지 않았다면
			dto.setImgName("nan");
		}
		mapper.saveDate(dto);
	}

}
