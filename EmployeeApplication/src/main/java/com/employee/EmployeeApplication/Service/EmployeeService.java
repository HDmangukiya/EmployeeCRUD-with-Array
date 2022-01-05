package com.employee.EmployeeApplication.Service;

import com.employee.EmployeeApplication.Entity.Employee;
import com.employee.EmployeeApplication.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service // Used for declaring Service class
public class EmployeeService {

        List<Employee> employeeList = new ArrayList<>( Arrays.asList(
                new Employee(1,"First Employee", "Surat"),
                new Employee(2,"Second Employee", "Auckland")
        ));

        @Autowired
        EmployeeRepository employeeRepository;

        public List<Employee> getAllEmployees(){
            //return employeeList;
            return employeeRepository.findAll();
        }

        public Employee getAnEmployee(int id){
            /*return employeeList.stream().filter(e -> (
                    e.getEmployeeId() == id)).findFirst().get();*/
            return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Find"));

        }

        public void createEmployee(Employee employee){
            //employeeList.add(employee);
            employeeRepository.save(employee);
        }

        public void updateEmployee(Employee employee){
            /*ArrayList<Employee> tempEmployee = new ArrayList<>();
            for (Employee emp : employeeList){
                if (emp.getEmployeeId() == employee.getEmployeeId()){
                    emp.setEmployeeCity(employee.getEmployeeName());
                    emp.setEmployeeCity(employee.getEmployeeCity());
                }
                tempEmployee.add(emp);
            }
            this.employeeList = tempEmployee;*/
            employeeRepository.save(employee);
        }

        public void deleteEmployee(int id){
/*
            ArrayList<Employee> tempEmployee = new ArrayList<>();
            for (Employee emp : employeeList){
                if(emp.getEmployeeId() == id)
                    continue;
                tempEmployee.add(emp);
            }
            this.employeeList = tempEmployee;
*/
            employeeRepository.delete(employeeRepository.getById(id));
        }
    }

