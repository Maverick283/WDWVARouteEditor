/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Patrick
 */
@Entity
@Table(name = "groups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Groups g"),
    @NamedQuery(name = "Groups.findByGroupid", query = "SELECT g FROM Groups g WHERE g.groupid = :groupid"),
    @NamedQuery(name = "Groups.findByName", query = "SELECT g FROM Groups g WHERE g.name = :name"),
    @NamedQuery(name = "Groups.findByPermissions", query = "SELECT g FROM Groups g WHERE g.permissions = :permissions")})
public class Groups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "groupid")
    private Integer groupid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "permissions")
    private String permissions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupid")
    private Collection<Groupmembers> groupmembersCollection;

    public Groups() {
    }

    public Groups(Integer groupid) {
        this.groupid = groupid;
    }

    public Groups(Integer groupid, String name, String permissions) {
        this.groupid = groupid;
        this.name = name;
        this.permissions = permissions;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    @XmlTransient
    public Collection<Groupmembers> getGroupmembersCollection() {
        return groupmembersCollection;
    }

    public void setGroupmembersCollection(Collection<Groupmembers> groupmembersCollection) {
        this.groupmembersCollection = groupmembersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupid != null ? groupid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groups)) {
            return false;
        }
        Groups other = (Groups) object;
        if ((this.groupid == null && other.groupid != null) || (this.groupid != null && !this.groupid.equals(other.groupid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Groups[ groupid=" + groupid + " ]";
    }
    
}
