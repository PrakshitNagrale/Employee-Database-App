package dtos;

import java.sql.Date;

public class EmployeeResponseDTO {

    private int employeeId;
    private String employeeName;
    private String department;
    private double salary;
    private String email;
    private Date hireDate;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return  "Employee Id   :" + this.employeeId +
                "\nEmployee Name :" + this.employeeName +
                "\nDepartment    :" + this.department +
                "\nSalary        :" + this.salary +
                "\nEmail         :" + email +
                "\nHireDate      :" + hireDate;
    }
}
