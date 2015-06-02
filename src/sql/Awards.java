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
@Table(name = "awards")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Awards.findAll", query = "SELECT a FROM Awards a"),
    @NamedQuery(name = "Awards.findByAwardid", query = "SELECT a FROM Awards a WHERE a.awardid = :awardid"),
    @NamedQuery(name = "Awards.findByName", query = "SELECT a FROM Awards a WHERE a.name = :name"),
    @NamedQuery(name = "Awards.findByDescrip", query = "SELECT a FROM Awards a WHERE a.descrip = :descrip")})
public class Awards implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "awardid")
    private Integer awardid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "descrip")
    private String descrip;
    @Basic(optional = false)
    @Lob
    @Column(name = "image")
    private String image;

    public Awards() {
    }

    public Awards(Integer awardid) {
        this.awardid = awardid;
    }

    public Awards(Integer awardid, String name, String descrip, String image) {
        this.awardid = awardid;
        this.name = name;
        this.descrip = descrip;
        this.image = image;
    }

    public Integer getAwardid() {
        return awardid;
    }

    public void setAwardid(Integer awardid) {
        this.awardid = awardid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (awardid != null ? awardid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Awards)) {
            return false;
        }
        Awards other = (Awards) object;
        if ((this.awardid == null && other.awardid != null) || (this.awardid != null && !this.awardid.equals(other.awardid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Awards[ awardid=" + awardid + " ]";
    }
    
}
