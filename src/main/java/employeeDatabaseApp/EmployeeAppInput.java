package employeeDatabaseApp;

import dtos.EmployeeRequestDTO;
import dtos.EmployeeResponseDTO;
import exceptions.*;
import services.EmployeeService;
import validateInvalidInput.ValidateInput;

import java.util.List;
import java.util.Scanner;

public class EmployeeAppInput {

    Scanner sc ;
    EmployeeService employeeService;

    public EmployeeAppInput() {

        this.sc = new Scanner(System.in);
        this.employeeService = new EmployeeService();
    }

    public  void addEmployeeDetails() { //to add employee details

        EmployeeRequestDTO employeeRequestDTO = new EmployeeRequestDTO();

        try{
            System.out.println("Please Enter the Employee Id: ");
            int employeeId = ValidateInput.validateIntegerInput(sc.nextLine(),sc);

            employeeService.checkDuplicateEmployeeId(employeeId);//check for duplicate id, if id exists throws exception
            employeeRequestDTO.setEmployeeId(employeeId);

            System.out.println("Please Enter Employee Name: ");
            employeeRequestDTO.setEmployeeName( ValidateInput.validateStringInput(sc.nextLine(),sc));

            System.out.println("Please Enter Employee Department: ");
            employeeRequestDTO.setDepartment(ValidateInput.validateStringInput(sc.nextLine(),sc));

            System.out.println("Please Enter Employee Salary: ");
            double salary = ValidateInput.validateDoubleInput(sc.nextLine(),sc);
            employeeRequestDTO.setSalary(ValidateInput.validateSalary(salary));

            System.out.println("Please Enter Employee Email: ");
            employeeRequestDTO.setEmail(ValidateInput.validateEmailInput(sc.nextLine(),sc));

            System.out.println("Please Enter Employee Hire Date (YYYY-MM-DD) or press Enter for today's Date:");
            employeeRequestDTO.setHireDate(ValidateInput.validateDateInput(sc.nextLine(),sc));

           EmployeeResponseDTO employeeResponseDTO =  employeeService.addEmployee(employeeRequestDTO);

            System.out.println("-----Employee added successfully-----");
            System.out.println(employeeResponseDTO);
            System.out.println("-----------------------------");

        }catch(MaxAttemptExceededException | DetailsNotInsertedInDBException | LessThanZeroSalaryException |
               IllegalArgumentException | DuplicateEmployeeIdException exception){
            System.out.println(exception.getMessage());
        }
    }

    public void viewEmployeeById() {

        try{
            //check if data is present in db
            employeeService.checkEmployeeDetailsExists();//if database is empty throws exception

            System.out.println("Please Enter Employee Id: ");
            int id = ValidateInput.validateIntegerInput(sc.nextLine(),sc);

            EmployeeResponseDTO employeeResponseDTO = employeeService.viewEmployeeById(id); //getting employee detais

            System.out.println("------Employee Details------");
            System.out.println(employeeResponseDTO); //printing employee details in console
            System.out.println("-----------------------------");

        }catch (MaxAttemptExceededException | InvalidEmployeeIdException | DetailsNotInsertedInDBException |
                NoEmployeePresent e){
            System.out.println(e.getMessage());
        }
    }

    public void viewAllEmployeeDetails() {

        try{
            //check if data is present in db
            employeeService.checkEmployeeDetailsExists();//if database is empty throws exception

            List<EmployeeResponseDTO> employeeResponseDTOList = employeeService.viewAllEmployeeDetails(); //to view all employee detail

            System.out.println("------All Employee Details------\n");

            for(EmployeeResponseDTO employeeResponseDTO : employeeResponseDTOList){
                System.out.println(employeeResponseDTO); //printing employee details in console
                System.out.println("-----------------------------");
            }
        }catch (DetailsNotFetchedFromDBException | NoEmployeePresent e){
            System.out.println(e.getMessage());
        }
    }


    public void updateEmployeeDetails() {

        EmployeeRequestDTO employeeRequestDTO = new EmployeeRequestDTO();

        try{
            //check if data is present in db
            employeeService.checkEmployeeDetailsExists();//if database is empty throws exception

            System.out.println("Please Enter Employee Id to Update: ");
            int id = ValidateInput.validateIntegerInput(sc.nextLine(),sc);

            EmployeeResponseDTO currentEmployeeDetails = employeeService.viewEmployeeById(id);
            employeeRequestDTO.setEmployeeId(id);

            System.out.println("------Current Employee Details-----");
            System.out.println(currentEmployeeDetails);
            System.out.println("-----------------------------------");

            System.out.println("Please Enter New Employee Name: ");
            employeeRequestDTO.setEmployeeName(ValidateInput.validateStringInput(sc.nextLine(),sc));

            System.out.println("Please Enter New Department: ");
            employeeRequestDTO.setDepartment(ValidateInput.validateStringInput(sc.nextLine(),sc));

            System.out.println("Please Enter New Employee Salary: ");
            double salary = ValidateInput.validateDoubleInput(sc.nextLine(),sc);
            employeeRequestDTO.setSalary(ValidateInput.validateSalary(salary));

            System.out.println("Please Enter New Employee Email: ");
            employeeRequestDTO.setEmail(ValidateInput.validateEmailInput(sc.nextLine(),sc));

            System.out.println("Please Enter New Employee Hire Date (YYYY-MM-DD) or press Enter for today's Date:");
            employeeRequestDTO.setHireDate(ValidateInput.validateDateInput(sc.nextLine(),sc));

            EmployeeResponseDTO updatedEmployee = employeeService.updateEmployeeDetails(employeeRequestDTO);

            System.out.println("------Employee Details Updated Successfully!-----");
            System.out.println(updatedEmployee);
            System.out.println("-----------------------------------");



        }catch (DetailsNotUpdateInDBException | NoEmployeePresent  | InvalidEmployeeIdException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteEmployeeDetails() {

        try{
            //check if data is present in db
            employeeService.checkEmployeeDetailsExists();//if database is empty throws exception

            System.out.println("Please Enter Employee Id: ");
            int employeeId = ValidateInput.validateIntegerInput(sc.nextLine(),sc);

             employeeService.viewEmployeeById(employeeId); //check employee exists

           EmployeeResponseDTO deletedEmployee =  employeeService.deleteEmployeeDetails(employeeId);

            System.out.println("------Employee Deleted Successfully!-----");
            System.out.println(deletedEmployee);
            System.out.println("-----------------------------------");




        }catch (MaxAttemptExceededException | InvalidEmployeeIdException | DetailsNotDeletedFromDBException |
                NoEmployeePresent e){
            System.out.println(e.getMessage());
        }
    }
}
