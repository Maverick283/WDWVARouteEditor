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
@Table(name = "rewards_points")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RewardsPoints.findAll", query = "SELECT r FROM RewardsPoints r"),
    @NamedQuery(name = "RewardsPoints.findByPilotId", query = "SELECT r FROM RewardsPoints r WHERE r.pilotId = :pilotId"),
    @NamedQuery(name = "RewardsPoints.findByPoints", query = "SELECT r FROM RewardsPoints r WHERE r.points = :points"),
    @NamedQuery(name = "RewardsPoints.findByPointsLow", query = "SELECT r FROM RewardsPoints r WHERE r.pointsLow = :pointsLow"),
    @NamedQuery(name = "RewardsPoints.findByPointsHigh", query = "SELECT r FROM RewardsPoints r WHERE r.pointsHigh = :pointsHigh")})
public class RewardsPoints implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pilot_id")
    private Integer pilotId;
    @Basic(optional = false)
    @Column(name = "points")
    private int points;
    @Basic(optional = false)
    @Column(name = "points_low")
    private int pointsLow;
    @Basic(optional = false)
    @Column(name = "points_high")
    private int pointsHigh;

    public RewardsPoints() {
    }

    public RewardsPoints(Integer pilotId) {
        this.pilotId = pilotId;
    }

    public RewardsPoints(Integer pilotId, int points, int pointsLow, int pointsHigh) {
        this.pilotId = pilotId;
        this.points = points;
        this.pointsLow = pointsLow;
        this.pointsHigh = pointsHigh;
    }

    public Integer getPilotId() {
        return pilotId;
    }

    public void setPilotId(Integer pilotId) {
        this.pilotId = pilotId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPointsLow() {
        return pointsLow;
    }

    public void setPointsLow(int pointsLow) {
        this.pointsLow = pointsLow;
    }

    public int getPointsHigh() {
        return pointsHigh;
    }

    public void setPointsHigh(int pointsHigh) {
        this.pointsHigh = pointsHigh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pilotId != null ? pilotId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RewardsPoints)) {
            return false;
        }
        RewardsPoints other = (RewardsPoints) object;
        if ((this.pilotId == null && other.pilotId != null) || (this.pilotId != null && !this.pilotId.equals(other.pilotId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.RewardsPoints[ pilotId=" + pilotId + " ]";
    }
    
}
