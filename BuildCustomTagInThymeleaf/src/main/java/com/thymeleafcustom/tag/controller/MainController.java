package com.thymeleafcustom.tag.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping({"", "demo"})
public class MainController {

	@RequestMapping(value = {"", "index", "/"}, method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
}
