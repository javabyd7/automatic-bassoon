package pl.sda.jdbc;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * Hello world!
 *
 */
public class App 
{
   static{
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
   }
    public static void main( String[] args )  {
        Connection connection=null;
        try {
           connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db?serverTimezone=UTC", "root","root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement= null;
        try {
            statement=connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql="select * from employees";
        try {
             ResultSet resultSet = statement.executeQuery(sql);
             while (resultSet.next()){
                 System.out.println("Imie "+resultSet.getString("firstName"));
                 System.out.println("employee number "+resultSet.getString("employeeNumber"));
                 System.out.println("LastName "+resultSet.getString("lastName"));
                 System.out.println("extensoin "+resultSet.getString("extension"));
                 System.out.println("email "+resultSet.getString("email"));
                 System.out.println("officeCode "+resultSet.getString("officeCode"));
                 System.out.println("reportsTo "+resultSet.getString("reportsTo"));
                 System.out.println("jobTitle "+resultSet.getString("jobTitle"));
             }

             String insert = "insert into employees(employeeNumber,lastName,"+"firstName,extension,email,officeCode,reportsTo,jobTitle)"+
                     "values (?,?,?,?,?,?,?,?)";
             PreparedStatement preparedStatement= connection.prepareStatement(insert);
             preparedStatement.setInt(1,10000);
             preparedStatement.setString(2,"NoweImie");
             preparedStatement.setString(3,"NoweImie");
             preparedStatement.setString(4,"NoweImie");
             preparedStatement.setString(5,"NoweImie");
             preparedStatement.setInt(6,4);
             preparedStatement.setInt(7,1002);
             preparedStatement.setString(8,"NoweImie");

             preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
