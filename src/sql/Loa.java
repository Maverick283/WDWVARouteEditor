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
@Table(name = "loa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loa.findAll", query = "SELECT l FROM Loa l"),
    @NamedQuery(name = "Loa.findById", query = "SELECT l FROM Loa l WHERE l.id = :id"),
    @NamedQuery(name = "Loa.findByPilotid", query = "SELECT l FROM Loa l WHERE l.pilotid = :pilotid"),
    @NamedQuery(name = "Loa.findByStart", query = "SELECT l FROM Loa l WHERE l.start = :start"),
    @NamedQuery(name = "Loa.findByEnd", query = "SELECT l FROM Loa l WHERE l.end = :end")})
public class Loa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "pilotid")
    private int pilotid;
    @Basic(optional = false)
    @Column(name = "start")
    private String start;
    @Basic(optional = false)
    @Column(name = "end")
    private String end;
    @Basic(optional = false)
    @Lob
    @Column(name = "reason")
    private String reason;

    public Loa() {
    }

    public Loa(Integer id) {
        this.id = id;
    }

    public Loa(Integer id, int pilotid, String start, String end, String reason) {
        this.id = id;
        this.pilotid = pilotid;
        this.start = start;
        this.end = end;
        this.reason = reason;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPilotid() {
        return pilotid;
    }

    public void setPilotid(int pilotid) {
        this.pilotid = pilotid;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
        if (!(object instanceof Loa)) {
            return false;
        }
        Loa other = (Loa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Loa[ id=" + id + " ]";
    }
    
}
