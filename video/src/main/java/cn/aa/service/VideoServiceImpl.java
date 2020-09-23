package cn.aa.service;


import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import cn.aa.mapper.VideoMapper;
import cn.aa.pojo.Video;
import cn.aa.tool.MyHttpSolrClient;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoMapper videoMapper;
	@Autowired
	private MyHttpSolrClient myHttpSolrClient;

	public void faBu(String title,String text, int adminId, MultipartFile file) {
		Video video = new Video();
		
		if (file != null) {
			String fileName = file.getOriginalFilename();
			// 获取文件后缀名
			String suffixName = fileName.substring(fileName.lastIndexOf("."));
			String filePath = "";
			String newName =UUID.randomUUID().toString().replace("-","");
			if (suffixName.equals(".mp4")) {
				// 指定本地文件夹存储图片
				filePath = "D:/media/video";
				video.setType("video");
				video.setContent("/upload/video/" + newName + suffixName);
				
			} else if (suffixName.equals(".png")) {
				filePath = "D:/media/picture";
				video.setType("img");
				video.setContent("/upload/picture/" + newName + suffixName);
			} else if (suffixName.equals(".mp3")) {
				filePath = "D:/media/audio";
				video.setType("audio");
				video.setContent("http://resource.com/audio/" + newName + suffixName);
			}
			try {
				file.transferTo(new File(filePath + "/" + newName + suffixName));
			} catch (Exception e) {
				throw new RuntimeException();

			}
			
		}
		
		
		// text
		if (text != null) {
			String textPath = "D:/media/text/" + UUID.randomUUID().toString().replace("-","");
			write11(textPath, text);
			video.setText(textPath);
		}
		
		
		video.setTitle(title);
		video.setCreateTime(new Date());
		video.setAdminId(adminId);
		video.setPingLun(0);
		video.setShouCang(0);
		video.setDianZan(0);
		try {
			videoMapper.faBu(video);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	/*
	 * public String[] videos(int adminId, int page) { try { return
	 * videoMapper.videos(adminId, page + 5 * (page - 1));
	 * 
	 * } catch (Exception e) { throw new RuntimeException(); }
	 * 
	 * }
	 */

	public Video[] liuLan(int page, int startId) {
		try {
			int number;
			if (startId != 0) {
				number = videoMapper.videosnumber(startId);
			} else {
				number = 1;
			}
			Video[] vL = videoMapper.liuLan(number, (page - 1) * 5);
			for (Video v : vL) {
				v.setText(readText(v.getText()));
			}
			return vL;
			// return videoMapper.liuLan((page-1)*15+1);

		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public long getCount() {
		try {
			return videoMapper.getCount();

		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public String readText(String fileName) {
		if (fileName == null) {
			return "";
		}
		File file = new File(fileName);
		BufferedReader reader = null;
		StringBuffer sbf = new StringBuffer();
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempStr;
			while ((tempStr = reader.readLine()) != null) {
				sbf.append(tempStr);
			}
			reader.close();
			return sbf.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return sbf.toString();
	}

	public void write11(String DatePath, String content) {
		FileWriter fwriter = null;
		try {
			// true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
			fwriter = new FileWriter(DatePath, true);
			fwriter.write(content);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fwriter.flush();
				fwriter.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public List<Video> findItemByKey(String key,int page) {
		try {
			SolrQuery query=new SolrQuery(key);
			query.setStart(6 * (page - 1));//从那一行开始取数据
			query.setRows(6);//取6行。
			QueryResponse response=myHttpSolrClient.getHttpSolrClient().query(query);
			List<Video> itemList=response.getBeans(Video.class);
			for (Video v : itemList) {
				v.setText(readText(v.getText()));
			}
			return itemList;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}
	public Long solrCount(String key) {
		try {
			SolrQuery query=new SolrQuery(key);
			QueryResponse response=myHttpSolrClient.getHttpSolrClient().query(query);
			Long count=response.getResults().getNumFound();
			return count;
			//return itemList;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	
	
}
