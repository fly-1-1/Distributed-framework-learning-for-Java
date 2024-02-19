package com.jy.boot4.mapper;

import com.jy.boot4.domain.Stu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StuMapper {

    @Select("select * from stu")
    public List<Stu> findAll();
}
