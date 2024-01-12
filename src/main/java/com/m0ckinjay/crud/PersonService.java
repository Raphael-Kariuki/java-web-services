/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.crud;

import com.m0ckinjay.crud.patient.Patientdetails;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Logger;

import runner.passwordHashing;

/**
 *
 * @author mo
 */
public class PersonService {

    Connection conn;

    /**
     *
     */
    public PersonService() {
        try {
//            String jdbcUrl = "jdbc:postgresql://localhost:5432/";
//            String dbName = "crud";
            String dbUser = "mo";
            String dbUserPass = "nvUSrEu09nbp7mxAFmPJM6MB8";
//            
            String jdbcUrl = "jdbc:postgresql://db1.mojay:5432/crud";
            Properties props = new Properties();
            props.setProperty("user", dbUser);
            props.setProperty("password", dbUserPass);
            props.setProperty("ssl", "true");
            props.setProperty("sslrootcert", "/home/mo/postgres_certs/root.crt");

            Class.forName("org.postgresql.Driver");
//            conn = DriverManager.getConnection(String.format(jdbcUrl + dbName), dbUser, dbUserPass);
            conn = DriverManager.getConnection(jdbcUrl, props);
            System.out.println("Success conn");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(" " + e.getMessage());
        }

    }

    /**
     *
     * @param person
     * @return
     */
    public PersonModel insertPerson(PersonModel person) {
        String insertSQLString = "insert into person(firstName, lastName, age, height) values (?,?,?,?)";
        String status = null;
        try {
            PreparedStatement insertPreparedStatement = conn.prepareStatement(insertSQLString);
            insertPreparedStatement.setString(1, person.getFirstname());
            insertPreparedStatement.setString(2, person.getLastname());
            insertPreparedStatement.setInt(3, person.getAge());
            insertPreparedStatement.setDouble(4, person.getHeight());

            status = String.valueOf(insertPreparedStatement.executeUpdate());

        } catch (SQLException e) {
            status = e.getMessage();
        }
        return person;
    }

    /**
     *
     * @param newPatient
     * @return
     */
    public String insertPatientrecords(Patientdetails newPatient) {
        String insertSQLString = "insert into patientdetails( mrn,salutation,firsttime,pfirstname,pmiddlename,plastname,pdob,"
                + "pphonenumber,pcountry,pcounty,  nokfirstname,  nokmiddlename,noklastname,  nokdob,  nokphonenumber,\n"
                + "             nokcountry,  nokcounty,  log_ts) values(?,?,?,?,?,?,CAST(? as date),?,?,?,?,?,?,CAST(? as date),?,?,?,DEFAULT)";
        String status = null;
        System.out.println("" + newPatient.getFirsttime());
        try {
            PreparedStatement insertPreparedStatement = conn.prepareStatement(insertSQLString);
            insertPreparedStatement.setString(1, newPatient.getMrn());
            insertPreparedStatement.setString(2, newPatient.getSalutation());
            insertPreparedStatement.setString(3, (((newPatient.getFirsttime()) == null) ? "false" : "true"));
            insertPreparedStatement.setString(4, newPatient.getPfirstname());
            insertPreparedStatement.setString(5, newPatient.getPmiddlname());
            insertPreparedStatement.setString(6, newPatient.getPlastname());
            insertPreparedStatement.setString(7, newPatient.getPdob());
            insertPreparedStatement.setString(8, newPatient.getPphonenumber());
            insertPreparedStatement.setString(9, newPatient.getPcountry());
            insertPreparedStatement.setString(10, newPatient.getPcounty());
            insertPreparedStatement.setString(11, newPatient.getNokfirstname());
            insertPreparedStatement.setString(12, newPatient.getNokmiddlename());
            insertPreparedStatement.setString(13, newPatient.getNoklastname());
            insertPreparedStatement.setString(14, newPatient.getNokdob());
            insertPreparedStatement.setString(15, newPatient.getNokphonenumber());
            insertPreparedStatement.setString(16, newPatient.getNokcountry());
            insertPreparedStatement.setString(17, newPatient.getNokcounty());

            status = String.valueOf(insertPreparedStatement.executeUpdate());

        } catch (SQLException e) {
            status = e.getMessage();
        }
        return status;
    }

