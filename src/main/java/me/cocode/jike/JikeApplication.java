package me.cocode.jike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "me.cocode.jike.dao")
public class JikeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JikeApplication.class, args);
    }

}
