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
import javax.persistence.JoinColumn;
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
@Table(name = "groupmembers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groupmembers.findAll", query = "SELECT g FROM Groupmembers g"),
    @NamedQuery(name = "Groupmembers.findById", query = "SELECT g FROM Groupmembers g WHERE g.id = :id")})
public class Groupmembers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "groupid", referencedColumnName = "groupid")
    @ManyToOne(optional = false)
    private Groups groupid;
    @JoinColumn(name = "pilotid", referencedColumnName = "pilotid")
    @ManyToOne(optional = false)
    private Pilots pilotid;

    public Groupmembers() {
    }

    public Groupmembers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Groups getGroupid() {
        return groupid;
    }

    public void setGroupid(Groups groupid) {
        this.groupid = groupid;
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
        if (!(object instanceof Groupmembers)) {
            return false;
        }
        Groupmembers other = (Groupmembers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Groupmembers[ id=" + id + " ]";
    }
    
}
