package com.xll.pattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 *
 * @Author：xuliangliang
 * @Description：设计模式学习
 * @Date 2020/8/28
 */
@Slf4j
@SpringBootApplication
public class PatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatternApplication.class, args);
        log.info("启动成功");
    }
}
