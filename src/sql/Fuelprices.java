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
@Table(name = "fuelprices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fuelprices.findAll", query = "SELECT f FROM Fuelprices f"),
    @NamedQuery(name = "Fuelprices.findById", query = "SELECT f FROM Fuelprices f WHERE f.id = :id"),
    @NamedQuery(name = "Fuelprices.findByIcao", query = "SELECT f FROM Fuelprices f WHERE f.icao = :icao"),
    @NamedQuery(name = "Fuelprices.findByLowlead", query = "SELECT f FROM Fuelprices f WHERE f.lowlead = :lowlead"),
    @NamedQuery(name = "Fuelprices.findByJeta", query = "SELECT f FROM Fuelprices f WHERE f.jeta = :jeta"),
    @NamedQuery(name = "Fuelprices.findByDateupdated", query = "SELECT f FROM Fuelprices f WHERE f.dateupdated = :dateupdated")})
public class Fuelprices implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "icao")
    private String icao;
    @Basic(optional = false)
    @Column(name = "lowlead")
    private float lowlead;
    @Basic(optional = false)
    @Column(name = "jeta")
    private float jeta;
    @Basic(optional = false)
    @Column(name = "dateupdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateupdated;

    public Fuelprices() {
    }

    public Fuelprices(Integer id) {
        this.id = id;
    }

    public Fuelprices(Integer id, String icao, float lowlead, float jeta, Date dateupdated) {
        this.id = id;
        this.icao = icao;
        this.lowlead = lowlead;
        this.jeta = jeta;
        this.dateupdated = dateupdated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public float getLowlead() {
        return lowlead;
    }

    public void setLowlead(float lowlead) {
        this.lowlead = lowlead;
    }

    public float getJeta() {
        return jeta;
    }

    public void setJeta(float jeta) {
        this.jeta = jeta;
    }

    public Date getDateupdated() {
        return dateupdated;
    }

    public void setDateupdated(Date dateupdated) {
        this.dateupdated = dateupdated;
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
        if (!(object instanceof Fuelprices)) {
            return false;
        }
        Fuelprices other = (Fuelprices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Fuelprices[ id=" + id + " ]";
    }
    
}
