<%-- 
    Document   : multistepform
    Created on : Dec 30, 2023, 5:42:00 PM
    Author     : mo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Registration</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <link rel="stylesheet" href="../CSS/styles.css"/>



    </head>
    <body>
        <header>
            <a  class="logo" href="#"> Logo</a>
            <input type="checkbox" id="menu-bar">
            <label for="menu-bar">Menu</label>
            <nav class="navbar">
                <ul>
                    <li><a href="">Home</a></li>
                    <li><a href="">Services +</a>
                        <ul>
                            <li><a href="">Citizen</a></li>
                            <li><a href="">Non-Citizen</a></li>
                            <li><a href="">Foreigner+</a>
                                <ul>
                                    <li><a href="">Austria</a></li>
                                    <li><a href="">American</a></li>
                                    <li><a href="">European</a></li>

                                </ul>

                            </li>

                        </ul>

                    </li>
                    <li><a href="">Gallery+</a>
                        <ul>
                            <li><a href="">Grid Gallery</a></li>
                            <li><a href="">Flex Gallery</a></li>

                        </ul>

                    </li>
                    <li><a href="">About us</a></li>
                    <li><a href="">contact us</a></li>
                </ul>

            </nav>
        </header>
        <div class="main-container">
            <div class="steps">
           
                <div class="div-step">

                    <span class="step"><span class="step-deco"></span></span><p class="step-label"> Basic info</p>
                </div>
                <div class="div-step">

                    <span class="step"><span class="step-deco"></span></span><p class="step-label"> Contact info</p>
                </div>
                <div class="div-step">

                    <span class="step"><span class="step-deco"></span></span><p class="step-label"> Location info</p>

                </div>
                <div class="div-step">

                    <span class="step"><span class="step-deco"></span></span> <p class="step-label"> Patient Other Details</p>

                </div>
                <div class="div-step">

                    <span class="step"><span class="step-deco"></span></span><p class="step-label"> Next of Kin info</p>

                </div>
                <div class="div-step">

                    <span class="step"><span class="step-deco"></span></span><p class="step-label"> Referral Details</p>

                </div>


            </div>
            <div class="form-container">
                <form id="regForm" action="/action_page.php"  >
                    <!-- One "tab" for each step in the form: -->
                    <div class="tab">
                        <div class="row">
                            <div class="inputs">
                                <label for="ptRegServicePoint">Registration Service Point</label>
                                <select class="2save" id="ptRegServicePoint" name="ptRegServicePoint" required >
                                    <option value="">Select</option>
                                    <option value="In-Patient">In-Patient</option>
                                    <option value="Out-Patient">Out-Patient</option>
                                </select>
                            </div>
                            <div class="inputs">
                                <label for="ptUrgency">Patient Urgency</label>
                                <select class="2save" id="ptUrgency" name="ptUrgency" required >
                                    <option value="">Select</option>
                                    <option value="Normal">Normal</option>
                                    <option value="Emergency">Emergency</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="inputs">
                                <input type="text" class="2save input-required"  oninput="this.className = ''" name="ptLname" required>
                                <span class="input-label">Last name</span>

                            </div>
                            <div class="inputs">
                                <input type="text" class="2save input-required"  oninput="this.className = ''" name="ptOtherNames" required>
                                <span class="input-label">Other names</span>
                            </div>


                        </div>
                        <div class="row">
                            <div class="inputs">
                                <label for="specialtyClinic">Specialty Clinic</label>
                                <select class="2save"  id="specialtyClinic" name="specialtyClinic" required >
                                    <option value="">Select</option>
                                    <option value="Casualty">Casualty</option>
                                    <option value="Clinics">Clinics</option>
                                    <option value="Consultation">Consultation</option>
                                    <option value="Dental">Dental</option>
                                    <option value="Dopc">Dopc</option>
                                    <option value="Ent">Ent</option>
                                    <option value="Eye">Eye</option>
                                </select>  
                            </div>
                            <div class="inputs">
                                <input type="text" class="2save input-required"  oninput="this.className = ''" name="ptCSheetNo" required>
                                <span class="input-label">C Sheet Number</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="inputs genderRadios">
                                <label>Gender</label>


                                <div>
                                    <label for="ptGenderM">
                                        <input class="2save" id="ptGenderM" type="radio"  name="ptGender" value="Male"/>
                                        Male 
                                    </label>
                                    <label for="ptGenderF">
                                        <input class="2save" id="ptGenderF" type="radio"  name="ptGender" value="Female"/>
                                        Female     
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="inputs maritalStatusRadios">
                                <label >Marital status </label>

                                <div>
                                    <label for="ptMaritalStatusS">
                                        <input class="2save" id="ptMaritalStatusS" type="radio"  name="ptMaritalStatus" value="Single"/>

                                        Single  
                                    </label>

                                    <label for="ptMaritalStatusM">
                                        <input class="2save" id="ptMaritalStatusM" type="radio"  name="ptMaritalStatus" value="Married"/>

                                        Married 
                                    </label>


                                    <label for="ptMaritalStatusD">
                                        <input class="2save" id="ptMaritalStatusD" type="radio"  name="ptMaritalStatus" value="Divorced"/>

                                        Divorced 
                                    </label>

                                    <label for="ptMaritalStatusW">
                                        <input class="2save" id="ptMaritalStatusW" type="radio"  name="ptMaritalStatus" value="Widowed"/>

                                        Widowed
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <!--                        <div class="inputs">
                                                        <label for="ptAge">Age
                                                            <input class="2save" id="ptAge" type="text"  name="ptAge" readonly/>
                                                        </label>
                                                    </div>-->
                            <div class="inputs">
                                <label for="ptDOB"> Date of Birth 
                                    <sup>*</sup>
                                    <span class="specialCaseDoB">
                                        <input class="2save" id="ptDOB" type="date"  name="ptDOB" required />
                                        <span class="validity"></span>
                                    </span>
                                </label>

                            </div>
                        </div>
                        <div class="row">
                            <div class="inputs">
                                <label> Patient with disability  </label>
                                <select class="2save" id="ptDisabled" name="ptDisabled" required >
                                    <option value="">Select</option>
                                    <option value="Yes">Yes</option>
                                    <option value="No">No</option>
                                </select>

                            </div>
                            <div class="inputs">
                                <label for="ptAuthority">Authority</label>
                                <select class="2save" id="ptAuthority" name="ptAuthority" required >
                                    <option value="">Select</option>
                                    <option value="Voluntary">Voluntary</option>
                                    <option value="Involuntary">Involuntary</option>


                                </select>
                            </div>
                        </div>

                    </div>
                    <div class="tab">
                        <div class="row">
                            <div class="inputs">
                                <input type="text" class="2save input-required"  oninput="this.className = ''" name="ptIDNo" required>
                                <span class="input-label">ID Number</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="inputs">
                                <input type="text" class="2save input-required" oninput="this.className = ''" name="ptEmailAddress" required>
                                <span class="input-label">E-mail</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="inputs">
                                <input type="text" class="2save input-required" oninput="this.className = ''" name="ptPhoneNumber" required>
                                <span class="input-label">Phone Number</span>
                            </div>
                        </div>


                    </div>
                    <div class="tab">
                        <div class="row">
                            <div class="inputs">
                                <label for="ptNationality">Nationality</label>
                                <select class="2save"  id="ptNationality" name="ptNationality" required >
                                    <option value="">Select</option>
                                    <option value="Kenya">Kenya</option>
                                    <option value="Uganda">Uganda</option>

                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="inputs">
                                <label for="ptCounty">County</label>
                                <select class="2save" id="ptCounty" name="ptCounty" required >
                                    <option value="">Select</option>
                                    <option value="Garissa">Garissa</option>
                                </select>
                            </div>

                            <div class="inputs">
                                <label for="ptSubCounty">Sub County</label>
                                <select class="2save" id="ptSubCounty" name="ptSubCounty" required >
                                    <option value="">Select</option>
                                    <option value="Igoji">Igoji</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="inputs">
                                <input type="text" class="2save input-required" oninput="this.className = ''" name="ptPostalAddress" required>
                                <span class="input-label">Postal address</span>
                            </div>

                        </div>
                        <div class="row">
                            <div class="inputs">
                                <input type="text" class="2save input-required" oninput="this.className = ''" name="ptHomeVillage" required>
                                <span class="input-label">Home Village</span>
                            </div>

                        </div>
                        <div class="row">
                            <div class="inputs">
                                <input type="text" class="2save input-required" oninput="this.className = ''" name="ptPhysicalResidence" required>
                                <span class="input-label">Physical residence</span>
                            </div>

                        </div>
                        <div class="row">
                            <div class="inputs">
                                <input type="text" class="2save input-required" oninput="this.className = ''" name="ptPlaceOfBirth" required>
                                <span class="input-label">Place of Birth</span>
                            </div>

                        </div>




                    </div>
                    <div class="tab">
                        <div class="row">
                            <div class="inputs">
                                <label class="form-control" >
                                    <input  class="2save" id="ptNHIFRegistered" type="checkbox"  name="ptNHIFRegistered" value="isNHIFregistered"/>
                                    NHIF registered
                                </label>

                            </div>
                        </div>
                        <div class="row">
                            <div class="inputs">
                                <input class="2save isNHIFRegisteredDependendents" id="ptNHIFRegisteredChildren" type="text"  name="ptNHIFRegisteredChildren" />
                                <span class="input-label">No of children</span>
                            </div>

                        </div>
                        <div class="row">
                            <div class="inputs">
                                <input class="2save isNHIFRegisteredDependendents"  oninput="this.className = ''" type="text" name="ptNHIFClaimNo" >
                                <span class="input-label">NHIF claim number</span>
                            </div>

                        </div>
                        <div class="row">
                            <div class="inputs">
                                <input class="2save"  oninput="this.className = ''" type="text" name="ptOldFileNumber">
                                <span class="input-label">Old file number</span>
                            </div>

                        </div>
                        <div class="row">
                            <div class="inputs">
                                <input class="2save"  oninput="this.className = ''" type="text" name="ptOtherNo">
                                <span class="input-label">Other numbers</span>
                            </div>

                        </div>





                    </div>
                    <div class="tab">
                        <div class="row">
                            <div class="inputs "> 
                                <div class="nokPerson">
                                    <label for="ptBroughtByNOK"> 
                                        <input class="2save" id="ptBroughtByNOK" type="radio"   value="NOK" name="ptBroughtBy"/>
                                        Next of Kin </label>
                                    <label for="ptBroughtByGoodSamaritan">
                                        <input class="2save" id="ptBroughtByGoodSamaritan" type="radio" value="GoodSamaritan"  name="ptBroughtBy"/>
                                        Good samaritan </label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="inputs">
                                <input class="2save"  oninput="this.className = ''" name="ptNOKFullName" type="text" required>
                                <span class="input-label">NOK Full Name</span>
                            </div>

                        </div>
                        <div class="row">
                            <div class="inputs">
                                <input class="2save"  oninput="this.className = ''" name="ptNOKRelation" type="text" required>
                                <span class="input-label">NOK Relation</span>
                            </div>

                        </div>
                        <div class="row">
                            <div class="inputs">
                                <input class="2save input-required"  oninput="this.className = ''" name="ptNOKID_PassportNo" type="text" required>
                                <span class="input-label">NOK ID/Passport No</span>
                            </div>

                        </div>
                        <div class="row">
                            <div class="inputs">
                                <input class="2save input-required"  oninput="this.className = ''" name="ptNOKPhoneNo" type="tel" required>
                                <span class="input-label">NOK Phone No</span>
                            </div>

                        </div>
                        <div class="row">
                            <div class="inputs">
                                <input class="2save input-required" oninput="this.className = ''" name="ptNOKPostalAddress" type="text" required>  
                                <span class="input-label">NOK Postal Address</span>
                            </div>

                        </div>
                        <div class="row">
                            <div class="inputs">
                                <input class="2save input-required" oninput="this.className = ''" name="ptNOKPhysicalResidence" type="text" required>
                                <span class="input-label">NOK Physical Residence</span>
                            </div>

                        </div>







                    </div>
                    <div class="tab">
                        <div class="row">
                            <div class="inputs">
                                <input type="text" class="2save" oninput="this.className = ''" name="ptReferralType">
                                <span class="input-label">Referral type</span>
                            </div>

                        </div>
                        <div class="row">
                            <div class="inputs">
                                <input type="text" class="2save"  oninput="this.className = ''" name="ptReferralfacility">
                                <span class="input-label">Referral Facility</span>
                            </div>

                        </div>
                        <div class="row">
                            <div class="inputs">
                                <input type="text" class="2save" oninput="this.className = ''" name="ptRReferralCounty">
                                <span class="input-label">Referral County</span>
                            </div>

                        </div>



                    </div>
                    <div >
                        <div class="btns" >
                            <button type="button" id="prevBtn" onclick="nextPrev( - 1)">Previous</button>
                            <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
                        </div>
                    </div>
                    <!-- Circles which indicates the steps of the form: -->

                </form>
            </div>
            <script>
         
                //TODO set readOnly for NHIF registered dependants works on the first reload, fails after. To check
                const ptNHIFRegisteredCheckBox = document.getElementById('ptNHIFRegistered');
                let ptNHIFRegisteredCheckBoxDependants = document.getElementsByClassName('isNHIFRegisteredDependendents');
                ptNHIFRegisteredCheckBox.onchange = nhifValue;
                //function to set nhif related input to readonly
                function nhifValue() {
                if (ptNHIFRegisteredCheckBox.checked) {
                ptNHIFRegisteredCheckBoxDependants[0].readOnly = false;
                ptNHIFRegisteredCheckBoxDependants[1].readOnly = false;
                } else {
//                      ptNHIFRegisteredCheckBoxDependants[0].value = '';
//                      ptNHIFRegisteredCheckBoxDependants[1].value = '';
                ptNHIFRegisteredCheckBoxDependants[0].readOnly = true;
                ptNHIFRegisteredCheckBoxDependants[1].readOnly = true;
                }
                }

                //set min and max programatically
                const dateInput = document.querySelector("input[type='date']");
                let date = new Date();
                var [month, day, year] = [
                        date.getMonth() + 1,
                        date.getDate(),
                        date.getFullYear()
                ];
                if (month < 10) {
                month = '0' + month;
                }
                dateInput.max = year + '-' + month + '-' + day;
                dateInput.min = '1970-01-01';
                var currentTab = 0; // Current tab is set to be the first tab (0)
                showTab(currentTab); // Display the current tab
                var x, y;
    x = document.getElementsByClassName("tab");
                    y = x[currentTab].getElementsByTagName("input");
