package cn.jt.service;

import cn.jt.pojo.Admin;
import cn.jt.pojo.User;

public interface LoginRegisterService {

	public void register(Admin admin);

	public String login(Admin admin);

	public void checkname(String username);
	
}
