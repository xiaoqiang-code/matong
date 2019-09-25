package com.matong.lq.matong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.matong.lq.matong.mapper")
public class MatongApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatongApplication.class, args);
    }

}
