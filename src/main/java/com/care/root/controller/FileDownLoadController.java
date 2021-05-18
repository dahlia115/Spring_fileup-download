package com.care.root.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.service.FileService;

@Controller
public class FileDownLoadController {
	@GetMapping("download")
	public void downlowd(@RequestParam("file") String fileName,
								HttpServletResponse response) throws Exception {
		response.addHeader("Content-disposition", "attachment; fileName="+fileName);
		File file = new File(FileService.IMAGE_REPO+"\\"+fileName);
		FileInputStream in = new FileInputStream(file);
		FileCopyUtils.copy(in, response.getOutputStream());//왼쪽 값을 오른쪽으로 전달(가져온 파일을 응답하겠다
		in.close();
	}
}
