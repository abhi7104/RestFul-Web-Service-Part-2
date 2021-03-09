package com.Application.webService.Versioning;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
    @GetMapping("/v1/person")
    @ApiModelProperty(notes = "URI based versioning v1")
    public PersonOne personV1(){
        return new PersonOne("Abhishek Bhardwaj");
    }
    @GetMapping("/v2/person")
    @ApiModelProperty(notes = "URI based versioning v2")
    public PersonTwo personV2(){
        return new PersonTwo(new Name("Abhishek","Bhardwaj"));
    }
    @GetMapping(value = "/person/param",params = "version=1")
    @ApiModelProperty(notes = "Param based versioning v1")
    public PersonOne personParamV1(){
        return new PersonOne("Abhishek Bhardwaj");
    }
    @GetMapping(value = "/person/param",params = "version=2")
    @ApiModelProperty(notes = "Param based versioning v2")
    public PersonTwo personParamV2(){
        return new PersonTwo(new Name("Abhishek","Bhardwaj"));
    }
    @GetMapping(value = "/person/header",headers = "X-API-VERSION=1")
    @ApiModelProperty(notes = "Header based versioning v1")
    public PersonOne personHeaderV1(){
        return new PersonOne("Abhishek Bhardwaj");
    }
    @GetMapping(value = "/person/header",headers = "X-API-VERSION=2")
    @ApiModelProperty(notes = "Header based versioning v2")
    public PersonTwo personHeaderV2(){
        return new PersonTwo(new Name("Abhishek","Bhardwaj"));
    }
    @GetMapping(value = "/person/produces",produces = "application/vnd.company.app-v1+json")
    @ApiModelProperty(notes = "MimeType based versioning v1")
    public PersonOne personProducesV1(){
        return new PersonOne("Abhishek Bhardwaj");
    }
    @GetMapping(value = "/person/produces",produces = "application/vnd.company.app-v2+json")
    @ApiModelProperty(notes = "MimeType based versioning v1")
    public PersonTwo personProducesV2(){
        return new PersonTwo(new Name("Abhishek","Bhardwaj"));
    }

}
