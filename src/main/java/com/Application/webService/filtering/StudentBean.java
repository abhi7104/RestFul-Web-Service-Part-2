package com.Application.webService.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
@JsonFilter("StudentBeanFilter")
public class StudentBean {
    private String username;
    //@JsonIgnore
    private String password;

    public String getUsername() {
        return username;
    }

    public StudentBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
