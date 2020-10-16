package com.lhh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@ServletComponentScan("com.lhh.myconfig")
@SpringBootApplication
@MapperScan("com.lhh.dao")
public class MyvoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyvoteApplication.class, args);
    }

}
