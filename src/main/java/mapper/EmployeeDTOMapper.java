package mapper;

import dtos.EmployeeRequestDTO;
import dtos.EmployeeResponseDTO;
import models.Employee;
import validateInvalidInput.ValidateInput;

public class EmployeeDTOMapper {

    //to convert to employee object

    public static Employee convertEmployeeRequestDTOToEmployee(EmployeeRequestDTO employeeRequestDTO){

        Employee employee = new Employee();

        employee.setEmployeeId(employeeRequestDTO.getEmployeeId());
        employee.setEmployeeName(employeeRequestDTO.getEmployeeName());
        employee.setDepartment(employeeRequestDTO.getDepartment());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setSalary(employeeRequestDTO.getSalary());
        employee.setHireDate(employeeRequestDTO.getHireDate());

        return employee;

    }

    public static EmployeeResponseDTO convertEmployeeToEmployeeResponseDTO(Employee employee){

        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();

        employeeResponseDTO.setEmployeeId(employee.getEmployeeId());
        employeeResponseDTO.setEmployeeName(employee.getEmployeeName());
        employeeResponseDTO.setDepartment(employee.getDepartment());
        employeeResponseDTO.setSalary(employee.getSalary());
        employeeResponseDTO.setEmail(employee.getEmail());
        employeeResponseDTO.setHireDate(employee.getHireDate());

        return employeeResponseDTO;
    }
}
