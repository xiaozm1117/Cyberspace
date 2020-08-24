package cn.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.jt.pojo.Admin;
import cn.jt.pojo.User;
import cn.jt.service.LoginRegisterService;

@RestController

public class LoginRegister {
	@Autowired
	private LoginRegisterService loginRegisterService; 
	@RequestMapping("/loginRegister/register")
	public void regiester(@RequestBody Admin admin) {
		loginRegisterService.register(admin);
	}
	
	@RequestMapping("/loginRegister/login")
	public String login(@RequestBody Admin admin) {
		return loginRegisterService.login(admin);
		
	}
	
	@RequestMapping("/loginRegister/checkname") 
	public void checkname(@RequestParam String name){
		 loginRegisterService.checkname(name);
	 }
}
