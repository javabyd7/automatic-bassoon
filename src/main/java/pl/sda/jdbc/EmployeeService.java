package pl.sda.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Scanner;

public class EmployeeService {
    static{
        System.out.println("1.Dodaj użytkownika");
        System.out.println("2.Wyśiwetl wszystkich użytkowników");
        Scanner scanner=new Scanner(System.in);
        int chose=scanner.nextInt();
        if(chose==1){
            try {
                addEmployee();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(chose==2){
            printAllEmployees();
        }
    }

    public static void addEmployee() throws SQLException {
        String insert = "insert into employees(employeeNumber,lastName,"+"firstName,extension,email,officeCode,reportsTo,jobTitle)"+
                "values (?,?,?,?,?,?,?,?)";
        Scanner scanner=new Scanner(System.in);
        int intPar;
        String stringPar;
        Connection connection=DBConnector.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement(insert);

        for (int i = 1; i < 9; i++) {
            System.out.println("podaj "+i+" parametr");
            if(i==1||i==6||i==7){
                System.out.println("Uwaga parametr powinien być intem!");
                intPar=scanner.nextInt();
                preparedStatement.setInt(i,intPar);

            }else {
                System.out.println("Parametr jest Stringiem");
                stringPar=scanner.nextLine();
                preparedStatement.setString(2,stringPar);
            }

        }


    }

    public static void printAllEmployees(){

    }

}
