package com.Application.webService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmployeeService {
    @Autowired
    private EmployeeDaoService service;
    @GetMapping("/employees")
    @ApiModelProperty(notes = "Fetch list of Employees in List")
    public List<EmployeeBean> retrieveAllEmployee(){
        return service.getEmployee();
    }
    @GetMapping("/employee/{id}")
    @ApiModelProperty(notes = "Fetch Employees by Id in List")
    public EntityModel<EmployeeBean> retrieveEmployeeById(@PathVariable int id)
    {
        EmployeeBean emp= service.getEmployeeById(id);
        if(emp==null)
            throw new EmployeeNotFoundException("id-"+id);
        EntityModel<EmployeeBean> resource =EntityModel.of(emp);
        WebMvcLinkBuilder linkTo= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.
                methodOn(this.getClass()).retrieveAllEmployee());
        resource.add(linkTo.withRel("List-all-employees"));

        return resource;
    }
    @PostMapping("/employees")
    @ApiModelProperty(notes = "Add Employees in a List")
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody EmployeeBean emp){
        EmployeeBean empSaved=service.saveEmployee(emp);
        URI location=ServletUriComponentsBuilder
                .fromCurrentRequest()//return current request
                .path("/{id}").//appending id to employees
                buildAndExpand(empSaved.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/employee/{id}")
    @ApiModelProperty(notes = "Delete Employee in List by Id")
    public void deleteEmployeeId(@PathVariable int id)
    {
       EmployeeBean emp= service.deleteEmployeeById(id);
       if(emp==null)
           throw new EmployeeNotFoundException("id-"+id);
    }
    @PutMapping("/employees")
    @ApiModelProperty(notes = "Update Details of Employee by id in body")
    public ResponseEntity<Object> updateEmployeeById(@Valid @RequestBody EmployeeBean emp)
    {
        EmployeeBean empUpdated= service.updateEmployeeById(emp);
        if(empUpdated==null)
            throw new EmployeeNotFoundException("Id not found");
        URI location=ServletUriComponentsBuilder
                .fromCurrentRequest()//return current request
                .path("/{id}").//appending id to employees
                buildAndExpand(empUpdated.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/employee/{id}")
    @ApiModelProperty(notes = "Update Details of Employee by id")
    public ResponseEntity<Object> updateEmployeeById1(@Valid @RequestBody EmployeeBean emp,@PathVariable int id)
    {
        EmployeeBean empUpdated= service.updateEmployeeById1(emp,id);
        if(empUpdated==null)
            throw new EmployeeNotFoundException("Id not found");
        URI location=ServletUriComponentsBuilder
                .fromCurrentRequest()//return current request
                .path("/{id}").//appending id to employees
                buildAndExpand(empUpdated.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
