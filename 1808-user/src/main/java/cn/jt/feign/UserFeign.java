package cn.jt.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.jt.pojo.User;

@FeignClient("jt-user-provider")		//指向服务提供者
public interface UserFeign {
	@RequestMapping("/user/findAll")
	public List<User> findAll();
	
	@RequestMapping("/user/delete")
	public void delete(@RequestBody int[]ar) ;
	
	@RequestMapping("/user/findItem/{itemId}")
	public List<User> findItem(@PathVariable("itemId") int itemId);

	@RequestMapping("/user/add/add-update")
	public void addUpdate(@RequestBody User user);

}





