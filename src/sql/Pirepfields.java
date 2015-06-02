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
@Table(name = "pirepfields")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pirepfields.findAll", query = "SELECT p FROM Pirepfields p"),
    @NamedQuery(name = "Pirepfields.findByFieldid", query = "SELECT p FROM Pirepfields p WHERE p.fieldid = :fieldid"),
    @NamedQuery(name = "Pirepfields.findByTitle", query = "SELECT p FROM Pirepfields p WHERE p.title = :title"),
    @NamedQuery(name = "Pirepfields.findByName", query = "SELECT p FROM Pirepfields p WHERE p.name = :name"),
    @NamedQuery(name = "Pirepfields.findByType", query = "SELECT p FROM Pirepfields p WHERE p.type = :type")})
public class Pirepfields implements Serializable {
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
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Lob
    @Column(name = "options")
    private String options;

    public Pirepfields() {
    }

    public Pirepfields(Integer fieldid) {
        this.fieldid = fieldid;
    }

    public Pirepfields(Integer fieldid, String title, String name, String type, String options) {
        this.fieldid = fieldid;
        this.title = title;
        this.name = name;
        this.type = type;
        this.options = options;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
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
        if (!(object instanceof Pirepfields)) {
            return false;
        }
        Pirepfields other = (Pirepfields) object;
        if ((this.fieldid == null && other.fieldid != null) || (this.fieldid != null && !this.fieldid.equals(other.fieldid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Pirepfields[ fieldid=" + fieldid + " ]";
    }
    
}
