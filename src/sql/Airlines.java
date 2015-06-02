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
@Table(name = "airlines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Airlines.findAll", query = "SELECT a FROM Airlines a"),
    @NamedQuery(name = "Airlines.findById", query = "SELECT a FROM Airlines a WHERE a.id = :id"),
    @NamedQuery(name = "Airlines.findByCode", query = "SELECT a FROM Airlines a WHERE a.code = :code"),
    @NamedQuery(name = "Airlines.findByName", query = "SELECT a FROM Airlines a WHERE a.name = :name"),
    @NamedQuery(name = "Airlines.findByEnabled", query = "SELECT a FROM Airlines a WHERE a.enabled = :enabled")})
public class Airlines implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "enabled")
    private short enabled;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "code")
    private Collection<Pilots> pilotsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "code")
    private Collection<Schedules> schedulesCollection;

    public Airlines() {
    }

    public Airlines(Integer id) {
        this.id = id;
    }

    public Airlines(Integer id, String code, String name, short enabled) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.enabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getEnabled() {
        return enabled;
    }

    public void setEnabled(short enabled) {
        this.enabled = enabled;
    }

    @XmlTransient
    public Collection<Pilots> getPilotsCollection() {
        return pilotsCollection;
    }

    public void setPilotsCollection(Collection<Pilots> pilotsCollection) {
        this.pilotsCollection = pilotsCollection;
    }

    @XmlTransient
    public Collection<Schedules> getSchedulesCollection() {
        return schedulesCollection;
    }

    public void setSchedulesCollection(Collection<Schedules> schedulesCollection) {
        this.schedulesCollection = schedulesCollection;
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
        if (!(object instanceof Airlines)) {
            return false;
        }
        Airlines other = (Airlines) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Airlines[ id=" + id + " ]";
    }
    
}
