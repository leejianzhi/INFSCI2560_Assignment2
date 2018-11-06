/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3_db;
import Assignment3_beans.Login_bean;


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
        String url="jdbc:derby://localhost:1527/Assignment3 [IS2560 on IS2560]"; 
        String uname="IS2560"; //database username
        String pass=""; //database password
        
        try
        {
               //load driver
            Class.forName("com.mysql.jdbc.Driver"); 
            //create connection
            Connection con=DriverManager.getConnection(url,uname,pass); 
            //sent SQL query to the database
            PreparedStatement ps=null; //create statement
            //SQL for select the username and password
            ps=con.prepareStatement("select * from user where username=? and password=?"); 
            ps.setString(1,username);
            ps.setString(2,password);
            //excute query
            ResultSet rs=ps.executeQuery(); 
             
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
            con.close(); 
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //if either or both the input of username or password is incorrect the meesage below will show up to the user
        return "Your username or password is incorrect, please try again.";
    }
    
}
