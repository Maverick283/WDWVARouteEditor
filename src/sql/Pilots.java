/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import sql.Groupmembers;
import sql.Fieldvalues;
import sql.Airlines;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Patrick
 */
@Entity
@Table(name = "pilots")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pilots.findAll", query = "SELECT p FROM Pilots p"),
    @NamedQuery(name = "Pilots.findByPilotid", query = "SELECT p FROM Pilots p WHERE p.pilotid = :pilotid"),
    @NamedQuery(name = "Pilots.findByFirstname", query = "SELECT p FROM Pilots p WHERE p.firstname = :firstname"),
    @NamedQuery(name = "Pilots.findByLastname", query = "SELECT p FROM Pilots p WHERE p.lastname = :lastname"),
    @NamedQuery(name = "Pilots.findByEmail", query = "SELECT p FROM Pilots p WHERE p.email = :email"),
    @NamedQuery(name = "Pilots.findByLocation", query = "SELECT p FROM Pilots p WHERE p.location = :location"),
    @NamedQuery(name = "Pilots.findByHub", query = "SELECT p FROM Pilots p WHERE p.hub = :hub"),
    @NamedQuery(name = "Pilots.findByPassword", query = "SELECT p FROM Pilots p WHERE p.password = :password"),
    @NamedQuery(name = "Pilots.findBySalt", query = "SELECT p FROM Pilots p WHERE p.salt = :salt"),
    @NamedQuery(name = "Pilots.findByBgimage", query = "SELECT p FROM Pilots p WHERE p.bgimage = :bgimage"),
    @NamedQuery(name = "Pilots.findByLastlogin", query = "SELECT p FROM Pilots p WHERE p.lastlogin = :lastlogin"),
    @NamedQuery(name = "Pilots.findByTotalflights", query = "SELECT p FROM Pilots p WHERE p.totalflights = :totalflights"),
    @NamedQuery(name = "Pilots.findByTotalhours", query = "SELECT p FROM Pilots p WHERE p.totalhours = :totalhours"),
    @NamedQuery(name = "Pilots.findByTotalpay", query = "SELECT p FROM Pilots p WHERE p.totalpay = :totalpay"),
    @NamedQuery(name = "Pilots.findByTransferhours", query = "SELECT p FROM Pilots p WHERE p.transferhours = :transferhours"),
    @NamedQuery(name = "Pilots.findByRankid", query = "SELECT p FROM Pilots p WHERE p.rankid = :rankid"),
    @NamedQuery(name = "Pilots.findByRank", query = "SELECT p FROM Pilots p WHERE p.rank = :rank"),
    @NamedQuery(name = "Pilots.findByRanklevel", query = "SELECT p FROM Pilots p WHERE p.ranklevel = :ranklevel"),
    @NamedQuery(name = "Pilots.findByConfirmed", query = "SELECT p FROM Pilots p WHERE p.confirmed = :confirmed"),
    @NamedQuery(name = "Pilots.findByRetired", query = "SELECT p FROM Pilots p WHERE p.retired = :retired"),
    @NamedQuery(name = "Pilots.findByJoindate", query = "SELECT p FROM Pilots p WHERE p.joindate = :joindate"),
    @NamedQuery(name = "Pilots.findByLastpirep", query = "SELECT p FROM Pilots p WHERE p.lastpirep = :lastpirep"),
    @NamedQuery(name = "Pilots.findByLastip", query = "SELECT p FROM Pilots p WHERE p.lastip = :lastip")})
