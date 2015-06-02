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
@Table(name = "rewards_store_items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RewardsStoreItems.findAll", query = "SELECT r FROM RewardsStoreItems r"),
    @NamedQuery(name = "RewardsStoreItems.findById", query = "SELECT r FROM RewardsStoreItems r WHERE r.id = :id"),
    @NamedQuery(name = "RewardsStoreItems.findByItemName", query = "SELECT r FROM RewardsStoreItems r WHERE r.itemName = :itemName"),
    @NamedQuery(name = "RewardsStoreItems.findByItemUrl", query = "SELECT r FROM RewardsStoreItems r WHERE r.itemUrl = :itemUrl"),
    @NamedQuery(name = "RewardsStoreItems.findByItemImage", query = "SELECT r FROM RewardsStoreItems r WHERE r.itemImage = :itemImage"),
    @NamedQuery(name = "RewardsStoreItems.findByPointCost", query = "SELECT r FROM RewardsStoreItems r WHERE r.pointCost = :pointCost"),
    @NamedQuery(name = "RewardsStoreItems.findByItemType", query = "SELECT r FROM RewardsStoreItems r WHERE r.itemType = :itemType"),
    @NamedQuery(name = "RewardsStoreItems.findByItemCategory", query = "SELECT r FROM RewardsStoreItems r WHERE r.itemCategory = :itemCategory"),
    @NamedQuery(name = "RewardsStoreItems.findByPurchases", query = "SELECT r FROM RewardsStoreItems r WHERE r.purchases = :purchases")})
public class RewardsStoreItems implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "item_name")
    private String itemName;
    @Basic(optional = false)
    @Lob
    @Column(name = "item_descrip")
    private String itemDescrip;
    @Basic(optional = false)
    @Column(name = "item_url")
    private String itemUrl;
    @Basic(optional = false)
    @Column(name = "item_image")
    private String itemImage;
    @Basic(optional = false)
    @Column(name = "point_cost")
    private int pointCost;
    @Basic(optional = false)
    @Column(name = "item_type")
    private int itemType;
    @Basic(optional = false)
    @Column(name = "item_category")
    private int itemCategory;
    @Basic(optional = false)
    @Column(name = "purchases")
    private int purchases;

    public RewardsStoreItems() {
    }

    public RewardsStoreItems(Integer id) {
        this.id = id;
    }

    public RewardsStoreItems(Integer id, String itemName, String itemDescrip, String itemUrl, String itemImage, int pointCost, int itemType, int itemCategory, int purchases) {
        this.id = id;
        this.itemName = itemName;
        this.itemDescrip = itemDescrip;
        this.itemUrl = itemUrl;
        this.itemImage = itemImage;
        this.pointCost = pointCost;
        this.itemType = itemType;
        this.itemCategory = itemCategory;
        this.purchases = purchases;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescrip() {
        return itemDescrip;
    }

    public void setItemDescrip(String itemDescrip) {
        this.itemDescrip = itemDescrip;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public int getPointCost() {
        return pointCost;
    }

    public void setPointCost(int pointCost) {
        this.pointCost = pointCost;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public int getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(int itemCategory) {
        this.itemCategory = itemCategory;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
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
        if (!(object instanceof RewardsStoreItems)) {
            return false;
        }
        RewardsStoreItems other = (RewardsStoreItems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.RewardsStoreItems[ id=" + id + " ]";
    }
    
}
