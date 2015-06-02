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
@Table(name = "bids")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bids.findAll", query = "SELECT b FROM Bids b"),
    @NamedQuery(name = "Bids.findByBidid", query = "SELECT b FROM Bids b WHERE b.bidid = :bidid"),
    @NamedQuery(name = "Bids.findByPilotid", query = "SELECT b FROM Bids b WHERE b.pilotid = :pilotid"),
    @NamedQuery(name = "Bids.findByRouteid", query = "SELECT b FROM Bids b WHERE b.routeid = :routeid"),
    @NamedQuery(name = "Bids.findByDateadded", query = "SELECT b FROM Bids b WHERE b.dateadded = :dateadded")})
public class Bids implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bidid")
    private Integer bidid;
    @Basic(optional = false)
    @Column(name = "pilotid")
    private int pilotid;
    @Basic(optional = false)
    @Column(name = "routeid")
    private int routeid;
    @Basic(optional = false)
    @Column(name = "dateadded")
    @Temporal(TemporalType.DATE)
    private Date dateadded;

    public Bids() {
    }

    public Bids(Integer bidid) {
        this.bidid = bidid;
    }

    public Bids(Integer bidid, int pilotid, int routeid, Date dateadded) {
        this.bidid = bidid;
        this.pilotid = pilotid;
        this.routeid = routeid;
        this.dateadded = dateadded;
    }

    public Integer getBidid() {
        return bidid;
    }

    public void setBidid(Integer bidid) {
        this.bidid = bidid;
    }

    public int getPilotid() {
        return pilotid;
    }

    public void setPilotid(int pilotid) {
        this.pilotid = pilotid;
    }

    public int getRouteid() {
        return routeid;
    }

    public void setRouteid(int routeid) {
        this.routeid = routeid;
    }

    public Date getDateadded() {
        return dateadded;
    }

    public void setDateadded(Date dateadded) {
        this.dateadded = dateadded;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bidid != null ? bidid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bids)) {
            return false;
        }
        Bids other = (Bids) object;
        if ((this.bidid == null && other.bidid != null) || (this.bidid != null && !this.bidid.equals(other.bidid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Bids[ bidid=" + bidid + " ]";
    }
    
}
