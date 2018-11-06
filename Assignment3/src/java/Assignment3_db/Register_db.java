/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3_db;
import Assignment3_beans.Register_bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Jianzhi
 */
public class Register_db {

    public String authorizeRegister(Register_bean register_bean) //create authorizeRegister()function
    {
        String firstname=register_bean.getFirstname();
        String lastname=register_bean.getLastname();
        String username=register_bean.getUsername();  //get all value through registerBean object and store in temporary variable
        String password=register_bean.getPassword();
        
        String url="jdbc:derby://localhost:1527/Assignment3 [IS2560 on IS2560]"; //database connection url string
        String uname="IS2560"; //database username
        String pass=""; //database password
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); //load driver
            Connection con=DriverManager.getConnection(url,uname,pass); //create connection
            
            PreparedStatement pstmt=null; //create statement
            
            pstmt=con.prepareStatement("insert into user(firstname,lastname,username,password) values(?,?,?,?)"); //sql insert query
            pstmt.setString(1,firstname);
            pstmt.setString(2,lastname);
            pstmt.setString(3,username);
            pstmt.setString(4,password); 
            pstmt.executeUpdate(); //execute query
             
            pstmt.close(); //close statement
            
            con.close(); //close connection
           
            return "SUCCESS REGISTER"; //if valid return string "SUCCESS REGISTER" 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
            return "FAIL REGISTER"; //if invalid return string "FAIL REGISTER"
    }


}
