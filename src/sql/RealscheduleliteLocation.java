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
@Table(name = "realschedulelite_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RealscheduleliteLocation.findAll", query = "SELECT r FROM RealscheduleliteLocation r"),
    @NamedQuery(name = "RealscheduleliteLocation.findById", query = "SELECT r FROM RealscheduleliteLocation r WHERE r.id = :id"),
    @NamedQuery(name = "RealscheduleliteLocation.findByPilotId", query = "SELECT r FROM RealscheduleliteLocation r WHERE r.pilotId = :pilotId"),
    @NamedQuery(name = "RealscheduleliteLocation.findByArricao", query = "SELECT r FROM RealscheduleliteLocation r WHERE r.arricao = :arricao"),
    @NamedQuery(name = "RealscheduleliteLocation.findByJumpseats", query = "SELECT r FROM RealscheduleliteLocation r WHERE r.jumpseats = :jumpseats"),
    @NamedQuery(name = "RealscheduleliteLocation.findByLastUpdate", query = "SELECT r FROM RealscheduleliteLocation r WHERE r.lastUpdate = :lastUpdate")})
public class RealscheduleliteLocation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "pilot_id")
    private int pilotId;
    @Basic(optional = false)
    @Column(name = "arricao")
    private String arricao;
    @Basic(optional = false)
    @Column(name = "jumpseats")
    private int jumpseats;
    @Basic(optional = false)
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    public RealscheduleliteLocation() {
    }

    public RealscheduleliteLocation(Integer id) {
        this.id = id;
    }

    public RealscheduleliteLocation(Integer id, int pilotId, String arricao, int jumpseats, Date lastUpdate) {
        this.id = id;
        this.pilotId = pilotId;
        this.arricao = arricao;
        this.jumpseats = jumpseats;
        this.lastUpdate = lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPilotId() {
        return pilotId;
    }

    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
    }

    public String getArricao() {
        return arricao;
    }

    public void setArricao(String arricao) {
        this.arricao = arricao;
    }

    public int getJumpseats() {
        return jumpseats;
    }

    public void setJumpseats(int jumpseats) {
        this.jumpseats = jumpseats;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
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
        if (!(object instanceof RealscheduleliteLocation)) {
            return false;
        }
        RealscheduleliteLocation other = (RealscheduleliteLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.RealscheduleliteLocation[ id=" + id + " ]";
    }
    
}
