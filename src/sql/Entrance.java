/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Patrick
 */
@Entity
@Table(name = "entrance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrance.findAll", query = "SELECT e FROM Entrance e"),
    @NamedQuery(name = "Entrance.findByApplicantId", query = "SELECT e FROM Entrance e WHERE e.applicantId = :applicantId"),
    @NamedQuery(name = "Entrance.findByFirstname", query = "SELECT e FROM Entrance e WHERE e.firstname = :firstname"),
    @NamedQuery(name = "Entrance.findByLastname", query = "SELECT e FROM Entrance e WHERE e.lastname = :lastname"),
    @NamedQuery(name = "Entrance.findByEmail", query = "SELECT e FROM Entrance e WHERE e.email = :email"),
    @NamedQuery(name = "Entrance.findByTimesTaken", query = "SELECT e FROM Entrance e WHERE e.timesTaken = :timesTaken"),
    @NamedQuery(name = "Entrance.findByPassed", query = "SELECT e FROM Entrance e WHERE e.passed = :passed"),
    @NamedQuery(name = "Entrance.findByLastTest", query = "SELECT e FROM Entrance e WHERE e.lastTest = :lastTest"),
    @NamedQuery(name = "Entrance.findByJoindate", query = "SELECT e FROM Entrance e WHERE e.joindate = :joindate"),
    @NamedQuery(name = "Entrance.findByLastip", query = "SELECT e FROM Entrance e WHERE e.lastip = :lastip"),
    @NamedQuery(name = "Entrance.findByRegCode", query = "SELECT e FROM Entrance e WHERE e.regCode = :regCode"),
    @NamedQuery(name = "Entrance.findByComplete", query = "SELECT e FROM Entrance e WHERE e.complete = :complete"),
    @NamedQuery(name = "Entrance.findByCode", query = "SELECT e FROM Entrance e WHERE e.code = :code"),
    @NamedQuery(name = "Entrance.findByPilotid", query = "SELECT e FROM Entrance e WHERE e.pilotid = :pilotid")})
public class Entrance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "applicant_id")
    private Integer applicantId;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "times_taken")
    private int timesTaken;
    @Basic(optional = false)
    @Column(name = "passed")
    private int passed;
    @Basic(optional = false)
    @Column(name = "last_test")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastTest;
    @Basic(optional = false)
    @Column(name = "joindate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date joindate;
    @Column(name = "lastip")
    private String lastip;
    @Basic(optional = false)
    @Column(name = "reg_code")
    private int regCode;
    @Basic(optional = false)
    @Column(name = "complete")
    private int complete;
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Column(name = "pilotid")
    private int pilotid;

    public Entrance() {
    }

    public Entrance(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public Entrance(Integer applicantId, String firstname, String lastname, String email, int timesTaken, int passed, Date lastTest, Date joindate, int regCode, int complete, String code, int pilotid) {
        this.applicantId = applicantId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.timesTaken = timesTaken;
        this.passed = passed;
        this.lastTest = lastTest;
        this.joindate = joindate;
        this.regCode = regCode;
        this.complete = complete;
        this.code = code;
        this.pilotid = pilotid;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTimesTaken() {
        return timesTaken;
    }

    public void setTimesTaken(int timesTaken) {
        this.timesTaken = timesTaken;
    }

    public int getPassed() {
        return passed;
    }

    public void setPassed(int passed) {
        this.passed = passed;
    }

    public Date getLastTest() {
        return lastTest;
    }

    public void setLastTest(Date lastTest) {
        this.lastTest = lastTest;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public String getLastip() {
        return lastip;
    }

    public void setLastip(String lastip) {
        this.lastip = lastip;
    }

    public int getRegCode() {
        return regCode;
    }

    public void setRegCode(int regCode) {
        this.regCode = regCode;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPilotid() {
        return pilotid;
    }

    public void setPilotid(int pilotid) {
        this.pilotid = pilotid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (applicantId != null ? applicantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrance)) {
            return false;
        }
        Entrance other = (Entrance) object;
        if ((this.applicantId == null && other.applicantId != null) || (this.applicantId != null && !this.applicantId.equals(other.applicantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Entrance[ applicantId=" + applicantId + " ]";
    }
    
}
