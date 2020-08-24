package cn.jt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jt.mapper.UserMapper;
import cn.jt.pojo.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	public List<User> findAll(){
		try {
			return userMapper.selectList();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		
	}
	

	@Override
	public List<User> findItem(int itemId) {
		
		try {
			return userMapper.findItem(itemId);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		
	}


	@Override
	public void addUpdate(User user) {
		try {
			if(user.getId()==0) {
				userMapper.add(user);
			}else {
				userMapper.update(user);
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		
	}


	@Override
	public void delete(int[] ar) {
		
		try {
			for(int i:ar) {
				userMapper.delete(i);
				}
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
			
		
	}



	
}





