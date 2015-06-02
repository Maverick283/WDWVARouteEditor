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
import javax.persistence.Lob;
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
@Table(name = "kacars_pmlog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KacarsPmlog.findAll", query = "SELECT k FROM KacarsPmlog k"),
    @NamedQuery(name = "KacarsPmlog.findById", query = "SELECT k FROM KacarsPmlog k WHERE k.id = :id"),
    @NamedQuery(name = "KacarsPmlog.findByFrom", query = "SELECT k FROM KacarsPmlog k WHERE k.from = :from"),
    @NamedQuery(name = "KacarsPmlog.findByTo", query = "SELECT k FROM KacarsPmlog k WHERE k.to = :to"),
    @NamedQuery(name = "KacarsPmlog.findByHide", query = "SELECT k FROM KacarsPmlog k WHERE k.hide = :hide"),
    @NamedQuery(name = "KacarsPmlog.findByAlert", query = "SELECT k FROM KacarsPmlog k WHERE k.alert = :alert"),
    @NamedQuery(name = "KacarsPmlog.findByTimestamp", query = "SELECT k FROM KacarsPmlog k WHERE k.timestamp = :timestamp")})
public class KacarsPmlog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "from")
    private Integer from;
    @Column(name = "to")
    private Integer to;
    @Lob
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "msg")
    private String msg;
    @Basic(optional = false)
    @Column(name = "hide")
    private int hide;
    @Basic(optional = false)
    @Column(name = "alert")
    private int alert;
    @Basic(optional = false)
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    public KacarsPmlog() {
    }

    public KacarsPmlog(Integer id) {
        this.id = id;
    }

    public KacarsPmlog(Integer id, int hide, int alert, Date timestamp) {
        this.id = id;
        this.hide = hide;
        this.alert = alert;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getHide() {
        return hide;
    }

    public void setHide(int hide) {
        this.hide = hide;
    }

    public int getAlert() {
        return alert;
    }

    public void setAlert(int alert) {
        this.alert = alert;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
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
        if (!(object instanceof KacarsPmlog)) {
            return false;
        }
        KacarsPmlog other = (KacarsPmlog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.KacarsPmlog[ id=" + id + " ]";
    }
    
}
