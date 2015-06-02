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
@Table(name = "pirepvalues")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pirepvalues.findAll", query = "SELECT p FROM Pirepvalues p"),
    @NamedQuery(name = "Pirepvalues.findById", query = "SELECT p FROM Pirepvalues p WHERE p.id = :id"),
    @NamedQuery(name = "Pirepvalues.findByFieldid", query = "SELECT p FROM Pirepvalues p WHERE p.fieldid = :fieldid"),
    @NamedQuery(name = "Pirepvalues.findByPirepid", query = "SELECT p FROM Pirepvalues p WHERE p.pirepid = :pirepid")})
public class Pirepvalues implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fieldid")
    private int fieldid;
    @Basic(optional = false)
    @Column(name = "pirepid")
    private int pirepid;
    @Basic(optional = false)
    @Lob
    @Column(name = "value")
    private String value;

    public Pirepvalues() {
    }

    public Pirepvalues(Integer id) {
        this.id = id;
    }

    public Pirepvalues(Integer id, int fieldid, int pirepid, String value) {
        this.id = id;
        this.fieldid = fieldid;
        this.pirepid = pirepid;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFieldid() {
        return fieldid;
    }

    public void setFieldid(int fieldid) {
        this.fieldid = fieldid;
    }

    public int getPirepid() {
        return pirepid;
    }

    public void setPirepid(int pirepid) {
        this.pirepid = pirepid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
        if (!(object instanceof Pirepvalues)) {
            return false;
        }
        Pirepvalues other = (Pirepvalues) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Pirepvalues[ id=" + id + " ]";
    }
    
}
