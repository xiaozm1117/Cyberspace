package cn.jt.service;

import java.util.List;

import cn.jt.pojo.User;

public interface UserService {
	public List<User> findAll();
	
	public List<User> findItem(int itemId);
	public void addUpdate(User user);

	public void delete(int[] ar);
}
