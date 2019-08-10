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
    public static void main( String[] args ) throws SQLException {
        Connection connection = DBConnector.getConnection();
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




        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
