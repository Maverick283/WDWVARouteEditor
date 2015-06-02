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
@Table(name = "rewards_purchases")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RewardsPurchases.findAll", query = "SELECT r FROM RewardsPurchases r"),
    @NamedQuery(name = "RewardsPurchases.findByPurchaseId", query = "SELECT r FROM RewardsPurchases r WHERE r.purchaseId = :purchaseId"),
    @NamedQuery(name = "RewardsPurchases.findByItemId", query = "SELECT r FROM RewardsPurchases r WHERE r.itemId = :itemId"),
    @NamedQuery(name = "RewardsPurchases.findByPointCost", query = "SELECT r FROM RewardsPurchases r WHERE r.pointCost = :pointCost"),
    @NamedQuery(name = "RewardsPurchases.findByPilotId", query = "SELECT r FROM RewardsPurchases r WHERE r.pilotId = :pilotId"),
    @NamedQuery(name = "RewardsPurchases.findByDate", query = "SELECT r FROM RewardsPurchases r WHERE r.date = :date")})
public class RewardsPurchases implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "purchase_id")
    private Integer purchaseId;
    @Basic(optional = false)
    @Column(name = "item_id")
    private int itemId;
    @Basic(optional = false)
    @Column(name = "point_cost")
    private int pointCost;
    @Basic(optional = false)
    @Column(name = "pilot_id")
    private int pilotId;
    @Basic(optional = false)
    @Column(name = "date")
    private int date;

    public RewardsPurchases() {
    }

    public RewardsPurchases(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public RewardsPurchases(Integer purchaseId, int itemId, int pointCost, int pilotId, int date) {
        this.purchaseId = purchaseId;
        this.itemId = itemId;
        this.pointCost = pointCost;
        this.pilotId = pilotId;
        this.date = date;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getPointCost() {
        return pointCost;
    }

    public void setPointCost(int pointCost) {
        this.pointCost = pointCost;
    }

    public int getPilotId() {
        return pilotId;
    }

    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseId != null ? purchaseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RewardsPurchases)) {
            return false;
        }
        RewardsPurchases other = (RewardsPurchases) object;
        if ((this.purchaseId == null && other.purchaseId != null) || (this.purchaseId != null && !this.purchaseId.equals(other.purchaseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.RewardsPurchases[ purchaseId=" + purchaseId + " ]";
    }
    
}
