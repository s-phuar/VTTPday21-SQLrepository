package VTTPday21.inclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VTTPday21.inclass.model.Employee;
import VTTPday21.inclass.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepo;
    

    public List<Employee> getAllEmployees(){
        return employeeRepo.getAllEmployees();
    }






}
