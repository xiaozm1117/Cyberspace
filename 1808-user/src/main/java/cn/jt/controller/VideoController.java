package cn.jt.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.jt.feign.VideoFeign;

import cn.jt.pojo.Video;
import cn.jt.tool.Result;


@Controller

public class VideoController {

	@Autowired
	private VideoFeign videoFeign;

	@RequestMapping("/zhuYe")
	public String homePage1() {
		return "zhuYe";
	}
	
	@RequestMapping("/liuLan")
	public String homePage2() {
		return "liuLan";
	}
	@RequestMapping("/faBu")
	public String homePage3() {
		return "faBu";
	}
		
	
	
	@RequestMapping("/doLiuLan")
	@ResponseBody
	public Result getData(int page,int startId) {
		try {
		 	
		 	Video[] data=videoFeign.liuLan(page,startId);
		 	return new Result(data); 
		} catch (Exception e) {
		 	e.printStackTrace();
		} 
		return new Result("fail"); 
	}

	
	
	
	@RequestMapping("/doSouSuo")
	public String videos(@RequestParam("key")String key,int page,Model mode) {
		
		try {
			byte[] data=key.getBytes("ISO-8859-1");
			//数据发给dubbo提供者
			//dubbo中消费者发数据给提供者用的编码是utf-8
			String q=new String(data, "UTF-8");
			//通过调用接口的抽象方法去调用微服务的提供者
			List<Video> itemList=videoFeign.findItemByKey(key,page);
			mode.addAttribute("itemList",itemList);
			mode.addAttribute("currentPage",page);
			long count=videoFeign.solrCount(key);
			mode.addAttribute("total",count);
			mode.addAttribute("key",key);
			return "souSuo";
		}catch(Exception e){
			e.printStackTrace();
		}
		//转发到search.jsp
		return null;
	}
	
	@RequestMapping("/getCount")
	@ResponseBody
	public Result getCount() {
		try {
			
			long count=videoFeign.getCount();
			return new Result(count); 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return new Result("fail"); 
	}

}
