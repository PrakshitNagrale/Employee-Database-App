package services;

import dtos.EmployeeRequestDTO;
import dtos.EmployeeResponseDTO;
import exceptions.*;
import mapper.EmployeeDTOMapper;
import models.Employee;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepositoryImpl();
    }

    public EmployeeResponseDTO addEmployee(EmployeeRequestDTO employeeRequestDTO){

        Employee employee = EmployeeDTOMapper.convertEmployeeRequestDTOToEmployee(employeeRequestDTO); //converting to employee

        boolean value = employeeRepository.addEmployeeDetails(employee); //inserting in database

        if(!value){
            throw  new DetailsNotInsertedInDBException("No Row Inserted!"); //if column value does not match with the input it will throw error
        }

        return EmployeeDTOMapper.convertEmployeeToEmployeeResponseDTO(employee);


    }

    public EmployeeResponseDTO viewEmployeeById(int employeeId) {

        Employee employee = employeeRepository.getEmployeeDetailsById(employeeId);//getting employee details by id

        if(employee == null){ //throw exception if employee not found
            throw  new InvalidEmployeeIdException("Invalid Employee Id! No Employee found "+"with Id: "+employeeId+"!");
        }
        return EmployeeDTOMapper.convertEmployeeToEmployeeResponseDTO(employee); //converting to response dto


    }

    //to check for duplicate employee id
    public void checkDuplicateEmployeeId(int employeeId) {

       Employee employee =  employeeRepository.getEmployeeDetailsById(employeeId);

       if(employee!=null){
           throw  new DuplicateEmployeeIdException("Employee Id Already Exists! Please Enter Different Employee Id!");
       }
    }

    public List<EmployeeResponseDTO> viewAllEmployeeDetails() {

       List<Employee> employeeList =  employeeRepository.getAllEmployeeDetails();//getting all employee details in a list

        if(employeeList.isEmpty()){ //check if list is empty
            throw  new NoEmployeePresent("Employee Not Found! No Employee Present In Database!");
        }

        List<EmployeeResponseDTO> employeeResponseDTOList = new ArrayList<>();//creating list

        for(Employee employee : employeeList){ //iterating on employee to convert in response dto
            employeeResponseDTOList.add(EmployeeDTOMapper.convertEmployeeToEmployeeResponseDTO(employee));
        }
        return employeeResponseDTOList;
    }

    public void checkEmployeeDetailsExists() {

        List<Employee> employeeList = employeeRepository.getAllEmployeeDetails();

        if(employeeList.isEmpty()){
            throw new NoEmployeePresent("Employee Details Not Found! No Employee Present In Database!");
        }
    }

    public EmployeeResponseDTO updateEmployeeDetails(EmployeeRequestDTO employeeRequestDTO) {

        Employee employee =  EmployeeDTOMapper.convertEmployeeRequestDTOToEmployee(employeeRequestDTO);

       boolean value = employeeRepository.updateEmployeeDetails(employee);

        if(!value){
            throw  new DetailsNotUpdateInDBException("No Row Updated!"); //if column value does not match with the input it will throw error
        }

        return EmployeeDTOMapper.convertEmployeeToEmployeeResponseDTO(employee);
    }

    public EmployeeResponseDTO deleteEmployeeDetails(int employeeId) {

        Employee employee = employeeRepository.getEmployeeDetailsById(employeeId);
        boolean value = employeeRepository.deleteEmployeeDetails(employeeId);

        if(!value){
            throw  new DetailsNotUpdateInDBException("Error Deleting employee Details from database!");
        }

        System.out.println("from service "+value);

        return EmployeeDTOMapper.convertEmployeeToEmployeeResponseDTO(employee);
    }
}
