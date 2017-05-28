package com.flay.heart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlayHeartApplication {

	public FlayHeartApplication(){
		System.out.println("启动服务器......");
	}

	public static void main(String[] args) {
		SpringApplication.run(FlayHeartApplication.class, args);
	}
}
