/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.crud;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mo
 */
//@Entity
//@Table(catalog = "crud", schema = "public")
//@NamedQueries({
//    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
//    @NamedQuery(name = "Person.findByEntryid", query = "SELECT p FROM Person p WHERE p.entryid = :entryid"),
//    @NamedQuery(name = "Person.findByFirstname", query = "SELECT p FROM Person p WHERE p.firstname = :firstname"),
//    @NamedQuery(name = "Person.findByLastname", query = "SELECT p FROM Person p WHERE p.lastname = :lastname"),
//    @NamedQuery(name = "Person.findByAge", query = "SELECT p FROM Person p WHERE p.age = :age"),
//    @NamedQuery(name = "Person.findByHeight", query = "SELECT p FROM Person p WHERE p.height = :height"),
//    @NamedQuery(name = "Person.findByLogTs", query = "SELECT p FROM Person p WHERE p.logTs = :logTs")})
public class PersonModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer entryid;
    @Basic(optional = false)
    private String firstname;
    @Basic(optional = false)
    private String lastname;
    @Basic(optional = false)
    private int age;
    @Basic(optional = false)
    private double height;
    @Basic(optional = false)
    @Column(name = "log_ts")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logTs;

    public PersonModel() {
    }

    public PersonModel(Integer entryid) {
        this.entryid = entryid;
    }

    public PersonModel(Integer entryid, String firstname, String lastname, int age,
            double height, Date logTs) {
        this.entryid = entryid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.height = height;
        this.logTs = logTs;
    }

    public Integer getEntryid() {
        return entryid;
    }

    public void setEntryid(Integer entryid) {
        this.entryid = entryid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Date getLogTs() {
        return logTs;
    }

    public void setLogTs(Date logTs) {
        this.logTs = logTs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entryid != null ? entryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonModel)) {
            return false;
        }
        PersonModel other = (PersonModel) object;
        if ((this.entryid == null && other.entryid != null) || (this.entryid != null && !this.entryid.equals(other.entryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.m0ckinjay.crud.Person[ entryid=" + entryid + " ]";
    }
    
}
