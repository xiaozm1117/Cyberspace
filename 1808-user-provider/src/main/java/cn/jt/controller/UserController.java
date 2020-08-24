package cn.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.jt.pojo.User;
import cn.jt.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	//不拆，给Feign，不支持分拆
	@RequestMapping("/user/findAll")
	
	public List<User> findAll(){
		return userService.findAll();
	}

	@RequestMapping("/user/add/add-update")
	
	public void addUpdate(@RequestBody User user){

		userService.addUpdate(user);
	}
	
	
	
	
	@RequestMapping("/user/delete")
	public void delete(@RequestBody int[]ar) {
		
			userService.delete(ar);
	}
	@RequestMapping("/user/findItem/{itemId}")
	public List<User> findItem(@PathVariable int itemId) {
			return userService.findItem(itemId);
	}
}





