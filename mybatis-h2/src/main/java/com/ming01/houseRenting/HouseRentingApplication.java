package com.ming01.houseRenting;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HouseRentingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseRentingApplication.class, args);
	}

}
