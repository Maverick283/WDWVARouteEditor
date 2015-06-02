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
@Table(name = "pages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pages.findAll", query = "SELECT p FROM Pages p"),
    @NamedQuery(name = "Pages.findByPageid", query = "SELECT p FROM Pages p WHERE p.pageid = :pageid"),
    @NamedQuery(name = "Pages.findByPagename", query = "SELECT p FROM Pages p WHERE p.pagename = :pagename"),
    @NamedQuery(name = "Pages.findByFilename", query = "SELECT p FROM Pages p WHERE p.filename = :filename"),
    @NamedQuery(name = "Pages.findByOrder", query = "SELECT p FROM Pages p WHERE p.order = :order"),
    @NamedQuery(name = "Pages.findByPostedby", query = "SELECT p FROM Pages p WHERE p.postedby = :postedby"),
    @NamedQuery(name = "Pages.findByPostdate", query = "SELECT p FROM Pages p WHERE p.postdate = :postdate"),
    @NamedQuery(name = "Pages.findByPublic1", query = "SELECT p FROM Pages p WHERE p.public1 = :public1"),
    @NamedQuery(name = "Pages.findByEnabled", query = "SELECT p FROM Pages p WHERE p.enabled = :enabled")})
public class Pages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pageid")
    private Integer pageid;
    @Basic(optional = false)
    @Column(name = "pagename")
    private String pagename;
    @Basic(optional = false)
    @Column(name = "filename")
    private String filename;
    @Basic(optional = false)
    @Column(name = "order")
    private short order;
    @Basic(optional = false)
    @Column(name = "postedby")
    private String postedby;
    @Basic(optional = false)
    @Column(name = "postdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postdate;
    @Basic(optional = false)
    @Column(name = "public")
    private short public1;
    @Basic(optional = false)
    @Column(name = "enabled")
    private short enabled;

    public Pages() {
    }

    public Pages(Integer pageid) {
        this.pageid = pageid;
    }

    public Pages(Integer pageid, String pagename, String filename, short order, String postedby, Date postdate, short public1, short enabled) {
        this.pageid = pageid;
        this.pagename = pagename;
        this.filename = filename;
        this.order = order;
        this.postedby = postedby;
        this.postdate = postdate;
        this.public1 = public1;
        this.enabled = enabled;
    }

    public Integer getPageid() {
        return pageid;
    }

    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    public String getPagename() {
        return pagename;
    }

    public void setPagename(String pagename) {
        this.pagename = pagename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public short getOrder() {
        return order;
    }

    public void setOrder(short order) {
        this.order = order;
    }

    public String getPostedby() {
        return postedby;
    }

    public void setPostedby(String postedby) {
        this.postedby = postedby;
    }

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }

    public short getPublic1() {
        return public1;
    }

    public void setPublic1(short public1) {
        this.public1 = public1;
    }

    public short getEnabled() {
        return enabled;
    }

    public void setEnabled(short enabled) {
        this.enabled = enabled;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pageid != null ? pageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pages)) {
            return false;
        }
        Pages other = (Pages) object;
        if ((this.pageid == null && other.pageid != null) || (this.pageid != null && !this.pageid.equals(other.pageid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Pages[ pageid=" + pageid + " ]";
    }
    
}
