<%-- 
    Document   : signUp
    Created on : Dec 6, 2023, 7:16:34 AM
    Author     : mo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"/>
    </head>
  <body class="vh-100">
        <div class="container-fluid p-1 vh-100 ">
            <div class="row justify-content-around align-items-center h-100">
                <div class="col-5 bg-primary p-3 h-100">
                    
                </div>
                <div class="col-5 bg-secondary p-3 h-75">
                    <div class="row justify-items-center align-items-center h-100">
                        <div class="col-8 offset-2 h-100">
                            <form action="/webapi/person/new/register" method="POST" 
                            oninput="confPassword.setCustomValidity(password.value != confPassword.value ? 'Passwords do not match' : '')">

                                <div class="formLabel row mb-3">
                                    <h2 class="text-center display-5">Registration form</h2> 
                                </div>

                                <div class="entries row rounded-3 mb-3">
                                    <input class="p-2 rounded-3" id="username" type="text" name="username" placeholder="Username" minlength="5" required> 
                                </div>   

                                <div class="entries row rounded-3 mb-3">
                                    <input class="p-2  rounded-3" id="firstname" type="text" name="firstname" placeholder="First name" required >
                                </div>  
                                <div class="entries row rounded-3 mb-3">
                                    <input class="p-2  rounded-3" id="lastname" type="text" name="lastname" placeholder="Last name" required >
                                </div>  

                               <div class="entries row rounded-3 mb-3 ">
                                    <input class="p-2  rounded-3" id="emailAddress" type="email" name="emailaddress" placeholder="Email address" required >  
                                </div>   

                               <div class="entries row rounded-3 mb-3 ">
                                    <input class="p-2  rounded-3" id="password" type="password" name="password" placeholder="Password" minlength="10" maxlength="20" required >
                                </div>   

                               <div class="entries row rounded-3 mb-3">
                                   <input class="p-2  rounded-3" id="confPassword" type="password" name="confPassword" placeholder="Confirm password"  required minlength="10" maxlength="20">
                                </div>  

                                <div class="entriesSubmit row justify-items-center">
                                    <input  class="col-8 offset-2 btn btn-dark w-75" type="submit" value="Submit">
                                </div>
                                <div><p>${errorMessage}</p></div>
                                   <div class="formLabel row mt-3">
                                     <a class="text-center text-light " href="/JSPs/login.jsp">Already have an account, login</a> 
                                </div>

                            </form> 
                        </div>
                       
                    </div>
                </div>
              </div>
            
            
        </div>
        
    </body>
</html>
