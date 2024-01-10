<%-- 
    Document   : personView
    Created on : Dec 4, 2023, 5:40:31 PM
    Author     : mo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"/>
    </head>
       <body class="vh-100">
        
        
        
   
        <div class="container-fluid p-1 vh-100 ">
            <div class="row justify-content-around align-items-center h-100">
 
                <div class="col-5 bg-secondary p-3 h-75">
                    <div class="row justify-items-center align-items-center h-100">
                        <div class="col-8 offset-2 h-100">
                            <form id = "updateForm"  method="POST">

                    

                                <div class="entries row rounded-3 mb-3">
                                    <input id="firstName" type="text" name="firstName" placeholder="firstName" minlength="5" required> 
                                </div>   

                                <div class="entries row rounded-3 mb-3">
                                    <input id="lastName" type="text" name="lastName" placeholder="lastName" required >
                                </div>  
                                <div class="entries row rounded-3 mb-3">
                                    <input id="age" type="text" name="age" placeholder="age" required >
                                </div>  

                               <div class="entries row rounded-3 mb-3 ">
                                    <input id="height" type="email" name="height" placeholder="height" required >  
                                </div>   


                                <div class="entriesSubmit row justify-items-center">
                                    <button  class="col-8 offset-2 btn btn-dark w-75" formenctype ="application/x-www-form-urlencoded" formmethod="POST"  id="submitInput" type="submit" >Submit</button>
                                </div>

                            </form> 
                        </div>
                       
                    </div>
                </div>
              </div>
            
            
        </div>
        <script>
//            class specialUpdateHTTP{
//                async update(url){
//                    const response = await fetch(
//                            url,
//                    {
//                        method: 'PUT',
//                        headers: {
//                            'Content-type': 'application/x-www-form-urlencoded'
//                        }
//                    });
//                    return "Update in progress..";
//                }
//            }
//            function actualUpdate(entryId){
//                const updateHttp = new specialUpdateHTTP();
//                console.log('/webapi/person/'+entryId+'/update');
//                updateHttp.update('/webapi/person/'+entryId+'/update')
//                        .then(() => window.location.reload())
//                        .catch((err) => console.log(err));
//            }
                 //function that receives cookie name to check and returns cookie value
              function getCookie(name) {
                var value = "; " + document.cookie;
                var parts = value.split("; " + name + "=");
                if (parts.length === 2) return parts.pop().split(";").shift();
            }
            
      //cookie value that will be used in delete and update URI to hit the right resource
                var entryId = getCookie("entryId");
                //set formaction attr on the submit button to send form data to the specialUpdate resource to update db values
                document.getElementById("submitInput").setAttribute("formaction","/webapi/person/"+entryId+"/update");

               
                
                           //create url
            const endpoint = "/webapi/person/"+entryId+"/get";

            //perform a get request
            const wesPromise = fetch(endpoint);
            
            wesPromise.then((response) => response.json())
                    .then((data) => {
                        if(data.length !== 0){
                            var firstName = data.firstname;
                            var lastName = data.lastname;
                            var age = data.age;
                            var height = data.height;
                            
                            document.getElementById("firstName").value = firstName;
                            document.getElementById("lastName").value = lastName;
                            document.getElementById("age").value = age;
                            document.getElementById("height").value = height;
                        
                        }
                    });
            
        </script>
    </body>
</html>
