package cn.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@SpringCloudApplication
@EnableFeignClients

public class RunAppJtUser {

	public static void main(String[] args) {
		SpringApplication.run(RunAppJtUser.class, args);
	}
	
	@Bean
	public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
		ServletRegistrationBean bean = new ServletRegistrationBean(dispatcherServlet);
		bean.addUrlMappings("*.html");
		bean.addUrlMappings("/service/*");
		bean.addUrlMappings("*.css");
		bean.addUrlMappings("*.js");
		bean.addUrlMappings("*.png");
		bean.addUrlMappings("*.gif");
		bean.addUrlMappings("*.ico");
		bean.addUrlMappings("*.jpeg");
		bean.addUrlMappings("*.jpg");
		
		return bean;
	}
}
