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
@Table(name = "sessions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sessions.findAll", query = "SELECT s FROM Sessions s"),
    @NamedQuery(name = "Sessions.findById", query = "SELECT s FROM Sessions s WHERE s.id = :id"),
    @NamedQuery(name = "Sessions.findByPilotid", query = "SELECT s FROM Sessions s WHERE s.pilotid = :pilotid"),
    @NamedQuery(name = "Sessions.findByIpaddress", query = "SELECT s FROM Sessions s WHERE s.ipaddress = :ipaddress"),
    @NamedQuery(name = "Sessions.findByLogintime", query = "SELECT s FROM Sessions s WHERE s.logintime = :logintime")})
public class Sessions implements Serializable {
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
    @Column(name = "ipaddress")
    private String ipaddress;
    @Basic(optional = false)
    @Column(name = "logintime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logintime;

    public Sessions() {
    }

    public Sessions(Integer id) {
        this.id = id;
    }

    public Sessions(Integer id, int pilotid, String ipaddress, Date logintime) {
        this.id = id;
        this.pilotid = pilotid;
        this.ipaddress = ipaddress;
        this.logintime = logintime;
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

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
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
        if (!(object instanceof Sessions)) {
            return false;
        }
        Sessions other = (Sessions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Sessions[ id=" + id + " ]";
    }
    
}
