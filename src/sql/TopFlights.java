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
@Table(name = "top_flights")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TopFlights.findAll", query = "SELECT t FROM TopFlights t"),
    @NamedQuery(name = "TopFlights.findById", query = "SELECT t FROM TopFlights t WHERE t.id = :id"),
    @NamedQuery(name = "TopFlights.findByPilotId", query = "SELECT t FROM TopFlights t WHERE t.pilotId = :pilotId"),
    @NamedQuery(name = "TopFlights.findByFlights", query = "SELECT t FROM TopFlights t WHERE t.flights = :flights"),
    @NamedQuery(name = "TopFlights.findByHours", query = "SELECT t FROM TopFlights t WHERE t.hours = :hours"),
    @NamedQuery(name = "TopFlights.findByMiles", query = "SELECT t FROM TopFlights t WHERE t.miles = :miles"),
    @NamedQuery(name = "TopFlights.findByMonth", query = "SELECT t FROM TopFlights t WHERE t.month = :month"),
    @NamedQuery(name = "TopFlights.findByYear", query = "SELECT t FROM TopFlights t WHERE t.year = :year")})
public class TopFlights implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "pilot_id")
    private int pilotId;
    @Basic(optional = false)
    @Column(name = "flights")
    private int flights;
    @Basic(optional = false)
    @Column(name = "hours")
    private int hours;
    @Basic(optional = false)
    @Column(name = "miles")
    private int miles;
    @Basic(optional = false)
    @Column(name = "month")
    private int month;
    @Basic(optional = false)
    @Column(name = "year")
    private int year;

    public TopFlights() {
    }

    public TopFlights(Integer id) {
        this.id = id;
    }

    public TopFlights(Integer id, int pilotId, int flights, int hours, int miles, int month, int year) {
        this.id = id;
        this.pilotId = pilotId;
        this.flights = flights;
        this.hours = hours;
        this.miles = miles;
        this.month = month;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPilotId() {
        return pilotId;
    }

    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
    }

    public int getFlights() {
        return flights;
    }

    public void setFlights(int flights) {
        this.flights = flights;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TopFlights)) {
            return false;
        }
        TopFlights other = (TopFlights) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.TopFlights[ id=" + id + " ]";
    }
    
}
