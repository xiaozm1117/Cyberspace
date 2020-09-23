package cn.jt.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jt.pojo.Admin;
import cn.jt.tool.Result;
import cn.jt.feign.LoginRegisterFeign;

@Controller
@RequestMapping("/loginRegister")
public class LoginRegister {
	@Autowired
	private LoginRegisterFeign loginRegisterFeign;

	@RequestMapping("/page/register")
	public String pageRegister() {
		return "register";
	}
	@RequestMapping("/page/login")
	public String pageLogin() {
		return "login";
	}
	@RequestMapping("/register")
	@ResponseBody
	public Result regiester(Admin admin) {
		try {
			loginRegisterFeign.regiester(admin);
			return new Result("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Result("fail");
		
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public Result login(Admin admin,HttpServletResponse response) {
		try {
			String token=loginRegisterFeign.login(admin);
			 
			 Cookie cookie = new Cookie("JT_TICKET", token);
				cookie.setPath("/"); //表示在浏览器根目录生效
				cookie.setMaxAge(3600 * 24 * 7); //设定生命周期 单位秒
				response.addCookie(cookie);
			 return new Result("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return new Result("fail");
		
	}
	
	
	  @RequestMapping("/checkname") 
	  @ResponseBody
	  public Result checkname(@RequestParam String name) { 
		  try {
			  loginRegisterFeign.checkname(name);
			  return new Result("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return new Result("fail");
	  }
	 
}
