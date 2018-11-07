/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3_db;


import Assignment3_beans.Login_bean;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.regex.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;



/**
 *
 * @author Jianzhi
 */
public class Login_db {
    
    public String authorizeLogin(Login_bean login_bean) //create authorizeLogin()function
    {   
        //store username from login_bean
        String username=login_bean.getUsername(); 
        //store password from login_bean
        String password=login_bean.getPassword(); 
        
        //creat variable for username to access the database
        String dbusername="";  
        String dbpassword="";
        //connect to the database
        String connectionURL = "jdbc:derby://localhost:1527/JianzhiLi"; 
        
        try
        {
           Class.forName("org.apache.derby.jdbc.ClientDriver");
           // Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection(connectionURL, "IS2560", "IS2560");   
            //load driver
            //Class.forName("org.apache.derby.jdbc.ClientDriver"); 
            //create connection
            
           
            //sent SQL query to the database
            PreparedStatement ps=null; //create statement
            //SQL for select the username and password
            String query = "SELECT * FROM IS2560.USERS WHERE username=? AND password=?";
            ps=conn.prepareStatement(query); 
            ps.setString(1,username);
            ps.setString(2,password);
            //excute query
            ResultSet rs=ps.executeQuery(query); 
            /*
            while(rs.next())
            {    
                //fetch username and password from the variable we created above which is dbusername nad dbpassword
                dbusername=rs.getString("username");  
                dbpassword=rs.getString("password"); 
                
                //see if the user input matched both the username and password
                if(username.equals(dbusername) && password.equals(dbpassword))  
                {
                    // if the username and password matched the data in database then the user is able to successfully login
                    return "You are successfully login"; 
                }
            } 
           //close prepared statement
            ps.close(); 
            //close connection
            conn.close(); 

          */
             if (rs.next()) {
                System.out.println("Correct login credentials");
            } 
            else {
                System.out.println("Incorrect login credentials");
            }
            

        
        }  catch (Exception ex) {
 System.out.println("Connect failed ! ");
 }
        //if either or both the input of username or password is incorrect the meesage below will show up to the user
        return "Your username or password is incorrect, please try again.";
    }
    
}