//             function removeInvalidClass(y){
//                                    var i;
//
////                    console.log(y[1]);
//                    for (i = 0; i < y.length; i++){
//                           y[i].className.replace(" invalid","");  
//                    }
//                }
//                for(var x = 0; x < y.length; x++){
//                    y[x].onfocus = ()=>{
//                        y[x].className.replace(" invalid","");  
//                    };
//                }
//TODO: input is marked as invalid, when re-entering a value ,
// it seems the invalid class is not removed coz the label doesn't translate as defined for valid inputs
                function showTab(n) {
                // This function will display the specified tab of the form...
                var x = document.getElementsByClassName("tab");
                x[n].style.display = "block";
                //... and fix the Previous/Next buttons:
                if (n === 0) {
                document.getElementById("prevBtn").style.display = "none";
                } else {
                document.getElementById("prevBtn").style.display = "inline";
                }
                if (n === (x.length - 1)) {
                document.getElementById("nextBtn").innerHTML = "Submit";
                //clear session storage
                } else {
                document.getElementById("nextBtn").innerHTML = "Next";
                }
                //... and run a function that will display the correct step indicator:
                fixStepIndicator(n);
                }

                function nextPrev(n) {
                // This function will figure out which tab to display
                var x = document.getElementsByClassName("tab");
                // Exit the function if any field in the current tab is invalid:
                if (n === 1 && !validateForm())
                        return false;
                // Hide the current tab:
                x[currentTab].style.display = "none";
                // Increase or decrease the current tab by 1:
                currentTab = currentTab + n;
                // if you have reached the end of the form...
                if (currentTab >= x.length) {
                // ... the form gets submitted:
                document.getElementById("regForm").submit();
                return false;
                }
                // Otherwise, display the correct tab:
                showTab(currentTab);
                }

                function validateForm() {
                // This function deals with validation of the form fields
                var x, y, z, allInputs = [], i, valid = true;
                x = document.getElementsByClassName("tab");
                y = x[currentTab].getElementsByTagName("input");
                z = x[currentTab].getElementsByTagName("select");
                
                for (var c = 0; c < y.length; c++) {
                    allInputs.push(y[c]);
                }
                for (var i = 0; i < z.length; i++) {
                    allInputs.push(z[i]);
                }
                // A loop that checks every input field in the current tab:
                for (i = 0; i < allInputs.length; i++) {
                // If a field is empty...
                if (allInputs[i].value === "") {
                // add an "invalid" class to the field:
                console.log(allInputs[i]);
                allInputs[i].className += " invalid";
                // and set the current valid status to false
                valid = false;
                }
                }
                // If the valid status is true, mark the step as finished and valid:
                if (valid) {
                //call function to save form fields values
                temporarySaveFormData();
//                        document.getElementsByClassName("step")[currentTab].className += " finish";
                document.getElementsByClassName("div-step")[currentTab].className += " finish";
                }
                return valid; // return the valid status
                }

                function fixStepIndicator(n) {
                // This function removes the "active" class of all steps...
                var i, x = document.getElementsByClassName("step"),
                        y = document.getElementsByClassName("step-deco"),
                        z = document.getElementsByClassName("step-label"),
                        a = document.getElementsByClassName("div-step");
                for (i = 0; i < x.length; i++) {
                x[i].className = x[i].className.replace(" active", "");
                y[i].className = y[i].className.replace(" active", "");
                z[i].className = z[i].className.replace(" active", "");
                a[i].className = a[i].className.replace(" active", "");
                }
                //... and adds the "active" class on the current step:
                x[n].className += " active";
                y[n].className += " active";
                z[n].className += " active";
                a[n].className += " active";
                }
                function temporarySaveFormData() {
                var x, y, inputsToSave = [];
                x = document.getElementsByClassName('tab');
                y = x[currentTab].getElementsByClassName('2save');
                for (i = 0; i < y.length; i++) {
                const obj = {};
                if (y[i].tagName === 'INPUT' && y[i].type === 'radio' && y[i].checked === true) {
                obj[y[i].name] = y[i].value;
                inputsToSave.push(obj);
                } else if (y[i].tagName === 'INPUT' && y[i].type !== 'radio') {
                obj[y[i].name] = y[i].value;
                inputsToSave.push(obj);
                } else if (y[i].tagName === 'SELECT') {
                obj[y[i].name] = y[i].value;
                inputsToSave.push(obj);
                }


                }
//                    console.log(inputsToSave);
                sessionStorage.setItem("form-data-tab-" + currentTab, JSON.stringify(inputsToSave));
                }
          
            </script>
        </div>
    </body>
</html>

