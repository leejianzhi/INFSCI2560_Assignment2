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
        String pass="IS2560"; //database password
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); //load driver
            Connection con=DriverManager.getConnection(url,uname,pass); //create connection
            
            PreparedStatement ps=null; //create statement
            
            String query= "insert into users(user_id, firstname, lastname, username, password) values(NULL,?,?,?,?)"; //sql insert query
            ps = con.prepareStatement(query);
            ps.setString(1,firstname);
            ps.setString(2,lastname);
            ps.setString(3,username);
            ps.setString(4,password); 
            ps.executeUpdate(); //execute query
             
            //ps.close(); //close statement
            
            //con.close(); //close connection
            
           
            return "You are successfully registered on our site."; //if valid return string "SUCCESS REGISTER" 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
            return "There is something wrong with your registration, please try again."; //if invalid return string "FAIL REGISTER"
    }


}
