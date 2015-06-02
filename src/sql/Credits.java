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
@Table(name = "credits")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credits.findAll", query = "SELECT c FROM Credits c"),
    @NamedQuery(name = "Credits.findById", query = "SELECT c FROM Credits c WHERE c.id = :id"),
    @NamedQuery(name = "Credits.findByName", query = "SELECT c FROM Credits c WHERE c.name = :name"),
    @NamedQuery(name = "Credits.findByImage", query = "SELECT c FROM Credits c WHERE c.image = :image"),
    @NamedQuery(name = "Credits.findByLink", query = "SELECT c FROM Credits c WHERE c.link = :link"),
    @NamedQuery(name = "Credits.findByActive", query = "SELECT c FROM Credits c WHERE c.active = :active")})
public class Credits implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @Column(name = "link")
    private String link;
    @Basic(optional = false)
    @Column(name = "active")
    private int active;

    public Credits() {
    }

    public Credits(Integer id) {
        this.id = id;
    }

    public Credits(Integer id, String name, String description, String image, String link, int active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.link = link;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
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
        if (!(object instanceof Credits)) {
            return false;
        }
        Credits other = (Credits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Credits[ id=" + id + " ]";
    }
    
}
