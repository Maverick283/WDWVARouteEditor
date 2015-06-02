/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import sql.Customfields;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Patrick
 */
@Entity
@Table(name = "fieldvalues")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fieldvalues.findAll", query = "SELECT f FROM Fieldvalues f"),
    @NamedQuery(name = "Fieldvalues.findById", query = "SELECT f FROM Fieldvalues f WHERE f.id = :id")})
public class Fieldvalues implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "value")
    private String value;
    @JoinColumn(name = "fieldid", referencedColumnName = "fieldid")
    @ManyToOne(optional = false)
    private Customfields fieldid;
    @JoinColumn(name = "pilotid", referencedColumnName = "pilotid")
    @ManyToOne(optional = false)
    private Pilots pilotid;

    public Fieldvalues() {
    }

    public Fieldvalues(Integer id) {
        this.id = id;
    }

    public Fieldvalues(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Customfields getFieldid() {
        return fieldid;
    }

    public void setFieldid(Customfields fieldid) {
        this.fieldid = fieldid;
    }

    public Pilots getPilotid() {
        return pilotid;
    }

    public void setPilotid(Pilots pilotid) {
        this.pilotid = pilotid;
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
        if (!(object instanceof Fieldvalues)) {
            return false;
        }
        Fieldvalues other = (Fieldvalues) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Fieldvalues[ id=" + id + " ]";
    }
    
}
