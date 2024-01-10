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
//    @NamedQuery(name = "Systemusers.findAll", query = "SELECT s FROM Systemusers s")})
public class Systemusers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    private int entryid;
    @Id
    @Basic(optional = false)
    private String username;
    @Basic(optional = false)
    private String firstname;
    @Basic(optional = false)
    private String lastname;
    @Basic(optional = false)
    private String emailaddress;
    @Basic(optional = false)
    private String password;
    @Basic(optional = false)
    @Column(name = "log_ts")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logTs;

    public Systemusers() {
    }

    public Systemusers(String username) {
        this.username = username;
    }

    public Systemusers(String username, int entryid, String firstname,
            String lastname, String emailaddress, String password, Date logTs) {
        this.username = username;
        this.entryid = entryid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailaddress = emailaddress;
        this.password = password;
        this.logTs = logTs;
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
        return "com.m0ckinjay.crud.Systemusers[ username=" + username + " ]";
    }
    
}
