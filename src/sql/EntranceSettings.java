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
@Table(name = "entrance_settings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntranceSettings.findAll", query = "SELECT e FROM EntranceSettings e"),
    @NamedQuery(name = "EntranceSettings.findById", query = "SELECT e FROM EntranceSettings e WHERE e.id = :id"),
    @NamedQuery(name = "EntranceSettings.findByFriendlyname", query = "SELECT e FROM EntranceSettings e WHERE e.friendlyname = :friendlyname"),
    @NamedQuery(name = "EntranceSettings.findByName", query = "SELECT e FROM EntranceSettings e WHERE e.name = :name"),
    @NamedQuery(name = "EntranceSettings.findByValue", query = "SELECT e FROM EntranceSettings e WHERE e.value = :value"),
    @NamedQuery(name = "EntranceSettings.findByDescrip", query = "SELECT e FROM EntranceSettings e WHERE e.descrip = :descrip"),
    @NamedQuery(name = "EntranceSettings.findByType", query = "SELECT e FROM EntranceSettings e WHERE e.type = :type")})
public class EntranceSettings implements Serializable {
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

    public EntranceSettings() {
    }

    public EntranceSettings(Integer id) {
        this.id = id;
    }

    public EntranceSettings(Integer id, String friendlyname, String name, String value, String descrip, int type) {
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
        if (!(object instanceof EntranceSettings)) {
            return false;
        }
        EntranceSettings other = (EntranceSettings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.EntranceSettings[ id=" + id + " ]";
    }
    
}
