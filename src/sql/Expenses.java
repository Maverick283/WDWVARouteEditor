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
@Table(name = "expenses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expenses.findAll", query = "SELECT e FROM Expenses e"),
    @NamedQuery(name = "Expenses.findById", query = "SELECT e FROM Expenses e WHERE e.id = :id"),
    @NamedQuery(name = "Expenses.findByName", query = "SELECT e FROM Expenses e WHERE e.name = :name"),
    @NamedQuery(name = "Expenses.findByCost", query = "SELECT e FROM Expenses e WHERE e.cost = :cost"),
    @NamedQuery(name = "Expenses.findByFixed", query = "SELECT e FROM Expenses e WHERE e.fixed = :fixed"),
    @NamedQuery(name = "Expenses.findByType", query = "SELECT e FROM Expenses e WHERE e.type = :type")})
public class Expenses implements Serializable {
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
    @Column(name = "cost")
    private float cost;
    @Basic(optional = false)
    @Column(name = "fixed")
    private int fixed;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;

    public Expenses() {
    }

    public Expenses(Integer id) {
        this.id = id;
    }

    public Expenses(Integer id, String name, float cost, int fixed, String type) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.fixed = fixed;
        this.type = type;
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

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getFixed() {
        return fixed;
    }

    public void setFixed(int fixed) {
        this.fixed = fixed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(object instanceof Expenses)) {
            return false;
        }
        Expenses other = (Expenses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Expenses[ id=" + id + " ]";
    }
    
}
