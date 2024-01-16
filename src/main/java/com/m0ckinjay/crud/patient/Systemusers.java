/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.crud.patient;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author mo
 */
@Entity
@Table(name = "systemusers")
@NamedQueries({
    @NamedQuery(name = "Systemusers.findAll", query = "SELECT s FROM Systemusers s"),
    @NamedQuery(name = "Systemusers.findByEntryid", query = "SELECT s FROM Systemusers s WHERE s.entryid = :entryid"),
    @NamedQuery(name = "Systemusers.findByUsername", query = "SELECT s FROM Systemusers s WHERE s.username = :username"),
    @NamedQuery(name = "Systemusers.findByFirstname", query = "SELECT s FROM Systemusers s WHERE s.firstname = :firstname"),
    @NamedQuery(name = "Systemusers.findByLastname", query = "SELECT s FROM Systemusers s WHERE s.lastname = :lastname"),
    @NamedQuery(name = "Systemusers.findByEmailaddress", query = "SELECT s FROM Systemusers s WHERE s.emailaddress = :emailaddress"),
    @NamedQuery(name = "Systemusers.findByPassword", query = "SELECT s FROM Systemusers s WHERE s.password = :password"),
    @NamedQuery(name = "Systemusers.findByLogTs", query = "SELECT s FROM Systemusers s WHERE s.logTs = :logTs"),
    @NamedQuery(name = "Systemusers.findByPasswordSalt", query = "SELECT s FROM Systemusers s WHERE s.passwordSalt = :passwordSalt")})
public class Systemusers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "entryid")
    private int entryid;
    @Id
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "emailaddress")
    private String emailaddress;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "log_ts")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logTs;
    @Basic(optional = false)
    @Column(name = "password_salt")
    private String passwordSalt;

    public Systemusers() {
    }

    public Systemusers(String username) {
        this.username = username;
    }

    public Systemusers(String username, int entryid, String firstname,
            String lastname, String emailaddress, String password, Date logTs,
            String passwordSalt) {
        this.username = username;
        this.entryid = entryid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailaddress = emailaddress;
        this.password = password;
        this.logTs = logTs;
        this.passwordSalt = passwordSalt;
    }

    public int getEntryid() {
        return entryid;
    }

    public void setEntryid(int entryid) {
        this.entryid = entryid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLogTs() {
        return logTs;
    }

    public void setLogTs(Date logTs) {
        this.logTs = logTs;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Systemusers)) {
            return false;
        }
        Systemusers other = (Systemusers) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.m0ckinjay.crud.patient.Systemusers[ username=" + username + " ]";
    }
    
}
