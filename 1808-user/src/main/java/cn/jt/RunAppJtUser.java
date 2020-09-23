package cn.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;

@SpringCloudApplication
@EnableFeignClients
@EnableAutoConfiguration(exclude = { MultipartAutoConfiguration.class })

public class RunAppJtUser {

	public static void main(String[] args) {
		SpringApplication.run(RunAppJtUser.class, args);
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
		ServletRegistrationBean bean = new ServletRegistrationBean(dispatcherServlet);
		bean.addUrlMappings("*.html");
		bean.addUrlMappings("*.do");
		bean.addUrlMappings("/service/*");
		bean.addUrlMappings("*.css");
		bean.addUrlMappings("*.js");
		bean.addUrlMappings("*.png");
		bean.addUrlMappings("*.gif");
		bean.addUrlMappings("*.ico");
		bean.addUrlMappings("*.jpeg");
		bean.addUrlMappings("*.jpg");
		bean.addUrlMappings("*.mp4");
		return bean;
	}


	 @Bean(name = "multipartResolver") 
	 public MultipartResolver multipartResolver() { 
		 CommonsMultipartResolver resolver = new CommonsMultipartResolver(); 
		 resolver.setDefaultEncoding("UTF-8");
		 resolver.setMaxInMemorySize(-1);
	  
		 return resolver; 
	}
	 
	
	 
	
}
