/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Patrick
 */
@Entity
@Table(name = "screenshots_ratings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScreenshotsRatings.findAll", query = "SELECT s FROM ScreenshotsRatings s"),
    @NamedQuery(name = "ScreenshotsRatings.findById", query = "SELECT s FROM ScreenshotsRatings s WHERE s.id = :id"),
    @NamedQuery(name = "ScreenshotsRatings.findBySsId", query = "SELECT s FROM ScreenshotsRatings s WHERE s.ssId = :ssId"),
    @NamedQuery(name = "ScreenshotsRatings.findByPilotId", query = "SELECT s FROM ScreenshotsRatings s WHERE s.pilotId = :pilotId")})
public class ScreenshotsRatings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ss_id")
    private int ssId;
    @Basic(optional = false)
    @Column(name = "pilot_id")
    private int pilotId;

    public ScreenshotsRatings() {
    }

    public ScreenshotsRatings(Integer id) {
        this.id = id;
    }

    public ScreenshotsRatings(Integer id, int ssId, int pilotId) {
        this.id = id;
        this.ssId = ssId;
        this.pilotId = pilotId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSsId() {
        return ssId;
    }

    public void setSsId(int ssId) {
        this.ssId = ssId;
    }

    public int getPilotId() {
        return pilotId;
    }

    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
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
        if (!(object instanceof ScreenshotsRatings)) {
            return false;
        }
        ScreenshotsRatings other = (ScreenshotsRatings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.ScreenshotsRatings[ id=" + id + " ]";
    }
    
}
