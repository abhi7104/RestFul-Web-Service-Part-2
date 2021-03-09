package com.Application.webService.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("/dynamic-filtering")
    @ApiModelProperty(notes = "Dynamic filtering of Password  field")
    public MappingJacksonValue retrieveStudent(){
       List<StudentBean> list = Arrays.asList(new StudentBean("abhi","abhipass"),
               new StudentBean("nitin","nitinpass"));
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("username");
        FilterProvider filters =new SimpleFilterProvider().addFilter("StudentBeanFilter",filter);
        MappingJacksonValue mapping= new MappingJacksonValue(list);
        mapping.setFilters(filters);

       return mapping;
    }
    @GetMapping("/static-filtering")
    @ApiModelProperty(notes = "Static filtering of Password  field")
    public List<StudentBean> retrieveStudentDetails(){
        return Arrays.asList(new StudentBean("abhi","abhipass"),
                new StudentBean("nitin","nitinpass"));
    }
}
