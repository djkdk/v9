package com.qianfeng.v9indexweb;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class V9IndexWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(V9IndexWebApplication.class, args);
	}

}
