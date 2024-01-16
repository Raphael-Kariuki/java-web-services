/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.crud.patient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;



/**
 *
 * @author mo
 */
public class DBUtil {
    public static EntityManager getEntityManager(String a){
        return Persistence.createEntityManagerFactory(a).createEntityManager();
    
    }
    
}