public class Pilots implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pilotid")
    private Integer pilotid;
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
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @Column(name = "hub")
    private String hub;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "salt")
    private String salt;
    @Basic(optional = false)
    @Column(name = "bgimage")
    private String bgimage;
    @Basic(optional = false)
    @Column(name = "lastlogin")
    @Temporal(TemporalType.DATE)
    private Date lastlogin;
    @Basic(optional = false)
    @Column(name = "totalflights")
    private int totalflights;
    @Basic(optional = false)
    @Column(name = "totalhours")
    private float totalhours;
    @Basic(optional = false)
    @Column(name = "totalpay")
    private float totalpay;
    @Basic(optional = false)
    @Column(name = "transferhours")
    private float transferhours;
    @Basic(optional = false)
    @Column(name = "rankid")
    private int rankid;
    @Basic(optional = false)
    @Column(name = "rank")
    private String rank;
    @Basic(optional = false)
    @Column(name = "ranklevel")
    private int ranklevel;
    @Basic(optional = false)
    @Column(name = "confirmed")
    private short confirmed;
    @Basic(optional = false)
    @Column(name = "retired")
    private short retired;
    @Basic(optional = false)
    @Column(name = "joindate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date joindate;
    @Basic(optional = false)
    @Column(name = "lastpirep")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastpirep;
    @Column(name = "lastip")
    private String lastip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pilotid")
    private Collection<Fieldvalues> fieldvaluesCollection;
    @JoinColumn(name = "code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Airlines code;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pilotid")
    private Collection<Groupmembers> groupmembersCollection;

    public Pilots() {
    }

    public Pilots(Integer pilotid) {
        this.pilotid = pilotid;
    }

    public Pilots(Integer pilotid, String firstname, String lastname, String email, String location, String hub, String password, String salt, String bgimage, Date lastlogin, int totalflights, float totalhours, float totalpay, float transferhours, int rankid, String rank, int ranklevel, short confirmed, short retired, Date joindate, Date lastpirep) {
        this.pilotid = pilotid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.location = location;
        this.hub = hub;
        this.password = password;
        this.salt = salt;
        this.bgimage = bgimage;
        this.lastlogin = lastlogin;
        this.totalflights = totalflights;
        this.totalhours = totalhours;
        this.totalpay = totalpay;
        this.transferhours = transferhours;
        this.rankid = rankid;
        this.rank = rank;
        this.ranklevel = ranklevel;
        this.confirmed = confirmed;
        this.retired = retired;
        this.joindate = joindate;
        this.lastpirep = lastpirep;
    }

    public Integer getPilotid() {
        return pilotid;
    }

    public void setPilotid(Integer pilotid) {
        this.pilotid = pilotid;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHub() {
        return hub;
    }

    public void setHub(String hub) {
        this.hub = hub;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getBgimage() {
        return bgimage;
    }

    public void setBgimage(String bgimage) {
        this.bgimage = bgimage;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public int getTotalflights() {
        return totalflights;
    }

    public void setTotalflights(int totalflights) {
        this.totalflights = totalflights;
    }

    public float getTotalhours() {
        return totalhours;
    }

    public void setTotalhours(float totalhours) {
        this.totalhours = totalhours;
    }

    public float getTotalpay() {
        return totalpay;
    }

    public void setTotalpay(float totalpay) {
        this.totalpay = totalpay;
    }

    public float getTransferhours() {
        return transferhours;
    }

    public void setTransferhours(float transferhours) {
        this.transferhours = transferhours;
    }

    public int getRankid() {
        return rankid;
    }

    public void setRankid(int rankid) {
        this.rankid = rankid;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getRanklevel() {
        return ranklevel;
    }

    public void setRanklevel(int ranklevel) {
        this.ranklevel = ranklevel;
    }

    public short getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(short confirmed) {
        this.confirmed = confirmed;
    }

    public short getRetired() {
        return retired;
    }

    public void setRetired(short retired) {
        this.retired = retired;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public Date getLastpirep() {
        return lastpirep;
    }

    public void setLastpirep(Date lastpirep) {
        this.lastpirep = lastpirep;
    }

    public String getLastip() {
        return lastip;
    }

    public void setLastip(String lastip) {
        this.lastip = lastip;
    }

    @XmlTransient
    public Collection<Fieldvalues> getFieldvaluesCollection() {
        return fieldvaluesCollection;
    }

    public void setFieldvaluesCollection(Collection<Fieldvalues> fieldvaluesCollection) {
        this.fieldvaluesCollection = fieldvaluesCollection;
    }

    public Airlines getCode() {
        return code;
    }

    public void setCode(Airlines code) {
        this.code = code;
    }

    @XmlTransient
    public Collection<Groupmembers> getGroupmembersCollection() {
        return groupmembersCollection;
    }

    public void setGroupmembersCollection(Collection<Groupmembers> groupmembersCollection) {
        this.groupmembersCollection = groupmembersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pilotid != null ? pilotid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pilots)) {
            return false;
        }
        Pilots other = (Pilots) object;
        if ((this.pilotid == null && other.pilotid != null) || (this.pilotid != null && !this.pilotid.equals(other.pilotid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Pilots[ pilotid=" + pilotid + " ]";
    }
    
}
