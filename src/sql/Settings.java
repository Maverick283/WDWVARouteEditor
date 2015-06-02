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
@Table(name = "settings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Settings.findAll", query = "SELECT s FROM Settings s"),
    @NamedQuery(name = "Settings.findById", query = "SELECT s FROM Settings s WHERE s.id = :id"),
    @NamedQuery(name = "Settings.findByFriendlyname", query = "SELECT s FROM Settings s WHERE s.friendlyname = :friendlyname"),
    @NamedQuery(name = "Settings.findByName", query = "SELECT s FROM Settings s WHERE s.name = :name"),
    @NamedQuery(name = "Settings.findByValue", query = "SELECT s FROM Settings s WHERE s.value = :value"),
    @NamedQuery(name = "Settings.findByDescrip", query = "SELECT s FROM Settings s WHERE s.descrip = :descrip"),
    @NamedQuery(name = "Settings.findByCore", query = "SELECT s FROM Settings s WHERE s.core = :core")})
public class Settings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "friendlyname")
    private String friendlyname;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "value")
    private String value;
    @Basic(optional = false)
    @Column(name = "descrip")
    private String descrip;
    @Basic(optional = false)
    @Column(name = "core")
    private short core;

    public Settings() {
    }

    public Settings(Integer id) {
        this.id = id;
    }

    public Settings(Integer id, String friendlyname, String name, String value, String descrip, short core) {
        this.id = id;
        this.friendlyname = friendlyname;
        this.name = name;
        this.value = value;
        this.descrip = descrip;
        this.core = core;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFriendlyname() {
        return friendlyname;
    }

    public void setFriendlyname(String friendlyname) {
        this.friendlyname = friendlyname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public short getCore() {
        return core;
    }

    public void setCore(short core) {
        this.core = core;
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
        if (!(object instanceof Settings)) {
            return false;
        }
        Settings other = (Settings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Settings[ id=" + id + " ]";
    }
    
}
