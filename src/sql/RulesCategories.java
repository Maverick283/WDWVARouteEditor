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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Patrick
 */
@Entity
@Table(name = "rules_categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RulesCategories.findAll", query = "SELECT r FROM RulesCategories r"),
    @NamedQuery(name = "RulesCategories.findById", query = "SELECT r FROM RulesCategories r WHERE r.id = :id"),
    @NamedQuery(name = "RulesCategories.findByTitle", query = "SELECT r FROM RulesCategories r WHERE r.title = :title"),
    @NamedQuery(name = "RulesCategories.findByStatus", query = "SELECT r FROM RulesCategories r WHERE r.status = :status")})
public class RulesCategories implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;

    public RulesCategories() {
    }

    public RulesCategories(Integer id) {
        this.id = id;
    }

    public RulesCategories(Integer id, String title, int status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        if (!(object instanceof RulesCategories)) {
            return false;
        }
        RulesCategories other = (RulesCategories) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.RulesCategories[ id=" + id + " ]";
    }
    
}
