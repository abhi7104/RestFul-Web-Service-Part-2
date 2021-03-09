package com.Application.webService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@ApiModel(description = "This is EmployeeBean class")
public class EmployeeBean {
    private Integer id;
    @ApiModelProperty(notes = "Name should only contains Alphabets")
    @Pattern(regexp = "[a-zA-Z][a-zA-Z ]*")
    private String name;
    @ApiModelProperty(notes = "Age should be more then 18 year")
    @Min(value = 18,message = "Age must be above 18")
    private Integer age;

    public EmployeeBean(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmployeeBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
