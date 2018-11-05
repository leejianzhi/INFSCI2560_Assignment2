<%
    if(session.getAttribute("login")!=null)
    {
        response.sendRedirect("home.jsp"); 
        //once the user sucessful login then redirect to the home page
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> <!--Declare HTML in JSP tag-->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta.2/css/bootstrap.css'>
        <link rel="stylesheet" href="css/UI.css">
        <title>INFSCI2560 Assignment3</title>
        <script language="javascript"> 
        function validate()
        {
          //get from the username input from the user and validate it
          var username = document.LoginForm.username_input;
          //get from the password input from the user and validate it
          var password = document.LoginForm.password_input; 
          //Check if the username is blank
          if (username.value == null || username.value == "") 
          {
            //give alert if the username is empty
            window.alert("Please input your username"); 
            username.style.background = '#f08080'; 
            username.focus();
            return false;
          }
          //check if the password is empty
          if (password.value == null || password.value == "") 
          {
            window.alert("Please input your password"); 
            password.style.background = '#f08080'; 
            password.focus();
            return false;
          }
        }  
       </script>
    </head>
    <body>
     
           <div class ="login-form">
               
                    <form id="login-form" method="post" action="Login_servlet" name="LoginForm" onsubmit="return validate();">
                        <h2 class="text-center">Login</h2>
                        <div class="form-group">
                            <label for="username" class="cols-sm control-label">Username:   </label>
                            <input type="text" class="form-control" name="username_input" placeholder="Username">
                        </div>
                        <div class="form-group">
                            <label for="password" class="cols-sm control-label">Password:   </label>
                            <input type="password" class="form-control" name="password_input" placeholder="Password">
                        </div>
                        
                        <div class="text-center">
                            <input type="submit" name="btn_login" value="Login">
                        </div>
                        <p class="text-center"><a href="register.jsp">Create an Account</a></p>
                    </form>
        
            <h3 style="color:green">
                <%
                    if(request.getAttribute("RegiseterSuccessMsg")!=null)
                    {
                         //get the message from register servlet if the register was successful
                        out.println(request.getAttribute("RegiseterSuccessMsg"));
                    }
                %>
            </h3>
            
            <h3 style="color:red">
                <%
                    if(request.getAttribute("WrongLoginMsg")!=null)
                    {   
                        //login message from the login servlet
                        out.println(request.getAttribute("WrongLoginMsg"));
                    }
                %>
            </h3>
            
           </div>
    
    </body>
</html>