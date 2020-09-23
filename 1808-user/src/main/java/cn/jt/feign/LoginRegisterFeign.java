package cn.jt.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.jt.pojo.Admin;
import cn.jt.tool.Result;

@FeignClient("jt-user-provider")
public interface LoginRegisterFeign {
	@RequestMapping("/loginRegister/register")
	public void regiester(@RequestBody Admin admin);
	@RequestMapping("/loginRegister/login")
	public String login(Admin admin);
	@RequestMapping("/loginRegister/checkname") 
	public Result checkname(@RequestParam("name") String name);
	
}
