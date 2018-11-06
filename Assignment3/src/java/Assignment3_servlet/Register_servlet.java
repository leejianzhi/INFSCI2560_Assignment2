/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3_servlet;
import Assignment3_db.Register_db;
import Assignment3_beans.Register_bean;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jianzhi
 */
public class Register_servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    {
        
        if(request.getParameter("btn_register")!=null) //check button click event not null from register.jsp page button
        {
            String firstname=request.getParameter("firstname_input");
            String lastname=request.getParameter("lastname_input");
            String username=request.getParameter("username_input");  //get all textbox name from register.jsp page
            String password=request.getParameter("password_input");
            
            Register_bean register_bean =new Register_bean(); //this class contain  seeting up all received values from register.jsp page to setter and getter method for application require effectively
            
            register_bean.setFirstname(firstname);
            register_bean.setLastname(lastname);
            register_bean.setUsername(username);  //set the all value through registerBean object
            register_bean.setPassword(password);
            
            Register_db register_db=new Register_db(); //this class contain main logic to perform function calling and database operation
            
            String registerValidate=register_db.authorizeRegister(register_bean); //send registerBean object values into authorizeRegister() function in RegisterDao class
            
            if(registerValidate.equals("SUCCESS")) //check calling authorizeRegister() function receive "SUCCESS REGISTER" string message after redirect to index.jsp page
            {
                request.setAttribute("RegiseterSuccessMsg",registerValidate); //apply register successfully message "RegiseterSuccessMsg"
                RequestDispatcher rd=request.getRequestDispatcher("/index.jsp"); //redirect to index.jsp page
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("RegisterErrorMsg",registerValidate); // apply register error message "RegiseterErrorMsg"
                RequestDispatcher rd=request.getRequestDispatcher("register.jsp"); //show error same page register.jsp page
                rd.include(request, response);
            }
        }
    }
    }
}

    




