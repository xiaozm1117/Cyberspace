package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer		//标识是一个EurekaServer，内部会启动相关服务
public class RunAppEureka {

	public static void main(String[] args) {
		SpringApplication.run(RunAppEureka.class, args);
	}

}
