/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.crud.patient;

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
//    @NamedQuery(name = "Patientdetails.findAll", query = "SELECT p FROM Patientdetails p")})
public class Patientdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    private int entryid;
    @Id
    @Basic(optional = false)
    private String mrn;
    @Basic(optional = false)
    private String salutation;
    @Basic(optional = false)
    private String firsttime;
    @Basic(optional = false)
    private String pfirstname;
    @Basic(optional = false)
    private String pmiddlname;
    @Basic(optional = false)
    private String plastname;
    @Basic(optional = false)
    private String pdob;
    @Basic(optional = false)
    private String pphonenumber;
    @Basic(optional = false)
    private String pcountry;
    @Basic(optional = false)
    private String pcounty;
    @Basic(optional = false)
    private String nokfirstname;
    @Basic(optional = false)
    private String nokmiddlename;
    @Basic(optional = false)
    private String noklastname;
    @Basic(optional = false)
    private String nokdob;
    @Basic(optional = false)
    private String nokphonenumber;
    @Basic(optional = false)
    private String nokcountry;
    @Basic(optional = false)
    private String nokcounty;
    @Basic(optional = false)
    @Column(name = "log_ts")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logTs;

    public Patientdetails() {
    }

    public Patientdetails(String mrn) {
        this.mrn = mrn;
    }

    public Patientdetails(String mrn, int entryid, String salutation,
            String firsttime, String pfirstname, String pmiddlname,
            String plastname, String pdob, String pphonenumber, String pcountry,
            String pcounty, String nokfirstname, String nokmiddlename,
            String noklastname, String nokdob, String nokphonenumber,
            String nokcountry, String nokcounty, Date logTs) {
        this.mrn = mrn;
        this.entryid = entryid;
        this.salutation = salutation;
        this.firsttime = firsttime;
        this.pfirstname = pfirstname;
        this.pmiddlname = pmiddlname;
        this.plastname = plastname;
        this.pdob = pdob;
        this.pphonenumber = pphonenumber;
        this.pcountry = pcountry;
        this.pcounty = pcounty;
        this.nokfirstname = nokfirstname;
        this.nokmiddlename = nokmiddlename;
        this.noklastname = noklastname;
        this.nokdob = nokdob;
        this.nokphonenumber = nokphonenumber;
        this.nokcountry = nokcountry;
        this.nokcounty = nokcounty;
        this.logTs = logTs;
    }

    public int getEntryid() {
        return entryid;
    }

    public void setEntryid(int entryid) {
        this.entryid = entryid;
    }

    public String getMrn() {
        return mrn;
    }

    public void setMrn(String mrn) {
        this.mrn = mrn;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFirsttime() {
        return firsttime;
    }

    public void setFirsttime(String firsttime) {
        this.firsttime = firsttime;
    }

    public String getPfirstname() {
        return pfirstname;
    }

    public void setPfirstname(String pfirstname) {
        this.pfirstname = pfirstname;
    }

    public String getPmiddlname() {
        return pmiddlname;
    }

    public void setPmiddlname(String pmiddlname) {
        this.pmiddlname = pmiddlname;
    }

    public String getPlastname() {
        return plastname;
    }

    public void setPlastname(String plastname) {
        this.plastname = plastname;
    }

    public String getPdob() {
        return pdob;
    }

    public void setPdob(String pdob) {
        this.pdob = pdob;
    }

    public String getPphonenumber() {
        return pphonenumber;
    }

    public void setPphonenumber(String pphonenumber) {
        this.pphonenumber = pphonenumber;
    }

    public String getPcountry() {
        return pcountry;
    }

    public void setPcountry(String pcountry) {
        this.pcountry = pcountry;
    }

    public String getPcounty() {
        return pcounty;
    }

    public void setPcounty(String pcounty) {
        this.pcounty = pcounty;
    }

    public String getNokfirstname() {
        return nokfirstname;
    }

    public void setNokfirstname(String nokfirstname) {
        this.nokfirstname = nokfirstname;
    }

    public String getNokmiddlename() {
        return nokmiddlename;
    }

    public void setNokmiddlename(String nokmiddlename) {
        this.nokmiddlename = nokmiddlename;
    }

    public String getNoklastname() {
        return noklastname;
    }

    public void setNoklastname(String noklastname) {
        this.noklastname = noklastname;
    }

    public String getNokdob() {
        return nokdob;
    }

    public void setNokdob(String nokdob) {
        this.nokdob = nokdob;
    }

    public String getNokphonenumber() {
        return nokphonenumber;
    }

    public void setNokphonenumber(String nokphonenumber) {
        this.nokphonenumber = nokphonenumber;
    }

    public String getNokcountry() {
        return nokcountry;
    }

    public void setNokcountry(String nokcountry) {
        this.nokcountry = nokcountry;
    }

    public String getNokcounty() {
        return nokcounty;
    }

    public void setNokcounty(String nokcounty) {
        this.nokcounty = nokcounty;
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
        hash += (mrn != null ? mrn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patientdetails)) {
            return false;
        }
        Patientdetails other = (Patientdetails) object;
        if ((this.mrn == null && other.mrn != null) || (this.mrn != null && !this.mrn.equals(other.mrn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.m0ckinjay.crud.patient.Patientdetails[ mrn=" + mrn + " ]";
    }
    
}
