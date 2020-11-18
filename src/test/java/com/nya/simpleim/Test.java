package com.nya.simpleim;

import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootTest
public class Test {
    @org.junit.jupiter.api.Test
    void test(){
        Timestamp ts = Timestamp.valueOf(LocalDateTime.now());
        System.out.println(ts);
    }
}
