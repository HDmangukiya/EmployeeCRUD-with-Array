package com.employee.EmployeeApplication.Repository;

import com.employee.EmployeeApplication.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /*CRUD Operation*/

  /*
   * getAlLEmployees ();
   * getEmployee(id);
   * updateEmployee (Employee employee)
   * deleteEmployee (Employee employee)
   * */


}
