/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.crud.service;

import com.m0ckinjay.crud.model.Patientdetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author mo
 */
public class PatientDetailsJPAController {

    private EntityManagerFactory emf = null;

    public PatientDetailsJPAController() {
        emf = Persistence.createEntityManagerFactory("com.m0ckinjay_crud_war_1.0PU");
    }
    
    //method to get patient details by mrn
    public static Patientdetails getPatientdetails(String mrn){
//        EntityManager em = emf.createEntityManager();
        EntityManager em = EntityManagerCreator.getEntityManager();
        return em.find(Patientdetails.class, mrn);
    }
    
    //method to insert patient records
    public static String insertPatientRecords(Patientdetails newPatientdetails){
        EntityManager em = EntityManagerCreator.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        String status = null;
        
        try {
            trans.begin();
            em.persist(newPatientdetails);
            trans.commit();
            status = "ok";
        } catch (Exception e) {
            System.out.println("Error committing patient record");
            trans.rollback();
            status = "nok";
        }finally{
            em.close();
        }
        return status;
    }
    //method to obtain all patients with their details
    public static List<Patientdetails> getPatientData(){
        EntityManager em = EntityManagerCreator.getEntityManager();
        TypedQuery<Patientdetails> allPatientDetailsQuery = em.createNamedQuery("Patientdetails.findAll", Patientdetails.class);
        List<Patientdetails> patientData = allPatientDetailsQuery.getResultList();
        return patientData;
    }
    
}
