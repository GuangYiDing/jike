package me.cocode.jike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "me.cocode.jike.dao")
public class JikeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JikeApplication.class, args);
    }

}
