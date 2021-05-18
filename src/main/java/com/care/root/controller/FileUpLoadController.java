package com.care.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.dto.ShoesDTO;
import com.care.root.service.FileService;

@Controller
public class FileUpLoadController {
	@Autowired FileService fs;
	
	@GetMapping("form")
	public String form() {
		return "uploadForm";
	}

	@PostMapping("upload")
	public String upload(MultipartHttpServletRequest mul) {// MultipartHttpServletRequest로 파일을 받아온다
		String id = mul.getParameter("id");
		String name = mul.getParameter("name");
		
		MultipartFile file = mul.getFile("file");//넘오는 file name
		String originName = file.getOriginalFilename();//파일 이름
		
		System.out.println("id : "+id);
		System.out.println("name : "+name);
		System.out.println("originName : "+originName);
		
		//fs.fileProcess(file);//서비스로 파일 넘기기
		fs.fileProcess(mul);
		
		return "redirect:form";
	}
}
