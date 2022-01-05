package com.employee.EmployeeApplication.Controller;

import com.employee.EmployeeApplication.Entity.Employee; //Add this package for Employee entity class..
import com.employee.EmployeeApplication.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller //help us marked as a controller
@ResponseBody

//@RestController //It is combined @Controller and @Responsebody Annotation

public class EmployeeController {

    @Autowired //Which checks there is dependency for this file....
    EmployeeService employeeService;

//    @RequestMapping("/employees")  //Default request type is Get
    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {

        return employeeService.getAllEmployees();
    }

//    @RequestMapping("/employees/{id}")
    @GetMapping("/employees/{id}")
    public Employee findAnEmployee(@PathVariable int id){
        return employeeService.getAnEmployee(id);
    }


//    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
    }

//    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

//    @RequestMapping(value = "employees/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/employees/{id}")
    public List<Employee> deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return employeeService.getAllEmployees();
    }
}
