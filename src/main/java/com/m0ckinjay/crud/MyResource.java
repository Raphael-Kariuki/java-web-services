package com.m0ckinjay.crud;

import com.m0ckinjay.crud.patient.Patientdetails;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("person")
public class MyResource {

    PersonService personService = new PersonService();

    /**
     * Method handling HTTP GET requests. The returned object will be sent to
     * the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "Got it!";
    }

    @Path("new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPersonEntry(PersonModel person) {
        return Response.ok(personService.insertPerson(person)).build();
    }

    @Path("all/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons() throws SQLException {
        return Response.ok(personService.getallPerson()).build();
    }

    @Path("{id}/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons(@PathParam("id") int id) throws SQLException {
        return Response.ok(personService.getPersonById(id)).build();
    }

    @Path("{id}/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePersonById(@PathParam("id") int id) {
        return Response.ok(personService.deletePersonById(id)).build();
    }

    @Path("{id}/update")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePersonById(@PathParam("id") int id,
            MultivaluedMap<String, String> formDataMap) throws URISyntaxException {
        /*
        By default a multiValued hashMap values are list objects containing the correspondind form data items/values.
        When fed to a response directly , the json is not nicely formated
        (key, value(key, value)) insted of (key, value) - soln.Iterate and put in hashMap
         */
        //hashMap declaration
        Map<String, String> formParameters = new HashMap<>();

        //iterate the keys
        Iterator<String> it = formDataMap.keySet().iterator();

