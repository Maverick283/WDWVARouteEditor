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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "pirepcomments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pirepcomments.findAll", query = "SELECT p FROM Pirepcomments p"),
    @NamedQuery(name = "Pirepcomments.findById", query = "SELECT p FROM Pirepcomments p WHERE p.id = :id"),
    @NamedQuery(name = "Pirepcomments.findByPilotid", query = "SELECT p FROM Pirepcomments p WHERE p.pilotid = :pilotid"),
    @NamedQuery(name = "Pirepcomments.findByPostdate", query = "SELECT p FROM Pirepcomments p WHERE p.postdate = :postdate")})
public class Pirepcomments implements Serializable {
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
    @Lob
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @Column(name = "postdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postdate;
    @JoinColumn(name = "pirepid", referencedColumnName = "pirepid")
    @ManyToOne(optional = false)
    private Pireps pirepid;

    public Pirepcomments() {
    }

    public Pirepcomments(Integer id) {
        this.id = id;
    }

    public Pirepcomments(Integer id, int pilotid, String comment, Date postdate) {
        this.id = id;
        this.pilotid = pilotid;
        this.comment = comment;
        this.postdate = postdate;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }

    public Pireps getPirepid() {
        return pirepid;
    }

    public void setPirepid(Pireps pirepid) {
        this.pirepid = pirepid;
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
        if (!(object instanceof Pirepcomments)) {
            return false;
        }
        Pirepcomments other = (Pirepcomments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Pirepcomments[ id=" + id + " ]";
    }
    
}
