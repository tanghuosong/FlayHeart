package com.fly.heart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlyHeartApplication {

	public FlyHeartApplication(){
		System.out.println("启动服务器......");
	}
	public static void main(String[] args) {
		SpringApplication.run(FlyHeartApplication.class, args);
	}
}
