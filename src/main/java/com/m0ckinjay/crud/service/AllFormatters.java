/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.crud.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mo
 */
public class AllFormatters {
    public static Date stringDate(String dateString){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
        Date formattedDate = null;
        try {
            formattedDate =  formatter.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(AllFormatters.class.getName()).log(Level.SEVERE, null, ex);
        }
        return formattedDate;
    }
    
}
