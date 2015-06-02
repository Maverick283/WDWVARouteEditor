/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Patrick
 */
@Entity
@Table(name = "adminlog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adminlog.findAll", query = "SELECT a FROM Adminlog a"),
    @NamedQuery(name = "Adminlog.findById", query = "SELECT a FROM Adminlog a WHERE a.id = :id"),
    @NamedQuery(name = "Adminlog.findByPilotid", query = "SELECT a FROM Adminlog a WHERE a.pilotid = :pilotid"),
    @NamedQuery(name = "Adminlog.findByDatestamp", query = "SELECT a FROM Adminlog a WHERE a.datestamp = :datestamp"),
    @NamedQuery(name = "Adminlog.findByMessage", query = "SELECT a FROM Adminlog a WHERE a.message = :message")})
public class Adminlog implements Serializable {
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
    @Column(name = "datestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datestamp;
    @Basic(optional = false)
    @Column(name = "message")
    private String message;

    public Adminlog() {
    }

    public Adminlog(Integer id) {
        this.id = id;
    }

    public Adminlog(Integer id, int pilotid, Date datestamp, String message) {
        this.id = id;
        this.pilotid = pilotid;
        this.datestamp = datestamp;
        this.message = message;
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

    public Date getDatestamp() {
        return datestamp;
    }

    public void setDatestamp(Date datestamp) {
        this.datestamp = datestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        if (!(object instanceof Adminlog)) {
            return false;
        }
        Adminlog other = (Adminlog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Adminlog[ id=" + id + " ]";
    }
    
}
