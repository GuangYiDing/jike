package me.cocode.jike;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class JikeApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(new Md5Hash("111111", "1111", 3).toHex());
        System.out.println(new Md5Hash("111111", "1111", 3).toString());
    }

}
