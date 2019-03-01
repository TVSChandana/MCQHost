package com.sasmitha.gproject.model;

import org.springframework.stereotype.Component;

@Component
public class MyModel {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
