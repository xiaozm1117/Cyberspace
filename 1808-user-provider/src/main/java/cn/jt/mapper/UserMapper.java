package cn.jt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import cn.jt.pojo.User;

//利用MybatisPlus基接口BaseMapper
public interface UserMapper{

	public List<User> findItem(@Param(value = "id") int itemId);
	
	public List<User> selectList();

	public void add(User user);

	public void update(User user);

	public void delete(@Param(value = "i") int i);
}
