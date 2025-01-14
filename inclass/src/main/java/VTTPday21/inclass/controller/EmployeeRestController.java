package VTTPday21.inclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import VTTPday21.inclass.model.Employee;
import VTTPday21.inclass.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> emp = employeeService.getAllEmployees();
        return ResponseEntity.ok().body(emp);
    }



    

}
