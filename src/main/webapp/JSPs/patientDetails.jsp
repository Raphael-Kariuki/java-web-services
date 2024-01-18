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
                        <a href="crud/logout" class="text-center text-light">Logout</a>
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
                <form class="row" action="/api/v1/patient/register" method="POST">

                    <div class="col-6">
                        <fieldset >
                            <legend>Primary details</legend>
                            <div class="form-control">
                                <div class="row align-items-center justify-items-center">
                                    <div class="col ">
                                        <label class="form-check-label" for="salutationSelect">Salutation<b class="text-danger text-bold">*</b></label>
                                        <select  id="salutationSelect" class="form-control" name="selectSalutation">
                                            <option value="">Select</option>
                                            <option value="Mr">Mr</option>
                                            <option value="Mrs">Mrs</option>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <label class="form-check-label" for="fistTimeVisitBoolean">
                                            First time visit
                                        </label>
                                        <input class="form-check-input border border-1 border-dark" type="checkbox" value="true" id="fistTimeVisitBoolean" name="firsttimeCheckbox">

                                    </div>
                                </div>

                            </div>

                            <label class="form-check-label" for="firstName">FirstName<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" id="firstName" type="text" name="pFirstName"   required>

                            <label class="form-check-label" for="middleName">MiddleName<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" id="middleName" type="text" name="pMiddleName"  required>

                            <label class="form-check-label" for="lastName">LastName<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" id="lastName" type="text" name="pLastName"  required>

                            <label class="form-check-label" for="dob">Date of birth<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" id="dob" type="date" name="pdob"   required>





                        </fieldset>
                        <fieldset >
                            <legend>Contact details</legend>
                            <label class="form-check-label" for="phoneNumber">Phone Number<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" id="phoneNumber" type="text" name="pphoneNumber"  required>

                            <label class="form-check-label" for="country">Country<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" list="countryOptions" name="pcountrySelect" id="country" placeholder="Type to search country...">
                            <datalist id="countryOptions">
                                <option value="Kenya">
                                <option value="Uganda">
                                <option value="Tanzania">
                                <option value="Rwanda">
                                <option value="Burundi">
                            </datalist>

                            <label class="form-check-label" for="county">County<b class="text-danger text-bold">*</b></label>
                            <select class="form-control mb-2 border border-1 border-dark" id="county" name="pcountySelect">
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


                            <label class="form-check-label" for="NOKfirstName">FirstName<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" id="NOKfirstName" type="text" name="NOKFirstName"   required>

                            <label class="form-check-label" for="NOKmiddleName">MiddleName<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" id="NOKmiddleName" type="text" name="NOKMiddleName"  required>

                            <label class="form-check-label" for="NOKlastName">LastName<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" id="NOKlastName" type="text" name="NOKLastName"  required>

                            <label class="form-check-label" for="NOKdob">Date of birth<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" id="NOKdob" type="date" name="NOKdob"   required>





                        </fieldset>
                        <fieldset >
                            <legend>Next of kin Contact details</legend>

                            <div class="form-control">
                                <label class="form-check-label " for="similarContacts">
                                    Same as primary contacts
                                </label>
                                <input class="form-check-input border border-1 border-dark" type="checkbox" value="true" name="similarContacts" id="similarContacts">

                            </div>
                            <label class="form-check-label" for="NOKphoneNumber">Phone Number<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" id="NOKphoneNumber" type="text" name="NOKphoneNumber"  required>

                            <label class="form-check-label" for="NOKcountry">Country<b class="text-danger text-bold">*</b></label>
                            <input class="form-control mb-2 border border-1 border-dark" list="NOKcountryOptions" name="NOKcountrySelect" id="NOKcountry" placeholder="Type to search country...">
                            <datalist id="NOKcountryOptions">
                                <option value="Kenya">
                                <option value="Uganda">
                                <option value="Tanzania">
                                <option value="Rwanda">
                                <option value="Burundi">
                            </datalist>

                            <label class="form-check-label" for="NOKcounty">County<b class="text-danger text-bold">*</b></label>
                            <select class="form-control mb-2 border border-1 border-dark" id="NOKcounty" name="NOKcountySelect">
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
                        <input  class="col-2 offset-5 btn btn-dark" type="submit" value="Submit">
                    </div>
                    <div class="formLabel row mt-3">
                        <a class="text-center text-light " href="/JSPs/signUp.jsp">Don't have an account, sign up</a>
                    </div>

                </form>

            </div>


        </div>

    </body>
</html>
