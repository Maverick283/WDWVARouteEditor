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
import javax.persistence.Lob;
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
@Table(name = "customfields")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customfields.findAll", query = "SELECT c FROM Customfields c"),
    @NamedQuery(name = "Customfields.findByFieldid", query = "SELECT c FROM Customfields c WHERE c.fieldid = :fieldid"),
    @NamedQuery(name = "Customfields.findByTitle", query = "SELECT c FROM Customfields c WHERE c.title = :title"),
    @NamedQuery(name = "Customfields.findByFieldname", query = "SELECT c FROM Customfields c WHERE c.fieldname = :fieldname"),
    @NamedQuery(name = "Customfields.findByType", query = "SELECT c FROM Customfields c WHERE c.type = :type"),
    @NamedQuery(name = "Customfields.findByPublic1", query = "SELECT c FROM Customfields c WHERE c.public1 = :public1"),
    @NamedQuery(name = "Customfields.findByShowonregister", query = "SELECT c FROM Customfields c WHERE c.showonregister = :showonregister")})
public class Customfields implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fieldid")
    private Integer fieldid;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "fieldname")
    private String fieldname;
    @Basic(optional = false)
    @Lob
    @Column(name = "value")
    private String value;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "public")
    private short public1;
    @Basic(optional = false)
    @Column(name = "showonregister")
    private short showonregister;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fieldid")
    private Collection<Fieldvalues> fieldvaluesCollection;

    public Customfields() {
    }

    public Customfields(Integer fieldid) {
        this.fieldid = fieldid;
    }

    public Customfields(Integer fieldid, String title, String fieldname, String value, String type, short public1, short showonregister) {
        this.fieldid = fieldid;
        this.title = title;
        this.fieldname = fieldname;
        this.value = value;
        this.type = type;
        this.public1 = public1;
        this.showonregister = showonregister;
    }

    public Integer getFieldid() {
        return fieldid;
    }

    public void setFieldid(Integer fieldid) {
        this.fieldid = fieldid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public short getPublic1() {
        return public1;
    }

    public void setPublic1(short public1) {
        this.public1 = public1;
    }

    public short getShowonregister() {
        return showonregister;
    }

    public void setShowonregister(short showonregister) {
        this.showonregister = showonregister;
    }

    @XmlTransient
    public Collection<Fieldvalues> getFieldvaluesCollection() {
        return fieldvaluesCollection;
    }

    public void setFieldvaluesCollection(Collection<Fieldvalues> fieldvaluesCollection) {
        this.fieldvaluesCollection = fieldvaluesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fieldid != null ? fieldid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customfields)) {
            return false;
        }
        Customfields other = (Customfields) object;
        if ((this.fieldid == null && other.fieldid != null) || (this.fieldid != null && !this.fieldid.equals(other.fieldid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Customfields[ fieldid=" + fieldid + " ]";
    }
    
}
