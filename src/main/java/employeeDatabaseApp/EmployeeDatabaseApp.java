package employeeDatabaseApp;

import java.util.Scanner;

public class EmployeeDatabaseApp {

    Scanner sc;
    EmployeeAppInput employeeAppInput;

    public EmployeeDatabaseApp() {

       this.sc = new Scanner(System.in);
       this.employeeAppInput = new EmployeeAppInput();
    }

    public void startEmployeeDatabaseApplication(){

        System.out.println("======================================");
        System.out.println("    WELCOME TO EMPLOYEE DATABASE      ");
        System.out.println("======================================");


        boolean keepRunning = true;

        while(keepRunning){

            try{
                System.out.println("-----------------------------------------");
                System.out.println("|   1. Add Employee Details             |");
                System.out.println("|   2. View Employee Details By Id      |");
                System.out.println("|   3. View All Employee Details        |");
                System.out.println("|   4. Update Employee Details          |");
                System.out.println("|   5. Delete Employee Details          |");
                System.out.println("|   6. Exit                             |");
                System.out.println("-----------------------------------------");


                System.out.println("Please select the option to perform (1-6)");
                String option = sc.nextLine();
                int input = Integer.parseInt(option); // converting to string to integer, so that if user puts any string input it will give error

                switch(input){

                    case 1:
                        employeeAppInput.addEmployeeDetails();
                        break;
                    case 2:
                        employeeAppInput.viewEmployeeById();
                         break;
                    case 3:
                        employeeAppInput.viewAllEmployeeDetails();
                        break;
                    case 4:
                        employeeAppInput.updateEmployeeDetails();
                        break;
                    case 5:
                        employeeAppInput.deleteEmployeeDetails();
                        break;

                    case 6:
                        keepRunning = false;
                        System.out.println("-----------------------");
                        System.out.println("Application Terminated");
                        System.out.println("-------------------------");
                        break;

                    default:
                        System.out.println("Invalid Input! Please Enter valid input (1-6)");
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid Input! Please select valid input (1-6)");
                System.out.println("------------------------------------------------");

            }




        }




    }
}
