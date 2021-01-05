package com.ming01.houseRenting.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.ming01.houseRenting.mapper") // this will scan those Interfaces are not annotated with @Mapper
@Configuration
public class MybatisConfig {
    public MybatisConfig() {
        System.out.println("MybatisConfig");
    }
}
