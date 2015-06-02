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
@Table(name = "rules")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rules.findAll", query = "SELECT r FROM Rules r"),
    @NamedQuery(name = "Rules.findById", query = "SELECT r FROM Rules r WHERE r.id = :id"),
    @NamedQuery(name = "Rules.findByRule", query = "SELECT r FROM Rules r WHERE r.rule = :rule"),
    @NamedQuery(name = "Rules.findByCategory", query = "SELECT r FROM Rules r WHERE r.category = :category"),
    @NamedQuery(name = "Rules.findByStatus", query = "SELECT r FROM Rules r WHERE r.status = :status")})
public class Rules implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "rule")
    private String rule;
    @Basic(optional = false)
    @Column(name = "category")
    private int category;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;

    public Rules() {
    }

    public Rules(Integer id) {
        this.id = id;
    }

    public Rules(Integer id, String rule, int category, int status) {
        this.id = id;
        this.rule = rule;
        this.category = category;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
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
        if (!(object instanceof Rules)) {
            return false;
        }
        Rules other = (Rules) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Rules[ id=" + id + " ]";
    }
    
}
