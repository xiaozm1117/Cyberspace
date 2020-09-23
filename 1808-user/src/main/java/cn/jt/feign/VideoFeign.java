package cn.jt.feign;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.netflix.ribbon.proxy.annotation.Var;

import cn.jt.pojo.Video;

@FeignClient("video")		//指向服务提供者
public interface VideoFeign {
	
	@RequestMapping("/s")
	public void getStreamData(@RequestParam("h") int h);
	
	@RequestMapping("/videos")
	public String[] videos(@RequestParam("adminId") int adminId, @RequestParam("page")int page);
	

	@RequestMapping("/liuLan")
	public Video[] liuLan(@RequestParam("page") int page, @RequestParam("startId")int startId);
	
	@RequestMapping("/getCount")
	public long getCount();
	
	@RequestMapping("/doSouSuo")
	public List<Video> findItemByKey(@RequestParam("key") String key,@RequestParam("page") int page);
	@RequestMapping("/solrCount")
	public Long solrCount(@RequestParam("key") String key);
	
}