    /**
     *
     * @param newUser
     * @return
     */
    public String registerSystemUser(Systemusers newUser) {
        /*
        INSERT INTO systemusers (username, firstname, lastname, emailaddress, password, log_ts)
	VALUES (?,?,?,?,?, DEFAULT)

         */
        String insertSQLString = " INSERT INTO systemusers (username, firstname, lastname, emailaddress, password, log_ts, password_salt) \n"
                + "	VALUES (?,?,?,?,?, DEFAULT,?)";
        PreparedStatement registerUserPreparedStatement = null;
        String[] hashedPasswd = new String[2];
        String status = null;
        try {
            try {
                //hash password before insert
                hashedPasswd = passwordHashing.makeHashedPassword(Optional.of(newUser.getPassword()));
            } catch (Exception e) {
                System.err.println("Error mangling the password");
            }
            registerUserPreparedStatement = conn.prepareStatement(insertSQLString);
            registerUserPreparedStatement.setString(1, newUser.getUsername());
            registerUserPreparedStatement.setString(2, newUser.getFirstname());
            registerUserPreparedStatement.setString(3, newUser.getLastname());
            registerUserPreparedStatement.setString(4, newUser.getEmailaddress());
            registerUserPreparedStatement.setString(5, hashedPasswd[0]);
            registerUserPreparedStatement.setString(6, hashedPasswd[1]);
            status = "" + registerUserPreparedStatement.executeUpdate();

        } catch (SQLException e) {
            status = e.getMessage();
            System.out.println("" + status);

        }
        return status;
    }

