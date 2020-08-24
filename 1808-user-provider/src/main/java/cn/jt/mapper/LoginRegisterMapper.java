package cn.jt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jt.pojo.Admin;


public interface LoginRegisterMapper {

	public int register(Admin admin);

	public List<Admin> login(Admin admin);

	public int checkname(String name);

}
