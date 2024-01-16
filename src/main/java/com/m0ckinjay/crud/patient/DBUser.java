/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.crud.patient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

/**
 *
 * @author mo
 */
public class DBUser {
    public static Systemusers getUser(int entryId){
        EntityManager em = DBUtil.getEntityManager("com.m0ckinjay_crud_war_1.0PU");
        String qString = "SELECT s FROM Systemusers s WHERE s.entryid = :entryid";
        TypedQuery<Systemusers> q = em.createQuery(qString,Systemusers.class);
        q.setParameter("entryid", entryId);
        
        Systemusers user = null;
        try {
            System.out.println("Getting single user by id");
            user = q.getSingleResult();
            System.out.println("" + user.getUsername());
        } catch (NoResultException e) {
            System.out.println("" + e.getMessage());
        }finally{
        em.close();
        }
       return user;
//                find(Systemusers.class, entryId);
        
    }
}
