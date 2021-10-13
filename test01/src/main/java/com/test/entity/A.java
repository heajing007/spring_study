package com.test.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode
public class A implements Serializable {
    private Integer age;
    private String name;
    private String a;
    private String b;
}
