
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta.2/css/bootstrap.css'>
        <link rel="stylesheet" href="css/UI.css">
        <title>Register</title>
   </head>
        <script language="javascript"> 
         function validate()
         {

            
           
            var username = document.form.username.value; 
            var email = document.form.email.value;
            var password = document.form.password.value;
         
 
            
          
            if (username==null || username=="")
                { 
                    alert("Please enter an username"); 
                    return false; 
                }
            else if (email==null || email=="")
                { 
                    alert("Please enter an email address"); 
                    return false; 
                }
            else if(password.length<6)
                { 
                    alert("Password must be at least 6 characters long."); 
                    return false; 
                } 
           
        }  
      </script>

    <body>
        <div class ="login-form">
            <form id="login-form"  method="post" action="Register_servlet" onsubmit="return validate();">
                <h2 class="text-center">Register</h2>
                 <div class="form-group">
                   <label for="Username" class="cols-sm control-label">Username:   </label>
                   <input id="uname" type="text" class="form-control" name="username_input" placeholder="Username">
                </div>
                 <div class="form-group">
                   <label for="emailaddress" class="cols-sm control-label">Email Address:   </label>
                   <input id="emailaddr" type="email" class="form-control" name="email_input" placeholder="Email Address">
                </div>
                 <div class="form-group">
                   <label for="Password" class="cols-sm control-label">Password:   </label>
                   <input id="pw" type="password" class="form-control" name="password_input" placeholder="Password">
                </div>
               
                
                <div class="text-center">
                <input type="submit" name="btn_register" value="Register">
                </div>
                
                <p class="text-center"><a href="index.jsp">Login</a></p>
                
                
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