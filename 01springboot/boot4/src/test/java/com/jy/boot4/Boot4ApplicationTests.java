package com.jy.boot4;

import com.jy.boot4.mapper.StuMapper;
import com.jy.boot4.mapper.StuXmlMapper;
import com.jy.boot4.domain.Stu;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class Boot4ApplicationTests {

    @Autowired
    private StuMapper stuMapper;

    @Autowired
    private StuXmlMapper stuXmlMapper;



    @Test
    void  TestFindAll() {
        List<Stu> all = stuMapper.findAll();
        System.out.println(all);
    }

    @Test
    void  TestFindAll2() {
        List<Stu> all = stuXmlMapper.findAll();
        System.out.println(all);
    }

}
