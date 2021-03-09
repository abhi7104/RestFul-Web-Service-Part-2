package com.Application.webService.helloworld;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "This is HelloWorldBean class")
public class HelloWorldBean {
    private String str;
    public HelloWorldBean(String str) {
        this.str=str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "str='" + str + '\'' +
                '}';
    }
}
