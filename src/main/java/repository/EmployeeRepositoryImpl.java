package repository;

import db.DBConnection;
import exceptions.DetailsNotDeletedFromDBException;
import exceptions.DetailsNotFetchedFromDBException;
import exceptions.DetailsNotInsertedInDBException;
import exceptions.DetailsNotUpdateInDBException;
import models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {


    @Override
    public boolean addEmployeeDetails(Employee employee) {
                                                                    //each '?' denotes column name
        String sql = "Insert into employees (employee_id,employee_name,department,salary,email,hire_date) values(?,?,?,?,?,?)";


        try (Connection connection =  DBConnection.getDbConnection();
            PreparedStatement preparedStatement =  connection.prepareStatement(sql)){ //try with-resource,here the resources connection & preparedStatement
                                                                                    // are automatically close ,even the exception happens.
         //setting value of '?' , 1,2,... denotes the  number of -> '?'
          preparedStatement.setInt(1,employee.getEmployeeId());
          preparedStatement.setString(2,employee.getEmployeeName());
          preparedStatement.setString(3,employee.getDepartment());
          preparedStatement.setDouble(4,employee.getSalary());
          preparedStatement.setString(5,employee.getEmail());
          preparedStatement.setDate(6,employee.getHireDate());

          int value = preparedStatement.executeUpdate();

          return value > 0;

        } catch (SQLException e) {
           throw  new DetailsNotInsertedInDBException("Error inserting employee into database! "+e.getMessage());
        }
    }



    @Override
    public Employee getEmployeeDetailsById(int employeeId) {

        String sql = "Select * from employees where employee_id = ?";

        try(Connection connection = DBConnection.getDbConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1,employeeId);
          ResultSet resultSet =  preparedStatement.executeQuery();

          if(resultSet.next()){
              Employee employee = new Employee();
              employee.setEmployeeId(resultSet.getInt("employee_id"));//putting column name
              employee.setEmployeeName(resultSet.getString("employee_name"));
              employee.setDepartment(resultSet.getString("department"));
              employee.setSalary(resultSet.getDouble("salary"));
              employee.setEmail(resultSet.getString("email"));
              employee.setHireDate(resultSet.getDate("hire_date"));

              return employee;
          }
          return null;//if the employee details are not present

        }catch (SQLException e){
            throw  new DetailsNotFetchedFromDBException("Error fetching employee from database! "+e.getMessage());
        }
    }

    @Override
    public List<Employee> getAllEmployeeDetails() {

        String sql = "Select * from employees";

        List<Employee> employeeList = new ArrayList<>(); //creating list to store employee details

        try(Connection connection = DBConnection.getDbConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery()){

        while(resultSet.next()){

            Employee employee = new Employee();//creating employee

            employee.setEmployeeId(resultSet.getInt("employee_id"));
            employee.setEmployeeName(resultSet.getString("employee_name"));
            employee.setDepartment(resultSet.getString("department"));
            employee.setSalary(resultSet.getDouble("salary"));
            employee.setEmail(resultSet.getString("email"));
            employee.setHireDate(resultSet.getDate("hire_date"));

            employeeList.add(employee); //adding employee to list
        }

        return employeeList;

        }catch (SQLException e ){
            throw  new DetailsNotFetchedFromDBException("Error fetching employee from database! "+e.getMessage());
        }

    }

    @Override
    public boolean updateEmployeeDetails(Employee employee) {

        String sql = "Update employees  Set employee_name = ?, department = ?, salary = ?, email = ?,hire_date = ? Where employee_id= ?";

        try(Connection connection = DBConnection.getDbConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1,employee.getEmployeeName());
            preparedStatement.setString(2,employee.getDepartment());
            preparedStatement.setDouble(3,employee.getSalary());
            preparedStatement.setString(4,employee.getEmail());
            preparedStatement.setDate(5,employee.getHireDate());
            preparedStatement.setInt(6,employee.getEmployeeId());

            int value = preparedStatement.executeUpdate();

            return value > 0;

        }catch (SQLException e ){
            throw  new DetailsNotUpdateInDBException("Error Updating employee into database! "+e.getMessage());
        }


    }

    @Override
    public boolean deleteEmployeeDetails(int employeeId) {

        String sql = "delete from employees where employee_id = ?";

        try(Connection connection = DBConnection.getDbConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1,employeeId);

           int value =  preparedStatement.executeUpdate();

            return value > 0;

        }catch (SQLException e ){
            throw  new DetailsNotDeletedFromDBException("Error Deleting employee Details from database! "+e.getMessage());
        }


    }
}
