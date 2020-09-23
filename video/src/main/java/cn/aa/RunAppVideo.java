package cn.aa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@MapperScan("cn.aa.mapper")
@EnableEurekaClient
@EnableAutoConfiguration(exclude = { MultipartAutoConfiguration.class })
@EnableZuulProxy
public class RunAppVideo {
	
	
	public static void main(String[] args) {
		SpringApplication.run(RunAppVideo.class, args);
	}
	
	
	
	 @Bean(name = "multipartResolver") 
	 public MultipartResolver multipartResolver() { 
		 CommonsMultipartResolver resolver = new CommonsMultipartResolver(); 
		 resolver.setDefaultEncoding("UTF-8");
		 resolver.setMaxInMemorySize(-1);
	  
		 return resolver; 
	}
	 
	 @Bean
		public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
			ServletRegistrationBean bean = new ServletRegistrationBean(dispatcherServlet);
			bean.addUrlMappings("*.html");
			bean.addUrlMappings("*.do");
			
			return bean;
		}
	
}
