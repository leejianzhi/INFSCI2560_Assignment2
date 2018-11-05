/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3_servlet;

import Assignment3_beans.Login_bean;
import Assignment3_db.Login_db;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Jianzhi
 *
 *dSource code modified from http://met.guc.edu.eg/OnlineTutorials/JSP%20-%20Servlets/Full%20Login%20Example.aspx
 * 
 **/
 

public class Login_servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //check if the login button has been tra
        if(request.getParameter("btn_login")!=null) 
        {
            String username=request.getParameter("username_imput"); //get textbox name "txt_username"
            String password=request.getParameter("password_imput"); //get textbox name "txt_password"
            
            Login_bean login_bean =new Login_bean(); //this class contain seeting up all received values from index.jsp page to setter and getter method for application require effectively 
            
            //username set from the login_bean
            login_bean.setUsername(username); 
            //password set from the login_bean
            login_bean.setPassword(password); 
            //access the login database component and vadicate the login info from the database
            Login_db login_db=new Login_db(); 
            String authorize=login_db.authorizeLogin(login_bean);
            
            //if the username and password from the user input is passed the authorization then will shows the user success login info, 
            //otherwise to let user check the username or password and try to login again
            if(authorize.equals("Welcome, you are successfully login")) 
            {
                HttpSession session=request.getSession(); //session is created
                //The username will store in getUsername in login_bean 
                session.setAttribute("login",login_bean.getUsername()); 
                //direct to the homepage if the user successfully login
                RequestDispatcher rd=request.getRequestDispatcher("home.jsp"); 
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("WrongLoginMsg",authorize); 
                //go back to index page which is login page
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp"); 
                rd.include(request, response);
            }
        }
    }
    }



