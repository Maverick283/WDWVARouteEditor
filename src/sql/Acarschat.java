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
@Table(name = "acarschat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acarschat.findAll", query = "SELECT a FROM Acarschat a"),
    @NamedQuery(name = "Acarschat.findById", query = "SELECT a FROM Acarschat a WHERE a.id = :id"),
    @NamedQuery(name = "Acarschat.findByPilotid", query = "SELECT a FROM Acarschat a WHERE a.pilotid = :pilotid")})
public class Acarschat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "pilotid")
    private Integer pilotid;
    @Lob
    @Column(name = "message")
    private String message;
    @Lob
    @Column(name = "time")
    private String time;
    @Lob
    @Column(name = "timestamp")
    private String timestamp;

    public Acarschat() {
    }

    public Acarschat(Integer id) {
        this.id = id;
    }

    public Acarschat(Integer id, Integer pilotid, String message, String time, String timestamp) {
        this.id = id;
        this.pilotid = pilotid;
        this.message = message;
        this.time = time;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPilotid() {
        return pilotid;
    }

    public void setPilotid(Integer pilotid) {
        this.pilotid = pilotid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
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
        if (!(object instanceof Acarschat)) {
            return false;
        }
        Acarschat other = (Acarschat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Acarschat[ id=" + id + " ]";
    }
    
}
