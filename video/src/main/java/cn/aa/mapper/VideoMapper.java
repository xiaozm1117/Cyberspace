package cn.aa.mapper;

import org.apache.ibatis.annotations.Param;

import cn.aa.pojo.Admin;
import cn.aa.pojo.Video;

public interface VideoMapper {
	
	public int getStreamData(@Param(value = "id") int id);
	public String[] videos(@Param(value = "adminId")int adminId,  @Param(value = "page")int page);
	public Video[] liuLan(@Param("number")int number,@Param("page") int page);
	public int videosnumber(@Param("startId")int startId);
	public long getCount();
	public int getTextCount();
	public void faBu(Video video);

}
