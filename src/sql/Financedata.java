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
@Table(name = "financedata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Financedata.findAll", query = "SELECT f FROM Financedata f"),
    @NamedQuery(name = "Financedata.findById", query = "SELECT f FROM Financedata f WHERE f.id = :id"),
    @NamedQuery(name = "Financedata.findByMonth", query = "SELECT f FROM Financedata f WHERE f.month = :month"),
    @NamedQuery(name = "Financedata.findByYear", query = "SELECT f FROM Financedata f WHERE f.year = :year"),
    @NamedQuery(name = "Financedata.findByTotal", query = "SELECT f FROM Financedata f WHERE f.total = :total")})
public class Financedata implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "month")
    private int month;
    @Basic(optional = false)
    @Column(name = "year")
    private int year;
    @Basic(optional = false)
    @Lob
    @Column(name = "data")
    private String data;
    @Basic(optional = false)
    @Column(name = "total")
    private float total;

    public Financedata() {
    }

    public Financedata(Integer id) {
        this.id = id;
    }

    public Financedata(Integer id, int month, int year, String data, float total) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.data = data;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
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
        if (!(object instanceof Financedata)) {
            return false;
        }
        Financedata other = (Financedata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Financedata[ id=" + id + " ]";
    }
    
}
