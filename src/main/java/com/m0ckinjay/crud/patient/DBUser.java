/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.crud.patient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 *
 * @author mo
 */
public class DBUser {
    private EntityManagerFactory emf = null;
    private EntityManager em = null;
    public DBUser(){
        emf = Persistence.createEntityManagerFactory("com.m0ckinjay_crud_war_1.0PU");
        
    }

    public  Systemusers getUser(String username) {
        EntityManager em = emf.createEntityManager();
        return em.find(Systemusers.class, username);
    }

    public Systemusers getUser(int entryId) {
        EntityManager em = emf.createEntityManager();
        String qString = "SELECT s FROM Systemusers s WHERE s.entryid = :entryid";
        TypedQuery<Systemusers> q = em.createQuery(qString, Systemusers.class);
        q.setParameter("entryid", entryId);

        Systemusers user = null;
        try {
            System.out.println("Getting single user by id");
            user = q.getSingleResult();
            System.out.println("" + user.getUsername());
        } catch (NoResultException e) {
            System.out.println("" + e.getMessage());
        } finally {
            em.close();
        }
        return user;
//                find(Systemusers.class, entryId);

    }
    public String insertNewSystemUser(Systemusers newSystemUser){
        String status = null;
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(newSystemUser);
            trans.commit();
            status = "ok";
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            status = "nok";
        }finally{
            em.close();
        }
        return status;
    }
}
