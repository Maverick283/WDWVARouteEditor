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
@Table(name = "rewards_store_item_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RewardsStoreItemTypes.findAll", query = "SELECT r FROM RewardsStoreItemTypes r"),
    @NamedQuery(name = "RewardsStoreItemTypes.findById", query = "SELECT r FROM RewardsStoreItemTypes r WHERE r.id = :id"),
    @NamedQuery(name = "RewardsStoreItemTypes.findByType", query = "SELECT r FROM RewardsStoreItemTypes r WHERE r.type = :type"),
    @NamedQuery(name = "RewardsStoreItemTypes.findByEditable", query = "SELECT r FROM RewardsStoreItemTypes r WHERE r.editable = :editable")})
public class RewardsStoreItemTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "editable")
    private int editable;

    public RewardsStoreItemTypes() {
    }

    public RewardsStoreItemTypes(Integer id) {
        this.id = id;
    }

    public RewardsStoreItemTypes(Integer id, String type, int editable) {
        this.id = id;
        this.type = type;
        this.editable = editable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEditable() {
        return editable;
    }

    public void setEditable(int editable) {
        this.editable = editable;
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
        if (!(object instanceof RewardsStoreItemTypes)) {
            return false;
        }
        RewardsStoreItemTypes other = (RewardsStoreItemTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.RewardsStoreItemTypes[ id=" + id + " ]";
    }
    
}
