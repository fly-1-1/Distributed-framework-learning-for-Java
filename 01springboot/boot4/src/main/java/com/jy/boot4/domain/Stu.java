package com.jy.boot4.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(exclude = "id")
public class Stu {

    @Getter
    @Setter

    private int id;
    private String name;


}
