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
@Table(name = "airports")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Airports.findAll", query = "SELECT a FROM Airports a"),
    @NamedQuery(name = "Airports.findById", query = "SELECT a FROM Airports a WHERE a.id = :id"),
    @NamedQuery(name = "Airports.findByIcao", query = "SELECT a FROM Airports a WHERE a.icao = :icao"),
    @NamedQuery(name = "Airports.findByCountry", query = "SELECT a FROM Airports a WHERE a.country = :country"),
    @NamedQuery(name = "Airports.findByLat", query = "SELECT a FROM Airports a WHERE a.lat = :lat"),
    @NamedQuery(name = "Airports.findByLng", query = "SELECT a FROM Airports a WHERE a.lng = :lng"),
    @NamedQuery(name = "Airports.findByHub", query = "SELECT a FROM Airports a WHERE a.hub = :hub"),
    @NamedQuery(name = "Airports.findByFuelprice", query = "SELECT a FROM Airports a WHERE a.fuelprice = :fuelprice")})
public class Airports implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "icao")
    private String icao;
    @Basic(optional = false)
    @Lob
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "country")
    private String country;
    @Basic(optional = false)
    @Column(name = "lat")
    private float lat;
    @Basic(optional = false)
    @Column(name = "lng")
    private float lng;
    @Basic(optional = false)
    @Column(name = "hub")
    private short hub;
    @Basic(optional = false)
    @Column(name = "fuelprice")
    private float fuelprice;
    @Basic(optional = false)
    @Lob
    @Column(name = "chartlink")
    private String chartlink;

    public Airports() {
    }

    public Airports(Integer id) {
        this.id = id;
    }

    public Airports(Integer id, String icao, String name, String country, float lat, float lng, short hub, float fuelprice, String chartlink) {
        this.id = id;
        this.icao = icao;
        this.name = name;
        this.country = country;
        this.lat = lat;
        this.lng = lng;
        this.hub = hub;
        this.fuelprice = fuelprice;
        this.chartlink = chartlink;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public short getHub() {
        return hub;
    }

    public void setHub(short hub) {
        this.hub = hub;
    }

    public float getFuelprice() {
        return fuelprice;
    }

    public void setFuelprice(float fuelprice) {
        this.fuelprice = fuelprice;
    }

    public String getChartlink() {
        return chartlink;
    }

    public void setChartlink(String chartlink) {
        this.chartlink = chartlink;
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
        if (!(object instanceof Airports)) {
            return false;
        }
        Airports other = (Airports) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "worldwide.airline.route.editor.Airports[ id=" + id + " ]";
    }
    
}
