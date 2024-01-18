/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.crud.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

/**
 *
 * @author mo
 */
public class EntityManagerCreator {
    public static EntityManager getEntityManager(){
        EntityManager em = Persistence.createEntityManagerFactory("com.m0ckinjay_crud_war_1.0PU").createEntityManager();
        return em;
    }
}
