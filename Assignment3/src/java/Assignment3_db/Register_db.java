/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3_db;

import Assignment3_beans.Register_bean;

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
public class Register_db {

    private Object logger;

    public String authorizeRegister(Register_bean register_bean)
    {
        
        String email = register_bean.getEmailAddress();
        String username = register_bean.getUsername();
        String password = register_bean.getPassword();
        String connectionURL = "jdbc:derby://localhost:1527/JianzhiLi"; 
     
    try
    {       
           Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            PreparedStatement ps=null; //create statement
            //Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection(connectionURL, "IS2560", "IS2560"); 
            System.out.println("Connect successfully ! ");
            String query = "INSERT INTO IS2560.USERS(username,email,password) values (?,?,?)";
            ps = conn.prepareStatement(query); //Insert user details into the table 'USERS'
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            
            
            ResultSet rs= ps.executeQuery(query);
            while(rs.next()){
            System.out.println(rs.getInt("user_id")+"\t"+rs.getString("username"));
            }
            
            System.out.println("successfuly inserted");
            rs.close();
            conn.close();
            
 }catch(Exception ex)
 {
 ex.printStackTrace();

 }
 
 return "There is something wrong, please try again.";  // On failure, send a message from here.
 }
        
 }
            