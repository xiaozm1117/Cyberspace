package cn.aa.tool;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class MyHttpSolrClient {
	@Value("${spring.data.solr.url}")
	private String baseURL;
	@Value("${spring.data.solr.timeout}")
	private int timeout;
	 
	private HttpSolrClient httpSolrClient;
	
	public HttpSolrClient getHttpSolrClient() {

		this.httpSolrClient=new HttpSolrClient(baseURL);
		this.httpSolrClient.setParser(new XMLResponseParser());
		this.httpSolrClient.setConnectionTimeout(timeout);
		return httpSolrClient;
	}

	
}
