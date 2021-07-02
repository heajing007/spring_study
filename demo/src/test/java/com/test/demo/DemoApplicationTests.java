package com.test.demo;

import com.test.demo.config.TestConfig;
import com.test.demo.service.TestService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class DemoApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("test");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        TestService testBean = ac.getBean(TestService.class);
        System.out.println(testBean);
    }

}
