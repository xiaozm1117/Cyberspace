package cn.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.jt.feign.UserFeign;
import cn.jt.pojo.User;
import cn.jt.tool.Result;

@Controller
public class UserController {
	@Autowired
	private UserFeign userFeign;
	
	@RequestMapping("/user/findAll")
	
	public  String findAll(Model mode){ 
		List<User>uList=userFeign.findAll();
		mode.addAttribute("uList", uList);
		
		return "show1";
	}
	
	
	@RequestMapping("/user/add-update")
	
	public String addUpdate(User user,Model mode) {
		
		try {
			userFeign.addUpdate(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return "redirect:/user/findAll.html";
		}
		
	}


	@RequestMapping("/user/delete")
	@ResponseBody
	public Result delete(@RequestParam("items") int[] items) {
		try {
			
			userFeign.delete(items);
			return new Result("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Result("fail");
	}
	
	@RequestMapping("/user/edit")
	public String eidt( int itemId,Model mode) {
		mode.addAttribute("userL", null);
		if(itemId>0) {
		List<User> user=userFeign.findItem(itemId);
		mode.addAttribute("userL", user);}
		
		return "edit";
	}
}





