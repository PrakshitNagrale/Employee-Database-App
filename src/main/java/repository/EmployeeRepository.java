package repository;

import models.Employee;

import java.util.List;

public interface EmployeeRepository {

    boolean addEmployeeDetails(Employee employee);
    Employee getEmployeeDetailsById(int employeeId);
    List<Employee> getAllEmployeeDetails();
    boolean updateEmployeeDetails(Employee employee);
    boolean deleteEmployeeDetails(int employeeId);
}
