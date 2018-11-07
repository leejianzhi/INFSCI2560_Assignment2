package Assignment3_servlet;

import Assignment3_db.Register_db;
import Assignment3_beans.Register_bean;

import java.io.IOException;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register_servlet extends HttpServlet {
 
 public Register_servlet() {
 }
 
 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 //Copying all the input parameters in to local variables

 String username = request.getParameter("username");
 String email = request.getParameter("email");
 String password = request.getParameter("password");
 
 Register_bean register_bean = new Register_bean();
 //Using Java Beans - An easiest way to play with group of related data


register_bean.setUsername(username);
register_bean.setEmailAddress(email);
register_bean.setPassword(password); 
 
 Register_db register_db = new Register_db();
 
 //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
 String userRegistered = register_db.authorizeRegister(register_bean);
 
 if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
 {
 request.getRequestDispatcher("index.jsp").forward(request, response);
 }
 else   //On Failure, display a meaningful message to the User.
 {

 request.setAttribute("error", userRegistered);
 request.getRequestDispatcher("register.jsp").forward(request, response);
  
 }
 }
}