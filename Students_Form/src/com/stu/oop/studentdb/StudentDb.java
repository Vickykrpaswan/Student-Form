package com.stu.oop.studentdb;

import java.sql.Connection;
import java.sql.DriverManager;

public class StudentDb {
    
    static Connection con;
    static String driver = "org.sqlite.JDBC";
    static String url = "jdbc:sqlite:student.db";
   
    
    public static Connection getConnection() throws Exception{
        if(con == null){
            Class.forName(driver);
            con = DriverManager.getConnection(url);
        }
        return con;
    }

}