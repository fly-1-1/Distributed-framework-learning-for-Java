package com.jy.boot02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Boot02Application.class)
public class UserServiceTest {


    @Autowired
    private UserService userService;

    @Test
    public void testadd(){
        userService.add();
    }

}
