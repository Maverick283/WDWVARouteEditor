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
@Table(name = "rewards_store_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RewardsStoreCategory.findAll", query = "SELECT r FROM RewardsStoreCategory r"),
    @NamedQuery(name = "RewardsStoreCategory.findById", query = "SELECT r FROM RewardsStoreCategory r WHERE r.id = :id"),
    @NamedQuery(name = "RewardsStoreCategory.findByName", query = "SELECT r FROM RewardsStoreCategory r WHERE r.name = :name"),
    @NamedQuery(name = "RewardsStoreCategory.findByOrderLevel", query = "SELECT r FROM RewardsStoreCategory r WHERE r.orderLevel = :orderLevel"),
    @NamedQuery(name = "RewardsStoreCategory.findByEnabled", query = "SELECT r FROM RewardsStoreCategory r WHERE r.enabled = :enabled")})
public class RewardsStoreCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "order_level")
    private int orderLevel;
    @Basic(optional = false)
    @Column(name = "enabled")
    private int enabled;

    public RewardsStoreCategory() {
    }

    public RewardsStoreCategory(Integer id) {
        this.id = id;
    }

    public RewardsStoreCategory(Integer id, String name, int orderLevel, int enabled) {
        this.id = id;
        this.name = name;
        this.orderLevel = orderLevel;
        this.enabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderLevel() {
        return orderLevel;
    }

    public void setOrderLevel(int orderLevel) {
        this.orderLevel = orderLevel;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
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
        if (!(object instanceof RewardsStoreCategory)) {
            return false;
        }
        RewardsStoreCategory other = (RewardsStoreCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.RewardsStoreCategory[ id=" + id + " ]";
    }
    
}
