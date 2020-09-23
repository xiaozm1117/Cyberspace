package cn.jt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@RequestMapping("/index")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping("/test")
	public String homePage1() {
		return "test";
	}
	
	
}