    /**
     *
     * @return @throws SQLException
     */
    public List<PersonModel> getallPerson() throws SQLException {
        List<PersonModel> dataFromDb = new ArrayList<>();

        String selectQuery = "select entryid,* from person";
        PreparedStatement selectPreparedStatement = null;
        ResultSet rs = null;

        try {
            selectPreparedStatement = conn.prepareStatement(selectQuery);
            rs = selectPreparedStatement.executeQuery();
            while (rs.next()) {
                PersonModel person = new PersonModel();
                person.setEntryid(rs.getInt("entryid"));
                person.setFirstname(rs.getString("firstname"));
                person.setLastname(rs.getString("lastname"));
                person.setAge(rs.getInt("age"));
                person.setHeight(rs.getDouble("height"));
                dataFromDb.add(person);
            }

        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
        return dataFromDb;
    }

    /**
     *
     * @return @throws SQLException
     */
    public List<Patientdetails> getallPatientDetails() throws SQLException {
        List<Patientdetails> patientDataFromDb = new ArrayList<>();

        String selectQuery = "select entryid,* from public.patientdetails limit 100";
        PreparedStatement selectPreparedStatement = null;
        ResultSet rs = null;

        try {
            selectPreparedStatement = conn.prepareStatement(selectQuery);
            rs = selectPreparedStatement.executeQuery();
            while (rs.next()) {
                Patientdetails singlePatientdetails = new Patientdetails();
                singlePatientdetails.setEntryid(Integer.parseInt(rs.getString("entryid")));
                singlePatientdetails.setMrn(rs.getString("mrn"));
                singlePatientdetails.setSalutation(rs.getString("salutation"));
                singlePatientdetails.setFirsttime(rs.getString("firsttime"));
                singlePatientdetails.setPfirstname(rs.getString("pfirstname"));
                singlePatientdetails.setPmiddlname(rs.getString("pmiddlename"));
                singlePatientdetails.setPlastname(rs.getString("plastname"));
                singlePatientdetails.setPdob(rs.getString("pdob"));
                singlePatientdetails.setPphonenumber(rs.getString("pphonenumber"));
                singlePatientdetails.setPcountry(rs.getString("pcountry"));
                singlePatientdetails.setPcounty(rs.getString("pcounty"));
                singlePatientdetails.setNokfirstname(rs.getString("nokfirstname"));
                singlePatientdetails.setNokmiddlename(rs.getString("nokmiddlename"));
                singlePatientdetails.setNoklastname(rs.getString("noklastname"));
                singlePatientdetails.setNokdob(rs.getString("nokdob"));
                singlePatientdetails.setNokphonenumber(rs.getString("nokphonenumber"));
                singlePatientdetails.setNokcountry(rs.getString("nokcountry"));
                singlePatientdetails.setNokcounty(rs.getString("nokcounty"));
                patientDataFromDb.add(singlePatientdetails);
            }

        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
        return patientDataFromDb;
    }

    /**
     *
     * @param mrn
     * @return
     */
    public String deletePatientDetailsByMRN(String mrn) {

        String deleteQuery = "delete from public.patientdetails where mrn =  ?";
        PreparedStatement preparedStatement = null;
        String status = null;

        try {
            preparedStatement = conn.prepareStatement(deleteQuery);
            preparedStatement.setString(1, mrn);

            status = String.valueOf(preparedStatement.executeUpdate());
        } catch (SQLException e) {
            status = e.getMessage();
        }
        return status;
    }

    /**
     *
     * @param mrn
     * @return
     */
    public Patientdetails getPatientDetailsByMRN(String mrn) {
        String getQuery = "select entryid,* from public.patientdetails where mrn = ?";
        PreparedStatement preparedStatement = null;
        String status = null;
        ResultSet resultSet = null;
        Patientdetails singlePatientdetails = new Patientdetails();
        try {
            preparedStatement = conn.prepareStatement(getQuery);
            preparedStatement.setString(1, mrn);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                singlePatientdetails.setEntryid(Integer.parseInt(resultSet.getString("entryid")));
                singlePatientdetails.setMrn(resultSet.getString("mrn"));
                singlePatientdetails.setSalutation(resultSet.getString("salutation"));
                singlePatientdetails.setFirsttime(resultSet.getString("firsttime"));
                singlePatientdetails.setPfirstname(resultSet.getString("pfirstname"));
                singlePatientdetails.setPmiddlname(resultSet.getString("pmiddlename"));
                singlePatientdetails.setPlastname(resultSet.getString("plastname"));
                singlePatientdetails.setPdob(resultSet.getString("pdob"));
                singlePatientdetails.setPphonenumber(resultSet.getString("pphonenumber"));
                singlePatientdetails.setPcountry(resultSet.getString("pcountry"));
                singlePatientdetails.setPcounty(resultSet.getString("pcounty"));
                singlePatientdetails.setNokfirstname(resultSet.getString("nokfirstname"));
                singlePatientdetails.setNokmiddlename(resultSet.getString("nokmiddlename"));
                singlePatientdetails.setNoklastname(resultSet.getString("noklastname"));
                singlePatientdetails.setNokdob(resultSet.getString("nokdob"));
                singlePatientdetails.setNokphonenumber(resultSet.getString("nokphonenumber"));
                singlePatientdetails.setNokcountry(resultSet.getString("nokcountry"));
                singlePatientdetails.setNokcounty(resultSet.getString("nokcounty"));

            }
            status = "1";
        } catch (SQLException e) {
            status = e.getMessage();
        }
        return singlePatientdetails;
    }
    //why special, method that executes an update should be a PUT, I use POST because forms support 2 methods GET and POST. It works

    /**
     *
     * @param updatePatientdetails
     * @param mrn
     * @return
     */
    public String specialUpdatePatientDetailsByMRN(
            Patientdetails updatePatientdetails, String mrn) {
        /*
        mrn,salutation,firsttime,pfirstname,pmiddlname,plastname,pdob,"
                + "pphonenumber,pcountry,pcounty,  nokfirstname,  nokmiddlename,noklastname,  nokdob,  nokphonenumber,\n" +
"             nokcountry,  nokcounty
         */
        String updateQuery = "update public.patientdetails set salutation = ?,firsttime = ?,pfirstname = ?,pmiddlename =? ,plastname = ?,pdob = CAST(? as date) ,"
                + "pphonenumber = ?,pcountry = ?,pcounty = ?,  nokfirstname = ?,  nokmiddlename = ?,noklastname = ? ,  nokdob = CAST(? as date),  nokphonenumber = ?,"
                + "nokcountry = ?,  nokcounty = ? where mrn = ? ";
        PreparedStatement updatePreparedStatement = null;
        String updateStatus = null;
        System.out.println("" + mrn + updatePatientdetails);
        try {
            updatePreparedStatement = conn.prepareStatement(updateQuery);
            updatePreparedStatement.setString(1, updatePatientdetails.getSalutation());
            updatePreparedStatement.setString(2, updatePatientdetails.getFirsttime());
            updatePreparedStatement.setString(3, updatePatientdetails.getPfirstname());
            updatePreparedStatement.setString(4, updatePatientdetails.getPmiddlname());
            updatePreparedStatement.setString(5, updatePatientdetails.getPlastname());
            updatePreparedStatement.setString(6, updatePatientdetails.getPdob());
            updatePreparedStatement.setString(7, updatePatientdetails.getPphonenumber());
            updatePreparedStatement.setString(8, updatePatientdetails.getPcountry());
            updatePreparedStatement.setString(9, updatePatientdetails.getPcounty());
            updatePreparedStatement.setString(10, updatePatientdetails.getNokfirstname());
            updatePreparedStatement.setString(11, updatePatientdetails.getNokmiddlename());
            updatePreparedStatement.setString(12, updatePatientdetails.getNoklastname());
            updatePreparedStatement.setString(13, updatePatientdetails.getNokdob());
            updatePreparedStatement.setString(14, updatePatientdetails.getNokphonenumber());
            updatePreparedStatement.setString(15, updatePatientdetails.getNokcountry());
            updatePreparedStatement.setString(16, updatePatientdetails.getNokcounty());
            updatePreparedStatement.setString(17, mrn);

            updateStatus = String.valueOf(updatePreparedStatement.executeUpdate());
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            updateStatus = e.getMessage();
        }
        return updateStatus;
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public PersonModel getPersonById(int id) throws SQLException {

        String selectQuery = "select * from person where entryid = ?";

        PreparedStatement selectPreparedStatement = null;
        ResultSet rs = null;
        PersonModel person = new PersonModel();

        try {
            selectPreparedStatement = conn.prepareStatement(selectQuery);
            selectPreparedStatement.setInt(1, id);

            rs = selectPreparedStatement.executeQuery();

            while (rs.next()) {
                person.setFirstname(rs.getString("firstname"));
                person.setLastname(rs.getString("lastname"));
                person.setAge(rs.getInt("age"));
                person.setHeight(rs.getDouble("height"));
            }

        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
        return person;
    }

    /**
     *
     * @param id
     * @return
     */
    public int deletePersonById(int id) {
        String deleteQuery = "delete from person where entryid = ?";

        PreparedStatement deletePreparedStatement = null;
        Integer deleteStatus = null;

        try {
            deletePreparedStatement = conn.prepareStatement(deleteQuery);
            deletePreparedStatement.setInt(1, id);
            /*
            *ResultSet 	executeQuery() - Executes the SQL query in this PreparedStatement object and returns the ResultSet object generated by the query.
            *int executeUpdate() - Executes the SQL statement in this PreparedStatement object,
                which must be an SQL Data Manipulation Language (DML) statement, such as INSERT, UPDATE or DELETE;
                or an SQL statement that returns nothing, such as a DDL statement.
             */
            deleteStatus = deletePreparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
        return deleteStatus;
    }

    /**
     *
     * @param newPerson
     * @param id
     * @return
     */
    public String updatePersonById(PersonModel newPerson, int id) {
        String updateQuery = "update public.person set firstname = ?, lastname = ?, age = ?, height = ? where entryid = ?";
        PreparedStatement updatePreparedStatement = null;
        Integer updateStatus = null;
        String errorMessage = null;

        try {
            updatePreparedStatement = conn.prepareStatement(updateQuery);
            updatePreparedStatement.setString(1, newPerson.getFirstname());
            updatePreparedStatement.setString(2, newPerson.getLastname());
            updatePreparedStatement.setInt(3, newPerson.getAge());
            updatePreparedStatement.setDouble(4, newPerson.getHeight());
            updatePreparedStatement.setInt(5, id);

            updateStatus = updatePreparedStatement.executeUpdate();
        } catch (SQLException e) {
            updateStatus = 404;
            System.out.println("" + e.getMessage());
            errorMessage = e.getMessage();
        }
        return errorMessage;
    }
    //why special, method that executes an update should be a PUT, I use POST because forms support 2 methods GET and POST. It works

    /**
     *
     * @param newPerson
     * @param id
     * @return
     */
    public int specialUpdatePersonById(PersonModel newPerson, int id) {
        String updateQuery = "update public.person set firstname = ?, lastname = ?, age = ?, height = ? where entryid = ?";
        PreparedStatement updatePreparedStatement = null;
        Integer updateStatus = null;
        String errorMessage = null;

        try {
            updatePreparedStatement = conn.prepareStatement(updateQuery);
            updatePreparedStatement.setString(1, newPerson.getFirstname());
            updatePreparedStatement.setString(2, newPerson.getLastname());
            updatePreparedStatement.setInt(3, newPerson.getAge());
            updatePreparedStatement.setDouble(4, newPerson.getHeight());
            updatePreparedStatement.setInt(5, id);

            updateStatus = updatePreparedStatement.executeUpdate();
        } catch (SQLException e) {
            updateStatus = 404;
            System.out.println("" + e.getMessage());
            errorMessage = e.getMessage();
        }
        return updateStatus;
    }

    /**
     *
     * @param newPerson
     * @param id
     * @return
     */
    public String patchPersonById(PersonModel newPerson, int id) {
        String updateQuery = "update public.person set firstname = ? where entryid = ?";
        PreparedStatement updatePreparedStatement = null;
        Integer updateStatus = null;
        String errorMessage = null;

        try {
            updatePreparedStatement = conn.prepareStatement(updateQuery);
            updatePreparedStatement.setString(1, newPerson.getFirstname());
            updatePreparedStatement.setInt(2, id);

            updateStatus = updatePreparedStatement.executeUpdate();
        } catch (SQLException e) {
            updateStatus = 404;
            System.out.println("" + e.getMessage());
            errorMessage = e.getMessage();
        }
        return errorMessage;
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public Systemusers checkLogin(String username, String password) {
        Systemusers loginUser = new Systemusers();

        String loginCheckSelectQuery = "select * from public.systemusers where public.systemusers.username = ? and public.systemusers.password = ?";
        PreparedStatement preparedLoginCheckPreparedStatement = null;
        ResultSet rs = null;
        String error = "No such user found";
        System.out.println(username + " " + password);
        try {
            preparedLoginCheckPreparedStatement = conn.prepareStatement(loginCheckSelectQuery);
            preparedLoginCheckPreparedStatement.setString(1, username);
            preparedLoginCheckPreparedStatement.setString(2, password);

            rs = preparedLoginCheckPreparedStatement.executeQuery();

            if (rs.next()) {

                loginUser.setUsername(rs.getString("username"));
                loginUser.setEmailaddress(rs.getString("emailaddress"));
            } else {
                System.out.println("" + error);
            }

        } catch (SQLException e) {
            System.out.println("Exception" + e.getMessage());
        }
        return loginUser;
    }

    /**
     * How to setup the loginCheck
     * 1. Get username and password from servlet - passed as args to method 
     * 2. Get user details from db(emailAddress,password -key(in verifying the user), password_salt - salt in verifying the user) 
     * For security reasons we should work with password as char array
     * Meaning we have to modify the hashing process to receive charArray
     *
     * @param username
     * @param password
     * @return userObject class 
     *
     */
    public Optional<Systemusers> updatedCheckLogin(String username,
            char [] password) {
        Optional<Systemusers> loginUser = Optional.of(new Systemusers());

        if (username.isEmpty() || username.equals("") || password.length < 1 || password.equals("")) {
            System.err.println("Blank password or Username");
            loginUser = Optional.empty();
        } else {
            String loginCheckQuery = "SELECT emailaddress, password, password_salt FROM public.systemusers where username = ?";
            ResultSet rs = null;
            PreparedStatement preparedStatement = null;
            char[] inputPasswdCharArray = password;

            String dbPasswdKey = null;
            String emailAddress = null;
            String password_salt = null;
            try {
                preparedStatement = conn.prepareStatement(loginCheckQuery);
                preparedStatement.setString(1, username);
                rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    dbPasswdKey = rs.getString("password");
                    emailAddress = rs.getString("emailaddress");
                    password_salt = rs.getString("password_salt");
                }
            } catch (SQLException e) {
                System.out.println("Error getting details from Db " + e.getMessage());
            }
            
            //confirm password supplied matches that in the database
            Boolean confirmPassword = passwordHashing.verifyPassword(inputPasswdCharArray, dbPasswdKey, password_salt);
            
            //get rid of password
            Arrays.fill(inputPasswdCharArray, Character.MIN_VALUE);

            //after all checks setup the user object 
            if (confirmPassword) {
                loginUser.get().setUsername(username);
                loginUser.get().setEmailaddress(emailAddress);
            }
        }

        return loginUser;
    }

}
