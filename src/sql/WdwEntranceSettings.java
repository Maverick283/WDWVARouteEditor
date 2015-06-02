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
@Table(name = "wdw_entrance_settings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WdwEntranceSettings.findAll", query = "SELECT w FROM WdwEntranceSettings w"),
    @NamedQuery(name = "WdwEntranceSettings.findById", query = "SELECT w FROM WdwEntranceSettings w WHERE w.id = :id"),
    @NamedQuery(name = "WdwEntranceSettings.findByFriendlyname", query = "SELECT w FROM WdwEntranceSettings w WHERE w.friendlyname = :friendlyname"),
    @NamedQuery(name = "WdwEntranceSettings.findByName", query = "SELECT w FROM WdwEntranceSettings w WHERE w.name = :name"),
    @NamedQuery(name = "WdwEntranceSettings.findByValue", query = "SELECT w FROM WdwEntranceSettings w WHERE w.value = :value"),
    @NamedQuery(name = "WdwEntranceSettings.findByDescrip", query = "SELECT w FROM WdwEntranceSettings w WHERE w.descrip = :descrip"),
    @NamedQuery(name = "WdwEntranceSettings.findByType", query = "SELECT w FROM WdwEntranceSettings w WHERE w.type = :type")})
public class WdwEntranceSettings implements Serializable {
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
    @Column(name = "type")
    private int type;

    public WdwEntranceSettings() {
    }

    public WdwEntranceSettings(Integer id) {
        this.id = id;
    }

    public WdwEntranceSettings(Integer id, String friendlyname, String name, String value, String descrip, int type) {
        this.id = id;
        this.friendlyname = friendlyname;
        this.name = name;
        this.value = value;
        this.descrip = descrip;
        this.type = type;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
        if (!(object instanceof WdwEntranceSettings)) {
            return false;
        }
        WdwEntranceSettings other = (WdwEntranceSettings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.WdwEntranceSettings[ id=" + id + " ]";
    }
    
}
