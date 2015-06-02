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
@Table(name = "updates")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Updates.findAll", query = "SELECT u FROM Updates u"),
    @NamedQuery(name = "Updates.findById", query = "SELECT u FROM Updates u WHERE u.id = :id"),
    @NamedQuery(name = "Updates.findByName", query = "SELECT u FROM Updates u WHERE u.name = :name"),
    @NamedQuery(name = "Updates.findByLastupdate", query = "SELECT u FROM Updates u WHERE u.lastupdate = :lastupdate")})
public class Updates implements Serializable {
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
    @Column(name = "lastupdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastupdate;

    public Updates() {
    }

    public Updates(Integer id) {
        this.id = id;
    }

    public Updates(Integer id, String name, Date lastupdate) {
        this.id = id;
        this.name = name;
        this.lastupdate = lastupdate;
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

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
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
        if (!(object instanceof Updates)) {
            return false;
        }
        Updates other = (Updates) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Updates[ id=" + id + " ]";
    }
    
}
