/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.m0ckinjay.crud;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

/**
 *
 * @author mo
 */
public class loginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");

        //get values from form parameters
        String username = request.getParameter("loginusername");
        char[] password = request.getParameter("loginpassword").toCharArray();

        //obtain instance of service class that handles db transactions
        PersonService personService = new PersonService();
        
        
        try {
            
            //obtain loaded or empty user object
            Optional<Systemusers> checkLoginUser = personService.updatedCheckLogin(username, password);
            //initialize destination page
            String destPage = null;
            
            //only proceed if user object has content which signifies presence of credentials
            if (checkLoginUser.isPresent()) {
                //get rid of obtain password
                Arrays.fill(password, Character.MIN_VALUE);

                System.out.println("LogiUser: " + checkLoginUser);
                
                //set default dest page to signup,
                destPage = "/JSPs/signUp.jsp";

                //presence of username in user object ensures that login check was successful
                if (checkLoginUser.get().getUsername() != null && checkLoginUser.get().getUsername().equals(username)) {
                    HttpSession session = request.getSession();
                    
                    //set an attribute of the user object that will be used as session attributes
                    session.setAttribute("user", checkLoginUser.get());
                    
                    //redirect to next page coz login successful
                    destPage = "/JSPs/patientDetailsView.jsp";
                } else {
                    //TODO - Handles the different erro where a user enters wrong credentials vs 
                    //when the user object isn't setup well for one reason or the other
                    String message = "No such user found, re-enter credentials";
                    request.setAttribute("errorMessage", message);
                }
            } else {
                String message = "Error during login, please try again";
                request.setAttribute("errorMessage", message);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new ServletException(e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
