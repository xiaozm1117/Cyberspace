package cn.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@MapperScan("cn.jt.mapper")
@EnableEurekaClient
public class RunAppJtUserProvider {
	
	
	public static void main(String[] args) {
		SpringApplication.run(RunAppJtUserProvider.class, args);
	}
	
}
