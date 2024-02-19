package com.jy.boot3;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class Boot3ApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void set() {
        redisTemplate.boundValueOps("name").set("zhangsan");
    }

    @Test
    public void get() {
        Object name = redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }



}