        while (it.hasNext()) {
            String theKey = (String) it.next();
            formParameters.put(theKey, formDataMap.getFirst(theKey));
        }
        PersonModel updatePersonModel = new PersonModel();
        updatePersonModel.setFirstname(formParameters.get("firstName"));
        updatePersonModel.setLastname(formParameters.get("lastName"));
        updatePersonModel.setAge(Integer.parseInt(formParameters.get("age")));
        updatePersonModel.setHeight(Double.parseDouble(formParameters.get("height")));
        int responseInt = personService.specialUpdatePersonById(updatePersonModel, id);
        Response response = null;
        if (responseInt == 1) {
            response = Response.temporaryRedirect(URI.create("/")).build();
        } else {
            response = Response.status(Response.Status.NOT_IMPLEMENTED).location(new URI("/")).build();
        }
        return response;
    }

    @Path("new/register")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerSystemUser(
            MultivaluedMap<String, String> formDataMap) throws URISyntaxException {
        /*
        By default a multiValued hashMap values are list objects containing the correspondind form data items/values.
        When fed to a response directly , the json is not nicely formated
        (key, value(key, value)) insted of (key, value) - soln.Iterate and put in hashMap
         */
        //hashMap declaration
        Map<String, String> formParameters = new HashMap<>();

        //iterate the keys
        Iterator<String> it = formDataMap.keySet().iterator();

        while (it.hasNext()) {
            String theKey = (String) it.next();
            formParameters.put(theKey, formDataMap.getFirst(theKey));
        }
        //initialize user model
        Systemusers registerUser = new Systemusers();
        //get form input
        registerUser.setUsername(formParameters.get("username"));
        registerUser.setFirstname(formParameters.get("firstname"));
        registerUser.setLastname(formParameters.get("lastname"));
        registerUser.setEmailaddress(formParameters.get("emailaddress"));
        registerUser.setPassword(formParameters.get("password"));

        String responseInt = personService.registerSystemUser(registerUser);
        Response response = null;
        if (responseInt.equals("1")) {
            response = Response.temporaryRedirect(URI.create("/JSPs/login.jsp")).build();
        } else {
            response = Response.status(Response.Status.NOT_IMPLEMENTED).location(new URI("/")).build();
        }
        return response;
    }

    @Path("new/patient/register")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerPatient(MultivaluedMap<String, String> formDataMap) throws URISyntaxException {
        /*
        By default a multiValued hashMap values are list objects containing the correspondind form data items/values.
        When fed to a response directly , the json is not nicely formated
        (key, value(key, value)) insted of (key, value) - soln.Iterate and put in hashMap
         */
        //hashMap declaration
        Map<String, String> formParameters = new HashMap<>();

        //iterate the keys
        Iterator<String> it = formDataMap.keySet().iterator();

        while (it.hasNext()) {
            String theKey = (String) it.next();
            formParameters.put(theKey, formDataMap.getFirst(theKey));
        }
//        System.out.println(""+ formDataMap.values());
//        System.out.println(""+ formDataMap.keySet());
        System.out.println("" + formParameters.values());
        System.out.println("" + formParameters.keySet());
        //initialize user model
        Patientdetails registerpatientDetails = new Patientdetails();
        //get form input
        SecureRandom secureRandom = new SecureRandom();
        String mrnNumber = ((formParameters.get("pFirstName")).charAt(0) + "" + (formParameters.get("pMiddleName")).charAt(0) + "" + (formParameters.get("pLastName")).charAt(0)).toUpperCase() + String.valueOf(secureRandom.nextLong(9999));
        registerpatientDetails.setMrn(mrnNumber);
        registerpatientDetails.setSalutation(formParameters.get("selectSalutation"));
        registerpatientDetails.setFirsttime(formParameters.get("firsttimeCheckbox"));
        registerpatientDetails.setPfirstname(formParameters.get("pFirstName"));
        registerpatientDetails.setPmiddlname(formParameters.get("pMiddleName"));
        registerpatientDetails.setPlastname(formParameters.get("pLastName"));
        registerpatientDetails.setPdob(formParameters.get("pdob"));
        registerpatientDetails.setPphonenumber(formParameters.get("pphoneNumber"));
        registerpatientDetails.setPcountry(formParameters.get("pcountrySelect"));
        registerpatientDetails.setPcounty(formParameters.get("pcountySelect"));
        registerpatientDetails.setNokfirstname(formParameters.get("NOKFirstName"));
        registerpatientDetails.setNokmiddlename(formParameters.get("NOKMiddleName"));
        registerpatientDetails.setNoklastname(formParameters.get("NOKLastName"));
        registerpatientDetails.setNokdob(formParameters.get("NOKdob"));
        registerpatientDetails.setNokphonenumber(formParameters.get("NOKphoneNumber"));
        registerpatientDetails.setNokcountry(formParameters.get("NOKcountrySelect"));
        registerpatientDetails.setNokcounty(formParameters.get("NOKcountySelect"));

        Response response = null;
        String responseInt = personService.insertPatientrecords(registerpatientDetails);
        if (responseInt.equals("1")) {
            response = Response.temporaryRedirect(URI.create("/JSPs/patientDetailsView.jsp")).build();
        } else {
            response = Response.status(Response.Status.NOT_IMPLEMENTED).build();
        }
        return response;
    }

    @Path("patientdetails/all/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPatientDetails() throws SQLException {
        Response response = null;
        List<Patientdetails> patientDetailsDataSet = personService.getallPatientDetails();
        if (patientDetailsDataSet.isEmpty()) {
            response = Response.noContent().build();
        } else {
            response = Response.ok(patientDetailsDataSet).build();
        }
        return response;
    }

    @Path("patientdetails/{mrn}/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePatientdetailsByMRN(@PathParam("mrn") String mrn) {
        Response response = "1".equals(personService.deletePatientDetailsByMRN(mrn)) ? Response.ok().build() : Response.notModified().build();
        return response;
    }

    @Path("patientdetails/{mrn}/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientdetailsByMRN(@PathParam("mrn") String mrn) {
        Response response = null;
        Patientdetails patientdetails = personService.getPatientDetailsByMRN(mrn);
        response = (patientdetails == null) ? Response.noContent().build() : Response.ok(patientdetails).build();
        return response;
    }

    @Path("patientdetails/{mrn}/update")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateByMRN(@PathParam("mrn") String mrn,
            MultivaluedMap<String, String> formDataMap) {
        Response response = null;
        
        //hashMap declaration
        Map<String, String> formParameters = new HashMap<>();

        //iterate the keys
        Iterator<String> it = formDataMap.keySet().iterator();

        while (it.hasNext()) {
            String theKey = (String) it.next();
            formParameters.put(theKey, formDataMap.getFirst(theKey));
        }
        System.out.println("" + formParameters);
        Patientdetails updatePatientdetails = new Patientdetails();
        updatePatientdetails.setSalutation(formParameters.get("_selectSalutation"));
        updatePatientdetails.setFirsttime(formParameters.get("_firsttimeCheckbox"));
        updatePatientdetails.setPfirstname(formParameters.get("_pFirstName"));
        updatePatientdetails.setPmiddlname(formParameters.get("_pMiddleName"));
        updatePatientdetails.setPlastname(formParameters.get("_pLastName"));
        updatePatientdetails.setPdob(formParameters.get("_pdob"));
        updatePatientdetails.setPphonenumber(formParameters.get("_pphoneNumber"));
        updatePatientdetails.setPcountry(formParameters.get("_pcountrySelect"));
        updatePatientdetails.setPcounty(formParameters.get("_pcountySelect"));
        updatePatientdetails.setNokfirstname(formParameters.get("_NOKFirstName"));
        updatePatientdetails.setNokmiddlename(formParameters.get("_NOKMiddleName"));
        updatePatientdetails.setNoklastname(formParameters.get("_NOKLastName"));
        updatePatientdetails.setNokdob(formParameters.get("_NOKdob"));
        updatePatientdetails.setNokphonenumber(formParameters.get("_NOKphoneNumber"));
        updatePatientdetails.setNokcountry(formParameters.get("_NOKcountrySelect"));
        updatePatientdetails.setNokcounty(formParameters.get("_NOKcountySelect"));
        
        String status = personService.specialUpdatePatientDetailsByMRN(updatePatientdetails, mrn);
        System.out.println("" + status);
        
        response = "1".equals(status) ? Response.temporaryRedirect(URI.create("/JSPs/patientDetailsView.jsp")).build() : Response.notModified(status).build();
        
        return response;
        
    }
//    @Path("{id}/update")
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response updatePersonById(@PathParam("id") int id, PersonModel newPersonModel){
//        return Response.ok(personService.updatePersonById(newPersonModel, id)).build();
//    }

    @Path("{id}/update_")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response specialUpdatePersonById(@PathParam("id") int id,
            PersonModel newPersonModel) {
        return Response.ok(personService.specialUpdatePersonById(newPersonModel, id)).build();
    }

    @Path("{id}/patch")
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response patchPersonById(@PathParam("id") int id,
            PersonModel newPersonModel) {
        return Response.ok(personService.patchPersonById(newPersonModel, id)).build();
    }
}
