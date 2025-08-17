## Employee Management System (Java + JDBC)

- A console-based Java application that manages employee records with CRUD operations (Create, Read, Update, Delete).
- This project demonstrates OOP principles, JDBC database connectivity, exception handling, input validation, and custom exceptions

## Features

- Add Employee – Insert new employee details into the database.
- View Employee By ID – Fetch employee details using employee ID.
- View All Employees – Display all employee records from the database.
- Update Employee – Modify existing employee details.
- Delete Employee – Remove employee details by ID.
- Input Validation – Validate name, department, email, salary, and date inputs.
- Custom Exceptions – For invalid input, salary constraints, database errors, and not found cases.

## Tech Stack

- Java (JDK 17+)
- JDBC – Database connectivity 
- MySQL – Backend database 
- OOP Principles – Encapsulation, Abstraction, Exception Handling 
- Custom Exceptions – For meaningful error handling

src/

- employeeApp/     ------------>         # Main app controller (menu-driven)
- employeeService/     ------------>      # Service layer interfaces & implementations 
- employeeRepository/   ------------>          # Repository layer (JDBC CRUD operations)
- dtos/          ------------>                 # Data Transfer Objects (Request & Response DTOs) 
- exceptions/   ------------>                  # Custom exceptions 
- models/       ------------>                  # Employee model (POJO)
- util/        ------------>                   # Utility classes (DB connection, input validation)

## Custom Exceptions

- MaxAttemptExceededException – Thrown when user exceeds max retry attempts. 
- DetailsNotAddedInDBException – When insert operation fails.
- EmployeeNotFoundException – When requested employee ID doesn’t exist. 
- LessThanZeroSalaryException – When salary entered is negative.

## How It Works

- Application starts with a menu-driven interface in console:

-----------------------------------------
- 1.Add Employee Details 
- 2.View Employee Details By Id 
- 3.View All Employee Details
- 4.Update Employee Details   
- 5.Delete Employee Details   
- 6.Exit                             
-----------------------------------------


- User selects an option → Input is validated → Request goes through Service → Repository → Database.

- Appropriate success/error messages are shown.

## Example Output

- ====================================== 
-      WELCOME TO EMPLOYEE DATABASE      
- ======================================
-----------------------------------------
- 1.Add Employee Details
- 2.View Employee Details By Id
- 3.View All Employee Details
- 4.Update Employee Details
- 5.Delete Employee Details
- 6.Exit
-----------------------------------------

- Please select the option to perform (1-6)
1 
- Please Enter the Employee Id:
1 
- Please Enter Employee Name:
Jay 
- Please Enter Employee Department:
Computer 
- Please Enter Employee Salary:
7778 
- Please Enter Employee Email:
jay@gmail.com 
- Please Enter Employee Hire Date (YYYY-MM-DD) or press Enter for today's Date:

-----Employee added successfully----- 
- Employee Id   :1 
- Employee Name :Jay 
- Department    :Computer 
- Salary        :7778.0
- Email         :jay@gmail.com 
- HireDate      :2025-08-17
-----------------------------
-----------------------------------------
- 1.Add Employee Details
- 2.View Employee Details By Id
- 3.View All Employee Details
- 4.Update Employee Details
- 5.Delete Employee Details
- 6.Exit
-----------------------------------------
- Please select the option to perform (1-6)
5
- Please Enter Employee Id:
1

------Employee Deleted Successfully!----- 
- Employee Id   :1
- Employee Name :Jay
- Department    :Computer
- Salary        :7778.0
- Email         :jay@gmail.com
- HireDate      :2025-08-17

