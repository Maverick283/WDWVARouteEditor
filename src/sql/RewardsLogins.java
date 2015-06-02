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
@Table(name = "rewards_logins")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RewardsLogins.findAll", query = "SELECT r FROM RewardsLogins r"),
    @NamedQuery(name = "RewardsLogins.findById", query = "SELECT r FROM RewardsLogins r WHERE r.id = :id"),
    @NamedQuery(name = "RewardsLogins.findByPilotId", query = "SELECT r FROM RewardsLogins r WHERE r.pilotId = :pilotId"),
    @NamedQuery(name = "RewardsLogins.findByLoginDate", query = "SELECT r FROM RewardsLogins r WHERE r.loginDate = :loginDate")})
public class RewardsLogins implements Serializable {
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
    @Column(name = "login_date")
    @Temporal(TemporalType.DATE)
    private Date loginDate;

    public RewardsLogins() {
    }

    public RewardsLogins(Integer id) {
        this.id = id;
    }

    public RewardsLogins(Integer id, int pilotId, Date loginDate) {
        this.id = id;
        this.pilotId = pilotId;
        this.loginDate = loginDate;
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

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
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
        if (!(object instanceof RewardsLogins)) {
            return false;
        }
        RewardsLogins other = (RewardsLogins) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.RewardsLogins[ id=" + id + " ]";
    }
    
}
