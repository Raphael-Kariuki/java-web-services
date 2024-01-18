<%--
    Document   : patientDetails
    Created on : Dec 6, 2023, 11:05:37 AM
    Author     : mo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Patient details</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"/>
    </head>
    <body>
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
            <div class="row">
                <div class="formLabel row mb-3">
                    <h2 class="text-center display-6">Patient registration form</h2>
                </div>
            </div>
            <div class="container-fluid">
                <form class="row"  method="POST">

                    <div class="col-6">
                        <fieldset >
                            <legend>Primary details</legend>
                            <div class="form-control">
                                <div class="row align-items-center justify-items-center">
                                    <div class="col ">
                                        <label class="form-check-label" for="_salutationSelect">Salutation<b class="text-danger text-bold">*</b></label>
                                        <select  id="_salutationSelect" class="form-control" name="_selectSalutation">
                                            <option value="">Select</option>
                                            <option value="Mr">Mr</option>
                                            <option value="Mrs">Mrs</option>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <label class="form-check-label" for="_fistTimeVisitBoolean">
                                            First time visit
                                        </label>
                                        <input class="form-check-input border border-1 border-dark" type="checkbox" value="true" id="_fistTimeVisitBoolean" name="firsttimeCheckbox">

                                    </div>
                                </div>

                            </div>

                            <label class="form-check-label" for="_firstName">FirstName<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" id="_firstName" type="text" name="_pFirstName"   required>

                            <label class="form-check-label" for="_middleName">MiddleName<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" id="_middleName" type="text" name="_pMiddleName"  required>

                            <label class="form-check-label" for="_lastName">LastName<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" id="_lastName" type="text" name="_pLastName"  required>

                            <label class="form-check-label" for="_dob">Date of birth<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" id="_dob" type="date" name="_pdob"   required>





                        </fieldset>
                        <fieldset >
                            <legend>Contact details</legend>
                            <label class="form-check-label" for="_phoneNumber">Phone Number<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" id="_phoneNumber" type="text" name="_pphoneNumber"  required>

                            <label class="form-check-label" for="_country">Country<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" list="_countryOptions" name="_pcountrySelect" id="_country" placeholder="Type to search country...">
                            <datalist id="_countryOptions">
                                <option value="Kenya">
                                <option value="Uganda">
                                <option value="Tanzania">
                                <option value="Rwanda">
                                <option value="Burundi">
                            </datalist>

                            <label class="form-check-label" for="_county">County<b class="text-danger text-bold">*</b></label>
                            <select class="form-control mb-2 border border-1 border-dark" id="_county" name="_pcountySelect">
                                <option value="Select">Select</option>
                                <option value="Meru">Meru</option>
                                <option value="UasinGishu">UasinGishu</option>
                                <option value="Isiolo">Isiolo</option>
                                <option value="Nairobi">Nairobi</option>
                                <option value="Laikipia">laikipia</option>
                            </select>
                        </fieldset>

                    </div>
                    <div class="col-6">
                        <fieldset >
                            <legend>Next of kin Primary details</legend>


                            <label class="form-check-label" for="_NOKfirstName">FirstName<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" id="_NOKfirstName" type="text" name="_NOKFirstName"   required>

                            <label class="form-check-label" for="NOKmiddleName">MiddleName<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" id="_NOKmiddleName" type="text" name="_NOKMiddleName"  required>

                            <label class="form-check-label" for="_NOKlastName">LastName<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" id="_NOKlastName" type="text" name="_NOKLastName"  required>

                            <label class="form-check-label" for="_NOKdob">Date of birth<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" id="_NOKdob" type="date" name="_NOKdob"   required>





                        </fieldset>
                        <fieldset >
                            <legend>Next of kin Contact details</legend>

                            <div class="form-control">
                                <label class="form-check-label " for="_similarContacts">
                                    Same as primary contacts
                                </label>
                                <input class="form-check-input border border-1 border-dark" type="checkbox" value="" id="_similarContacts">

                            </div>
                            <label class="form-check-label" for="_NOKphoneNumber">Phone Number<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" id="_NOKphoneNumber" type="text" name="_NOKphoneNumber"  required>

                            <label class="form-check-label" for="_NOKcountry">Country<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" list="_NOKcountryOptions" name="_NOKcountrySelect" id="_NOKcountry" placeholder="Type to search country...">
                            <datalist id="_NOKcountryOptions">
                                <option value="Kenya">
                                <option value="Uganda">
                                <option value="Tanzania">
                                <option value="Rwanda">
                                <option value="Burundi">
                            </datalist>

                            <label class="form-check-label" for="_NOKcounty">County<b class="text-danger text-bold">*</b></label>
                            <select class="form-control mb-2 border border-1 border-dark" id="_NOKcounty" name="_NOKcountySelect">
                                <option value="Select">Select</option>
                                <option value="Meru">Meru</option>
                                <option value="UasinGishu">UasinGishu</option>
                                <option value="Isiolo">Isiolo</option>
                                <option value="Nairobi">Nairobi</option>
                                <option value="Laikipia">laikipia</option>
                            </select>
                        </fieldset>

                    </div>







                    <div class="patientdetailsSubmit row justify-items-center">
                        <input  class="col-2 offset-5 btn btn-dark" type="submit" value="Submit" id="submitInput">
                    </div>


                </form>

            </div>


        </div>
        <script>

            //function that receives cookie name to check and returns cookie value
            function getCookie(name) {
                var value = "; " + document.cookie;
                var parts = value.split("; " + name + "=");
                if (parts.length === 2)
                    return parts.pop().split(";").shift();
            }
            //cookie value that will be used in delete and update URI to hit the right resource
            var mrn = getCookie("mrn");
            console.log(mrn);
            //set formaction attr on the submit button to send form data to the specialUpdate resource to update db values
            document.getElementById("submitInput").setAttribute("formaction", "/api/v1/patient/" + mrn + "/update");
            const singlePatientDetailsAPIURI = "/api/v1/patient/" + mrn + "/get";
            const singlePatientDetailsPromise = fetch(singlePatientDetailsAPIURI);
            singlePatientDetailsPromise
                    .then((response) => response.json())
                    .then((data) => {
                        console.log(data.firsttime);
                        if (data.length !== 0) {
                            document.getElementById("_salutationSelect").value = data.salutation;
                            var check = (data.firsttime === 'false') ? false : true;
                            document.getElementById("_fistTimeVisitBoolean").checked = check;
                            document.getElementById("_firstName").value = data.pfirstname;
                            document.getElementById("_middleName").value = data.pmiddlname;
                            document.getElementById("_lastName").value = data.plastname;
                            document.getElementById("_dob").value = data.pdob;
                            document.getElementById("_phoneNumber").value = data.pphonenumber;
                            document.getElementById("_country").value = data.pcountry;
                            document.getElementById("_county").value = data.pcounty;
                            document.getElementById("_NOKfirstName").value = data.nokfirstname;
                            document.getElementById("_NOKmiddleName").value = data.nokmiddlename;
                            document.getElementById("_NOKlastName").value = data.nokmiddlename;
                            document.getElementById("_NOKdob").value = data.nokdob;
                            document.getElementById("_NOKphoneNumber").value = data.nokphonenumber;
                            document.getElementById("_NOKcountry").value = data.nokcountry;
                            document.getElementById("_NOKcountry").value = data.nokcountry;
                            document.getElementById("_NOKcounty").value = data.nokcounty;
                        }
                    });

            

        </script>

    </body>
</html>
