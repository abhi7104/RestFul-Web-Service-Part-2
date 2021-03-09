package com.Application.webService.helloworld;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorld {
    @Autowired
    private MessageSource messageSource;
    @GetMapping("/hello-world")
    @ApiModelProperty(notes = "Simple Hello World")
    public String printHelloWorld(){
        return "Hello world";
    }
    @GetMapping("/hello-world-bean")
    @ApiModelProperty(notes = "Hello World by Bean")
    public HelloWorldBean getHelloWorld(){
        return new HelloWorldBean("Hello World Bean");
    }
    @GetMapping("/greeting")
    @ApiModelProperty(notes = "Greeting according to language")
    public String helloWorldInternationalized(@RequestParam(name = "name") String username){
        return messageSource.getMessage("hello.message",null, LocaleContextHolder.getLocale())+" "+username;
    }


}
