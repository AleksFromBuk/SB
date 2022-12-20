package com.example.demojvalidation;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;


public class Person {

    @Size(min = 2, max = 50)
    private String name;

    @Digits(integer = 3, fraction = 0, message = "No more than 3 characters")

    private Integer age;

    public Person() {
        super();
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
