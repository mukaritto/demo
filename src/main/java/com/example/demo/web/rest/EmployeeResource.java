package com.example.demo.web.rest;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity create(@RequestBody Employee employee){
        Employee result = employeeService.save(employee);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/employees")
    public ResponseEntity update(@RequestBody Employee employee){
        if(employee.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        Employee result = employeeService.save(employee);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity get(@PathVariable Long id){
        Employee result = employeeService.get(id);
        return ResponseEntity.ok(result);
    }
}
