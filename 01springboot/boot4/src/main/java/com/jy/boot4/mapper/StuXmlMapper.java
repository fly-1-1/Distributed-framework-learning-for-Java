package com.jy.boot4.mapper;

import com.jy.boot4.domain.Stu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StuXmlMapper {


    public List<Stu> findAll();
}
