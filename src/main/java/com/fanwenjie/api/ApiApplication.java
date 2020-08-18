package com.fanwenjie.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ApiApplication {

    static String DATA_PATH;
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
        System.out.println("=============================================");
        System.out.println("|请将要读取文件存放在"+"'"+DATA_PATH+"'|");
        System.out.println("=============================================");
        System.out.println("");
    }
    @Value("${properties.path}")
    public void setDATA_PATH(String path){
        DATA_PATH = path;
    }

}
