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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Patrick
 */
@Entity
@Table(name = "rewards_records")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RewardsRecords.findAll", query = "SELECT r FROM RewardsRecords r"),
    @NamedQuery(name = "RewardsRecords.findById", query = "SELECT r FROM RewardsRecords r WHERE r.id = :id"),
    @NamedQuery(name = "RewardsRecords.findByPilotId", query = "SELECT r FROM RewardsRecords r WHERE r.pilotId = :pilotId"),
    @NamedQuery(name = "RewardsRecords.findByPoint", query = "SELECT r FROM RewardsRecords r WHERE r.point = :point"),
    @NamedQuery(name = "RewardsRecords.findByDate", query = "SELECT r FROM RewardsRecords r WHERE r.date = :date"),
    @NamedQuery(name = "RewardsRecords.findByItem", query = "SELECT r FROM RewardsRecords r WHERE r.item = :item")})
public class RewardsRecords implements Serializable {
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
    @Column(name = "point")
    private int point;
    @Basic(optional = false)
    @Lob
    @Column(name = "note")
    private String note;
    @Basic(optional = false)
    @Column(name = "date")
    private int date;
    @Basic(optional = false)
    @Column(name = "item")
    private int item;

    public RewardsRecords() {
    }

    public RewardsRecords(Integer id) {
        this.id = id;
    }

    public RewardsRecords(Integer id, int pilotId, int point, String note, int date, int item) {
        this.id = id;
        this.pilotId = pilotId;
        this.point = point;
        this.note = note;
        this.date = date;
        this.item = item;
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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
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
        if (!(object instanceof RewardsRecords)) {
            return false;
        }
        RewardsRecords other = (RewardsRecords) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.RewardsRecords[ id=" + id + " ]";
    }
    
}
