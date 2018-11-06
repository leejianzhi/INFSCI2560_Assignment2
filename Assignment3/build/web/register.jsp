<%-- 
    Document   : register
    Created on : Nov 5, 2018, 12:04:13 PM
    Author     : Jianzhi
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
           var first_name= /^[a-z A-Z]+$/; //pattern allowed alphabet a-z or A-Z 
           var last_name= /^[a-z A-Z]+$/; //pattern allowed alphabet a-z or A-Z 
           var user_name= /^[a-z A-Z]+$/; //pattern allowed alphabet a-z or A-Z 
           var password_valid=/^[A-Z a-z 0-9]{6,12}$/; //pattern password allowed A to Z, a to z, 0-9 and 6 to 12 range
            
           var fname = document.getElementById("fname"); //textbox id fname
           var lname = document.getElementById("lname"); //textbox id lname
           var uname = document.getElementById("uname"); //textbox id email
           var password = document.getElementById("password"); //textbox id password
    
           if(!first_name.test(fname.value) || fname.value=='') //apply if condition using test() method match the parameter for pattern allow alphabet only
           {
              alert("Enter Firstname Alphabet Only....!"); //alert message
              fname.focus();
              fname.style.background = '#f08080'; //set textbox color
              return false;                    
           }
           if(!last_name.test(lname.value) || lname.value=='') //apply if condition using test() method match the parameter for pattern allow alphabet only
           {
              alert("Enter Lastname Alphabet Only....!"); //alert message
              lname.focus();
              lname.style.background = '#f08080'; //set textbox color
              return false;                    
           }
           if(!user_name.test(uname.value) || uname.value=='') //apply if condition using test() method match the parameter for pattern allow alphabet only
           {
              alert("Enter Username Alphabet Only....!"); //alert message
              uname.focus();
              uname.style.background = '#f08080'; //set textbox color
              return false;                    
           }
           if(!password_valid.test(password.value) || password.value=='') //apply if condition using test() method match the parameter for pattern passoword allow 6 to 12 range 
           {
              alert("Password Must Be 6 to 12 character"); //alert message
              password.focus();
              password.style.background = '#f08080'; //set textbox color
              return false;                    
           }
        }  
      </script>
    </head>
    <body>
        
     
            <div class ="login-form">
            <h2>Register</h2>
            
            <form id="login-form"  method="post" action="Register_servlet" onsubmit="return validate();">
                <h2 class="text-center">Register</h2>
                
                
                <div class="form-group">
                   <label for="Firstname" class="cols-sm control-label">Firstname:   </label>
                   <input type="text" class="form-control" name="firstname_input" placeholder="Firstname">
                </div>
                 <div class="form-group">
                   <label for="Lastname" class="cols-sm control-label">Lastname:   </label>
                   <input type="text" class="form-control" name="lastname_input" placeholder="Lastname">
                </div>
                 <div class="form-group">
                   <label for="Username" class="cols-sm control-label">Username:   </label>
                   <input type="text" class="form-control" name="username_input" placeholder="Username">
                </div>
                 <div class="form-group">
                   <label for="Password" class="cols-sm control-label">Password:   </label>
                   <input type="password" class="form-control" name="password_input" placeholder="Password">
                </div>
                
                <div class="text-center">
                <input type="submit" name="btn_register" value="Register">
                </div>
                
                <p class="text-center"><a href="register.jsp">Login</a></p>
                
                
            </form>
            
            <h3 style="color:red">
                <%
                    if(request.getAttribute("RegisterErrorMsg")!=null)
                    {
                        out.println(request.getAttribute("RegisterErrorMsg")); //get register fail error message from "RegisterController"
                    }
                %>
            </h3>
            
        
            </div>
    </body>
    
</html>