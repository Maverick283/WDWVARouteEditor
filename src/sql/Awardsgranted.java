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
@Table(name = "awardsgranted")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Awardsgranted.findAll", query = "SELECT a FROM Awardsgranted a"),
    @NamedQuery(name = "Awardsgranted.findById", query = "SELECT a FROM Awardsgranted a WHERE a.id = :id"),
    @NamedQuery(name = "Awardsgranted.findByAwardid", query = "SELECT a FROM Awardsgranted a WHERE a.awardid = :awardid"),
    @NamedQuery(name = "Awardsgranted.findByPilotid", query = "SELECT a FROM Awardsgranted a WHERE a.pilotid = :pilotid"),
    @NamedQuery(name = "Awardsgranted.findByDateissued", query = "SELECT a FROM Awardsgranted a WHERE a.dateissued = :dateissued")})
public class Awardsgranted implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "awardid")
    private int awardid;
    @Basic(optional = false)
    @Column(name = "pilotid")
    private int pilotid;
    @Basic(optional = false)
    @Column(name = "dateissued")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateissued;

    public Awardsgranted() {
    }

    public Awardsgranted(Integer id) {
        this.id = id;
    }

    public Awardsgranted(Integer id, int awardid, int pilotid, Date dateissued) {
        this.id = id;
        this.awardid = awardid;
        this.pilotid = pilotid;
        this.dateissued = dateissued;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAwardid() {
        return awardid;
    }

    public void setAwardid(int awardid) {
        this.awardid = awardid;
    }

    public int getPilotid() {
        return pilotid;
    }

    public void setPilotid(int pilotid) {
        this.pilotid = pilotid;
    }

    public Date getDateissued() {
        return dateissued;
    }

    public void setDateissued(Date dateissued) {
        this.dateissued = dateissued;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Awardsgranted)) {
            return false;
        }
        Awardsgranted other = (Awardsgranted) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Awardsgranted[ id=" + id + " ]";
    }
    
}
