package com.itheima.mp.service;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.mp.domain.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IUserServiceTest {


    @Autowired
    private IUserService iUserService;


    @Test
    void testInsert() {
        User user = new User();
        user.setUsername("dada");
        user.setPassword("123");
        user.setPhone("18688990011");
        user.setBalance(200);
        //user.setInfo("{\"age\": 24, \"intro\": \"英文老师\", \"gender\": \"female\"}");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        iUserService.save(user);
    }

    @Test
    void testQuery(){
        List<User> users = iUserService.listByIds(List.of(1, 2, 3));
        users.forEach(System.out::println);
    }

    @Test
    void testPageQuery(){
        int pageNo=1 ,pageSize=2;
        //分页条件
        Page<User> page = Page.of(pageNo, pageSize);
        //排序条件
        page.addOrder(new OrderItem("balance",true));
        page.addOrder(new OrderItem("id",true));

        Page<User> p = iUserService.page(page);
        //解析
        long total = p.getTotal();
        System.out.println(total);
        long pages = p.getPages();
        System.out.println(pages);
        List<User> users = p.getRecords();
        users.forEach(System.out::println);
    }


}