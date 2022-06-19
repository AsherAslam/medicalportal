package com.hospital.api.DAO;

import java.sql.*;

public class DBService {

    public static Connection con;

//Commenting the static-initializer block because it only open connection for once
//Such that when another query is fired the connection is already closed giving the error:
//  (java.sql.SQLNonTransientConnectionException: No operations allowed after connection closed.)
//So, We need a way to open connection each time a query is fired.

//       static{
//           try {
//               //load the driver
//               Class.forName("com.mysql.jdbc.Driver");
//               //create the connection
//                con= DriverManager.getConnection(
//                       "jdbc:mysql://localhost:3306/hms_db","root","");
//
//           } catch (Exception e) {
//               e.printStackTrace();
//           }
//
//       }
    public static void createConnection(){
        try {
               //load the driver
               Class.forName("com.mysql.cj.jdbc.Driver");
               //create the connection
                con= DriverManager.getConnection(
                       "jdbc:mysql://localhost:3306/hms_db","root","1234");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
       
    public static ResultSet query(String query) throws ClassNotFoundException, SQLException {

        createConnection();
        try{
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            return rs;
        }
        catch(Exception e){
            System.out.println(e);
        }
            return null;
    }

    public static void dmlQuery(String query) throws ClassNotFoundException, SQLException {

        createConnection();
        try{
            Statement stmt=con.createStatement();
            stmt.executeUpdate(query);

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
