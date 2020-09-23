package cn.aa.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.netflix.ribbon.proxy.annotation.Var;

import cn.aa.pojo.Admin;
import cn.aa.pojo.Video;
import cn.aa.service.VideoService;
import cn.aa.service.VideoServiceImpl;
import cn.aa.tool.Result;


@RestController
public class VideoController {
	@Autowired
	private VideoServiceImpl videoServiceImpl;

	@RequestMapping("/s")
	public void getStreamData(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Cache-Control","no-cache"); 
		System.out.print(11111);
	}

	@RequestMapping("/liuLan")
	public Video[] liuLan(@RequestParam("page") int page,@RequestParam("startId")int startId){
		return videoServiceImpl.liuLan(page,startId);
	}
	
	
	@RequestMapping("/faBu")
	public Result faBu(String title,String text,int adminId,@RequestBody(required=false) MultipartFile file,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Cache-Control","no-cache"); 
		try {
			videoServiceImpl.faBu(title,text,adminId, file);
			return new Result("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Result("fail");
	}
	
	@RequestMapping("/doSouSuo")
	public List<Video> findItemByKey(@RequestParam("key") String key,@RequestParam("page") int page){
		return videoServiceImpl.findItemByKey(key,page);
	}
	@RequestMapping("/solrCount")
	public Long solrCount(@RequestParam("key") String key){
		return videoServiceImpl.solrCount(key);
	}
	
	@RequestMapping("/getCount")
	public long getCount() {
		return videoServiceImpl.getCount();
	}
}
