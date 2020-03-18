package com.liwei.chainresponsibility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

//注意此处是引入tk.mybatis.spring.annotation.MapperScan
@MapperScan("com.liwei.chainresponsibility.mapper")
@SpringBootApplication
public class ChainResponsibilityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChainResponsibilityApplication.class, args);
    }

}
