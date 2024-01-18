<%-- 
    Document   : patientDetailsView
    Created on : Dec 7, 2023, 7:47:22 AM
    Author     : mo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>View patient details</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"/>
    </head>
    <body>
        <script>
    
   
            fetch("/api/v1/patient/all/get")
                    .then((response) => response.json())
                    .then((data) => {
                    console.log(data);
                    if (data.length !== 0) {
                    var table = "";
                    for (var i = 0; i < data.length; i++) {
                    var mrn = data[i].mrn;
                    var patientFullNames = data[i].pfirstname + " " + data[i].pmiddlename + " " + data[i].plastname;
                    console.log(new Date() - data[i].pdob);
                    //TODO - Date formatting
                    var page = data[i].pdob;
                    var pphonenumber = data[i].pphonenumber;
                    table += "<tr>";
                    table += "<td>" + mrn + " </td>";
                    table += "<td>" + patientFullNames + " </td>";
                    table += "<td>" + page + " </td>";
                    table += "<td>" + pphonenumber + " </td>";
                    table += '<td><a href="/JSPs/patientDetailsEdit.jsp" id="viewpatientdetails" name="' + mrn + '" onclick=getViewHrefValue(\"' + mrn + '\")>View</a> |';
                    table += ' <a href="#" id="deletePatientdetails" onclick=actualDeletion(\"' + mrn + '\")>Delete</a></td>';
                    table += "</tr>";
                    }
                    document.getElementById("results").innerHTML = table;
                    } 
                    })
                    .catch(() =>  document.getElementById("errorDisplay").innerHTML = '<p>No data found</p>');
            class DeletePatientRecord {
            async delete(url) {
            const response = await fetch(url,
            {
            method: 'DELETE',
                    headers: {
                    'Content-type': 'application/json'
                    }
            }
            );
            }
            }
            function actualDeletion(mrn) {
            const deleteES6Class = new DeletePatientRecord;
            deleteES6Class.delete('/api/v1/patient/' + mrn + '/delete')
                    //on success the dom is reloaded to repopulate the table with remaining records
                    .then(() => window.location.reload())
                    //on error log the error
                    .catch(err => console.log(err));
            ;
            }
            //function that sets cookie based on values received
            function setCookie(cookieName, cookieValue, expiryDate) {
            var d = new Date();
            d.setTime(d.getTime() + (expiryDate * 24 * 60 * 60 * 1000));
            var expires = "expires=" + d;
            document.cookie = cookieName + "=" + cookieValue + "; " + expires + "; path=/JSPs/patientDetailsEdit.jsp";
            }
            //function called when every individual view<a> tag, argument is supplied when tag is created dynamically  
            function getViewHrefValue(mrnValue) {
            setCookie("mrn", mrnValue);
            }
            function redirect(){
                window.location.href = "/JSPs/patientDetails.jsp";
            }
        </script>

        <nav class="navbar">
            <div class="container">
                <div class="row w-100">
                    <div class="col-10 border border-3 border-dark">
                        <div class="row align-content-center">
                            <p class="text-start text-dark ">Welcome ${user.username}</p>

                        </div>
                    </div>
                    <div class="col-2 bg-dark">
                        <a href="/logout" class="text-center text-light">Logout</a>
                    </div>
                </div>
            </div>

        </nav>
        <div class="container-fluid">
            <div id="errorDisplay"></div>
            <input id="btnCreateEntry" type="button" value="Add entry" onclick="redirect()">




            <div class="col bg-primary">
                <table class="table table-bordered">
                    <thead class="alert-info">
                        <tr>
                            <th>MRN</th>
                            <th>Full Names</th>
                            <th>Age</th>
                            <th>Phone Number</th>
                        </tr>
                    </thead>
                    <tbody id="results"></tbody>
                </table>
            </div>
        </div>
    </body>
</html>
