/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.crud.model;

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
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author mo
 */
@Entity
@Table(name = "patientdetails", catalog = "crud", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Patientdetails.findAll", query = "SELECT p FROM Patientdetails p"),
    @NamedQuery(name = "Patientdetails.findByEntryid", query = "SELECT p FROM Patientdetails p WHERE p.entryid = :entryid"),
    @NamedQuery(name = "Patientdetails.findByMrn", query = "SELECT p FROM Patientdetails p WHERE p.mrn = :mrn"),
    @NamedQuery(name = "Patientdetails.findBySalutation", query = "SELECT p FROM Patientdetails p WHERE p.salutation = :salutation"),
    @NamedQuery(name = "Patientdetails.findByFirsttime", query = "SELECT p FROM Patientdetails p WHERE p.firsttime = :firsttime"),
    @NamedQuery(name = "Patientdetails.findByPfirstname", query = "SELECT p FROM Patientdetails p WHERE p.pfirstname = :pfirstname"),
    @NamedQuery(name = "Patientdetails.findByPmiddlename", query = "SELECT p FROM Patientdetails p WHERE p.pmiddlename = :pmiddlename"),
    @NamedQuery(name = "Patientdetails.findByPlastname", query = "SELECT p FROM Patientdetails p WHERE p.plastname = :plastname"),
    @NamedQuery(name = "Patientdetails.findByPdob", query = "SELECT p FROM Patientdetails p WHERE p.pdob = :pdob"),
    @NamedQuery(name = "Patientdetails.findByPphonenumber", query = "SELECT p FROM Patientdetails p WHERE p.pphonenumber = :pphonenumber"),
    @NamedQuery(name = "Patientdetails.findByPcountry", query = "SELECT p FROM Patientdetails p WHERE p.pcountry = :pcountry"),
    @NamedQuery(name = "Patientdetails.findByPcounty", query = "SELECT p FROM Patientdetails p WHERE p.pcounty = :pcounty"),
    @NamedQuery(name = "Patientdetails.findByNokfirstname", query = "SELECT p FROM Patientdetails p WHERE p.nokfirstname = :nokfirstname"),
    @NamedQuery(name = "Patientdetails.findByNokmiddlename", query = "SELECT p FROM Patientdetails p WHERE p.nokmiddlename = :nokmiddlename"),
    @NamedQuery(name = "Patientdetails.findByNoklastname", query = "SELECT p FROM Patientdetails p WHERE p.noklastname = :noklastname"),
    @NamedQuery(name = "Patientdetails.findByNokdob", query = "SELECT p FROM Patientdetails p WHERE p.nokdob = :nokdob"),
    @NamedQuery(name = "Patientdetails.findByNokphonenumber", query = "SELECT p FROM Patientdetails p WHERE p.nokphonenumber = :nokphonenumber"),
    @NamedQuery(name = "Patientdetails.findByNokcountry", query = "SELECT p FROM Patientdetails p WHERE p.nokcountry = :nokcountry"),
    @NamedQuery(name = "Patientdetails.findByNokcounty", query = "SELECT p FROM Patientdetails p WHERE p.nokcounty = :nokcounty"),
    @NamedQuery(name = "Patientdetails.findByLogTs", query = "SELECT p FROM Patientdetails p WHERE p.logTs = :logTs")})
public class Patientdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "entryid")
    private int entryid;
    @Id
    @Basic(optional = false)
    @Column(name = "mrn")
    private String mrn;
    @Basic(optional = false)
    @Column(name = "salutation")
    private String salutation;
    @Column(name = "firsttime")
    private String firsttime;
    @Basic(optional = false)
    @Column(name = "pfirstname")
    private String pfirstname;
    @Basic(optional = false)
    @Column(name = "pmiddlename")
    private String pmiddlename;
    @Basic(optional = false)
    @Column(name = "plastname")
    private String plastname;
    @Basic(optional = false)
    @Column(name = "pdob")
    @Temporal(TemporalType.DATE)
    private Date pdob;
    @Basic(optional = false)
    @Column(name = "pphonenumber")
    private String pphonenumber;
    @Basic(optional = false)
    @Column(name = "pcountry")
    private String pcountry;
    @Basic(optional = false)
    @Column(name = "pcounty")
    private String pcounty;
    @Basic(optional = false)
    @Column(name = "nokfirstname")
    private String nokfirstname;
    @Basic(optional = false)
    @Column(name = "nokmiddlename")
    private String nokmiddlename;
    @Basic(optional = false)
    @Column(name = "noklastname")
    private String noklastname;
    @Basic(optional = false)
    @Column(name = "nokdob")
    @Temporal(TemporalType.DATE)
    private Date nokdob;
    @Basic(optional = false)
    @Column(name = "nokphonenumber")
    private String nokphonenumber;
    @Basic(optional = false)
    @Column(name = "nokcountry")
    private String nokcountry;
    @Basic(optional = false)
    @Column(name = "nokcounty")
    private String nokcounty;
    @Basic(optional = false)
    @Column(name = "log_ts")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date logTs;

    public Patientdetails() {
    }

    public Patientdetails(String mrn) {
        this.mrn = mrn;
    }

    public Patientdetails(String mrn, int entryid, String salutation,
            String pfirstname, String pmiddlename, String plastname, Date pdob,
            String pphonenumber, String pcountry, String pcounty,
            String nokfirstname, String nokmiddlename, String noklastname,
            Date nokdob, String nokphonenumber, String nokcountry,
            String nokcounty, Date logTs) {
        this.mrn = mrn;
        this.entryid = entryid;
        this.salutation = salutation;
        this.pfirstname = pfirstname;
        this.pmiddlename = pmiddlename;
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

    public String getPmiddlename() {
        return pmiddlename;
    }

    public void setPmiddlename(String pmiddlename) {
        this.pmiddlename = pmiddlename;
    }

    public String getPlastname() {
        return plastname;
    }

    public void setPlastname(String plastname) {
        this.plastname = plastname;
    }

    public Date getPdob() {
        return pdob;
    }

    public void setPdob(Date pdob) {
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

    public Date getNokdob() {
        return nokdob;
    }

    public void setNokdob(Date nokdob) {
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
        return "com.m0ckinjay.crud.model.Patientdetails[ mrn=" + mrn + " ]";
    }
    
}
