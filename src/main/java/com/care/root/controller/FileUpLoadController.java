package com.care.root.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileUpLoadController {
	@GetMapping("form")
	public String form() {
		return "uploadForm";
	}
}
