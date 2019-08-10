package pl.sda.jdbc;

import com.sun.corba.se.pept.transport.ConnectionCache;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static Connection connection=null;
    private final static String ADDRESS="jdbc:mysql://127.0.0.1";
    private final static String DATABASE="classicmodels";
    private final static String USER="root";
    private final static String PASSWORD="root";
    private final static String PORT="3306";
    private final static String DRIVER="com.mysql.cj.jdbc.Driver";
    private final static String PARAMS="serverTimezone=UTC";

    private  static String getFormatedURL(){
        return ADDRESS+":"+PORT+"/"+DATABASE+"?"+PARAMS;
    }
    private static void loadDriver(){
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void loadConnection() throws SQLException {
        connection= DriverManager.getConnection(getFormatedURL(),USER,PASSWORD);

    }
    public static Connection getConnection() throws SQLException {
        if(connection==null){
            loadDriver();
            loadConnection();
        }
        return connection;
    }
}
