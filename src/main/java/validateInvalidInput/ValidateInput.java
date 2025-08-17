package validateInvalidInput;

import exceptions.MaxAttemptExceededException;
import exceptions.LessThanZeroSalaryException;

import java.sql.Date;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class ValidateInput {

    //to validate integer input with retry limit
    public static Integer validateIntegerInput(String input,Scanner sc ){

        int attempt = 0;        //initializing variable for max limit

        while(attempt < 3){     // loop for retry limit
            try{
                return Integer.parseInt(input);     //converting string to integer, if input is character it will catch exception
            }catch (NumberFormatException e ){

                attempt = attempt+1;        //incrementing attempt
                System.out.println("Invalid input!");

                if(attempt < 3){
                    System.out.println("Please Enter Numeric value! Try again: ");
                    input = sc.nextLine(); //taking input
                }

            }
        }
        //if the limit exceed throwing exception
        throw new MaxAttemptExceededException("Max Attempt Exceeded! Returning to Main Menu");

    }

    //to validate string input with retry limit ,it allows string with number
    public static String validateStringInput(String  input,Scanner sc) {

        int attempt = 0;        // initializing variable for max limit

        while(attempt < 3){     // a loop for retry limit

               // input allow letters, numbers, and spaces and reject empty input
            if(!input.isEmpty() && input.matches("[a-zA-Z0-9 ]+")){
                   return  input;
            }
            else{
                attempt = attempt+1;
                System.out.println("Invalid input!");

                if(attempt < 3){
                    System.out.println("Please enter only letters, numbers, and spaces");
                    System.out.println("Try again: ");
                    input = sc.nextLine();
                }
            }
        }

        throw  new MaxAttemptExceededException("Max Attempt Exceeded! Returning to Main Menu");

    }
    // to validate double input
    public static Double validateDoubleInput(String input,Scanner sc) {

        int attempt = 0;   // initializing variable for max limit

        while(attempt < 3){

            try{
                return Double.parseDouble(input); //converting string_double to double , if character then exception
            } catch (NumberFormatException e) {

                attempt = attempt+1;    //incrementing attempt
                System.out.println("Invalid Input!");

                if(attempt < 3){
                    System.out.println("Please Enter Numeric value! Try again: ");
                    input = sc.nextLine();
                }
            }

        }
        //to throw exception
        throw new MaxAttemptExceededException("Max Attempt Exceeded! Returning to Main Menu");
    }

    //to validate and retry date input
    public static  Date validateDateInput(String input,Scanner sc) {

        int attempt =0;         // initializing variable for max limit

        while(attempt < 3){

            if(input.isEmpty()){
                return new Date(System.currentTimeMillis());
            }
            try{
                return Date.valueOf(input); // valid date,it checks for wrong date format, also throws exception if string is entered

            }catch (IllegalArgumentException e){

                attempt = attempt +1;
                System.out.println("Invalid Input!");

                if(attempt < 3){
                    System.out.println("Please Enter Date (YYYY-MM-DD) or press Enter for today's Date:");
                    input = sc.nextLine();
                }
            }
        }

        throw new MaxAttemptExceededException("Max Attempt Exceeded! Returning to Main Menu");
    }

    public static double validateSalary(double salary) { //salary should be greater than zero

       if(salary <= 0){
           throw  new LessThanZeroSalaryException("Salary must be greater than 0!");
       }
        return salary;

    }

    public static String validateEmailInput(String input, Scanner sc){

        int attempt = 0;
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"; //it checks the email format is correct(user@gamil.com)

        while(attempt < 3){

            if(input != null && input.matches(emailRegex)){
                return input;
            }
            else{
                attempt = attempt+1;
                System.out.println("Invalid Email format!");

                if(attempt < 3){
                    System.out.println("Please Enter valid Email: ");
                    input = sc.nextLine();
                }
            }
        }

        throw  new MaxAttemptExceededException("Max Attempt Exceeded! Returning to Main Menu");
    }
}
