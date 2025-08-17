package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    public static Connection getDbConnection(){

        String url =  "jdbc:mysql://127.0.0.1:3306/employee_database";
        String user = "root";
        String password = "prakshit01";

        Connection  connection;
        try {
            connection = DriverManager.getConnection(url, user, password);//establishing connection between java and mysql

//                System.out.println("Connection Established!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        return connection;



    }




}
