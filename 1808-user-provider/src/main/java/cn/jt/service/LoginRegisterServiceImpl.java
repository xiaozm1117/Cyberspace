package cn.jt.service;

import java.util.List;

import javax.servlet.http.Cookie;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.jt.mapper.LoginRegisterMapper;
import cn.jt.pojo.Admin;

import cn.jt.service.LoginRegisterService;
@Service
public class LoginRegisterServiceImpl implements LoginRegisterService {
	@Autowired
	private LoginRegisterMapper loginRegisterMapper;
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Override
	public void register(Admin admin) {
		String password=admin.getPassword();
		admin.setPassword(DigestUtils.md5Hex(password));
		try {
			loginRegisterMapper.register(admin);
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
		

	}
	
	@Override
	public String login(Admin admin) {
		String token="";
		String password=admin.getPassword();
		admin.setPassword(DigestUtils.md5Hex(password));
		List<Admin> userList=loginRegisterMapper.login(admin);
		
		if(userList==null || userList.isEmpty()) throw new RuntimeException();
		
		admin=userList.get(0);
		
		try {
			String userJSON = objectMapper.writeValueAsString(admin);
			//md5（“JT_TICKET_” + System.currentTime + username）
			token = DigestUtils.md5Hex("TICTOT_"+System.currentTimeMillis() + admin.getName());
			redisTemplate.opsForValue().set(token,userJSON);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		return token;
		
	}

	@Override
	public void checkname(String name) {
		try {
			loginRegisterMapper.checkname(name);
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}

}
